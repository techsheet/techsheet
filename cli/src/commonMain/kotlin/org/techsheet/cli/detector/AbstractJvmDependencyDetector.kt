package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet

/**
 * Detects technologies by matching [coordinates] and/or [pluginIds] in JVM build tools, i.e. pom.xml or build.gradle.kts
 *
 * Prefer specific implementations like [AbstractJvmFrameworkDetector] over this.
 */
abstract class AbstractJvmDependencyDetector(
  name: String,
  private val apply: (TechSheet, String?) -> TechSheet,
  private val coordinates: List<Coordinate>,
  private val pluginIds: List<String> = emptyList(),
) : Detector(
  name,
  Matcher.Filename("pom.xml"),
  Matcher.Filename("build.gradle.kts"),
  Matcher.Filename("settings.gradle.kts"),
  Matcher.Filename("build.gradle"),
  Matcher.Filename("settings.gradle"),
  Matcher.Filename("libs.versions.toml"),
  Matcher.Filename("build.sbt"),
  Matcher.Filename("plugins.sbt"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value?.let { text ->
      when (path.name) {
        "pom.xml" -> parsePom(text, sheet)
        "libs.versions.toml" -> parseCatalog(text, sheet)
        "build.sbt", "plugins.sbt" -> parseSbt(text, sheet)
        else -> parseGradle(text, sheet)
      }
    } ?: sheet

  // ---------- Maven POM ----------

  private fun parsePom(text: String, sheet: TechSheet): TechSheet =
    POM_BLOCK
      .findAll(text)
      .map { it.groupValues[1] }
      .filter { block -> coordinates.any { matchesPomBlock(it, block) } }
      .toList()
      .takeIf { it.isNotEmpty() }
      ?.let { blocks ->
        val props = pomProperties(text)
        blocks.fold(sheet) { acc, block ->
          apply(acc, resolvePomVersion(block, props))
        }
      }
      ?: sheet

  private fun matchesPomBlock(coord: Coordinate, block: String): Boolean =
    Regex("""<groupId>\s*${Regex.escape(coord.groupId)}\s*</groupId>""").containsMatchIn(block)
      && (coord.artifactId == null
        || Regex("""<artifactId>\s*${Regex.escape(coord.artifactId)}\s*</artifactId>""").containsMatchIn(block))

  private fun resolvePomVersion(block: String, properties: Map<String, String>): String? =
    POM_VERSION_IN_BLOCK.find(block)
      ?.groupValues?.getOrNull(1)
      ?.trim()
      ?.takeIf { it.isNotEmpty() }
      ?.let { raw ->
        POM_PROPERTY_REF.matchEntire(raw)
          ?.let { match -> properties[match.groupValues[1]] }
          ?: raw.takeUnless { POM_PROPERTY_REF.matches(it) }
      }

  private fun pomProperties(text: String): Map<String, String> =
    POM_PROPERTIES_BLOCK.find(text)?.groupValues?.getOrNull(1)
      ?.let { propsBlock ->
        POM_PROPERTY_ENTRY.findAll(propsBlock)
          .associate { it.groupValues[1] to it.groupValues[2].trim() }
      }
      ?: emptyMap()

  // ---------- Gradle (Kotlin DSL + Groovy DSL) ----------

  private fun parseGradle(text: String, sheet: TechSheet): TechSheet =
    (coordinates.asSequence().flatMap { coord ->
      // Groups: 1 = quote char, 2 = version (optional).
      gradleCoordinateRegex(coord).findAll(text).map { it.groupValues.getOrNull(2)?.trim() }
    } + pluginIds.asSequence().flatMap { id ->
      // Groups: 1 = id quote, 2 = version quote, 3 = version (optional).
      gradlePluginRegex(id).findAll(text).map { it.groupValues.getOrNull(3)?.trim() }
    })
      .toList()
      .takeIf { it.isNotEmpty() }
      ?.let { hits ->
        val props = gradleProperties(text)
        hits.fold(sheet) { acc, raw -> apply(acc, resolveGradleVersion(raw, props)) }
      }
      ?: sheet

  private fun gradleCoordinateRegex(coord: Coordinate): Regex {
    val group = Regex.escape(coord.groupId)
    val artifact = coord.artifactId?.let(Regex::escape) ?: """[^"':]+"""
    // Groovy DSL accepts either single or double quotes for string literals.
    return Regex("""(['"])$group:$artifact(?::([^"']*))?\1""")
  }

  private fun gradlePluginRegex(pluginId: String): Regex =
    Regex(
      """id\s*\(?\s*(['"])${Regex.escape(pluginId)}\1(?:\s*\))?(?:\s+version\s+(['"])([^'"]+)\2)?""",
    )

  private fun gradleProperties(text: String): Map<String, String> =
    GRADLE_VAL.findAll(text).associate { it.groupValues[1] to it.groupValues[2] }

  private fun resolveGradleVersion(raw: String?, props: Map<String, String>): String? =
    raw?.takeIf { it.isNotEmpty() }?.let { value ->
      GRADLE_VAR_REF.matchEntire(value)?.groupValues?.getOrNull(1)?.let(props::get)
        ?: value
    }

  // ---------- Gradle version catalog (libs.versions.toml) ----------

  private fun parseCatalog(text: String, sheet: TechSheet): TechSheet =
    (catalogLibraryVersions(text) + catalogPluginVersions(text))
      .toList()
      .takeIf { it.isNotEmpty() }
      ?.fold(sheet) { acc, version -> apply(acc, version) }
      ?: sheet

  private fun catalogLibraryVersions(text: String): Sequence<String?> =
    catalogEntries(text, TOML_LIBRARIES_SECTION)
      .filter { body -> coordinates.any { matchesCatalogLibrary(it, body) } }
      .map { body -> resolveCatalogVersion(body, catalogVersions(text)) }

  private fun catalogPluginVersions(text: String): Sequence<String?> =
    catalogEntries(text, TOML_PLUGINS_SECTION)
      .filter { body -> pluginIds.any { matchesCatalogPlugin(it, body) } }
      .map { body -> resolveCatalogVersion(body, catalogVersions(text)) }

  private fun catalogEntries(text: String, section: Regex): Sequence<String> =
    section.find(text)?.groupValues?.getOrNull(1)
      ?.let { TOML_ENTRY.findAll(it).map { m -> m.groupValues[2] } }
      ?: emptySequence()

  private fun catalogVersions(text: String): Map<String, String> =
    TOML_VERSIONS_SECTION.find(text)?.groupValues?.getOrNull(1)
      ?.let { block -> TOML_VERSION_ENTRY.findAll(block).associate { it.groupValues[1] to it.groupValues[2] } }
      ?: emptyMap()

  private fun matchesCatalogLibrary(coord: Coordinate, body: String): Boolean {
    val group = CATALOG_GROUP.find(body)?.groupValues?.getOrNull(1)
    val name = CATALOG_NAME.find(body)?.groupValues?.getOrNull(1)
    val moduleParts = CATALOG_MODULE.find(body)?.groupValues?.getOrNull(1)?.split(':', limit = 2)
    val actualGroup = group ?: moduleParts?.getOrNull(0)
    val actualArtifact = name ?: moduleParts?.getOrNull(1)
    return actualGroup == coord.groupId
      && (coord.artifactId == null || actualArtifact == coord.artifactId)
  }

  private fun matchesCatalogPlugin(pluginId: String, body: String): Boolean =
    CATALOG_ID.find(body)?.groupValues?.getOrNull(1) == pluginId

  private fun resolveCatalogVersion(body: String, versions: Map<String, String>): String? =
    CATALOG_VERSION_LITERAL.find(body)?.groupValues?.getOrNull(1)
      ?: CATALOG_VERSION_REF.find(body)?.groupValues?.getOrNull(1)?.let(versions::get)

  // ---------- sbt ----------

  private fun parseSbt(text: String, sheet: TechSheet): TechSheet =
    coordinates.asSequence()
      .flatMap { coord -> sbtCoordinateRegex(coord).findAll(text).map { it.groupValues[1] } }
      .toList()
      .takeIf { it.isNotEmpty() }
      ?.fold(sheet) { acc, version -> apply(acc, version) }
      ?: sheet

  private fun sbtCoordinateRegex(coord: Coordinate): Regex {
    val group = Regex.escape(coord.groupId)
    val artifact = coord.artifactId?.let(Regex::escape) ?: """[A-Za-z][\w.-]*"""
    return Regex(""""$group"\s*%%?\s*"$artifact"\s*%\s*"([^"]+)"""")
  }

  private companion object {
    // Maven: each <dependency>/<parent>/<plugin> block carries groupId/artifactId/version.
    val POM_BLOCK = Regex("""<(?:dependency|parent|plugin)>([\s\S]*?)</(?:dependency|parent|plugin)>""")
    val POM_PROPERTIES_BLOCK = Regex("""<properties>([\s\S]*?)</properties>""")
    val POM_PROPERTY_ENTRY = Regex("""<([A-Za-z][\w.-]*)>\s*([^<]*?)\s*</\1>""")
    val POM_VERSION_IN_BLOCK = Regex("""<version>\s*([^<]+?)\s*</version>""")
    val POM_PROPERTY_REF = Regex("""\$\{([^}]+)\}""")

    // Gradle: `val springBootVersion = "3.2.0"` style declarations, referenced as `$x` or `${x}`.
    val GRADLE_VAL = Regex("""(?:val|var|def)\s+(\w+)\s*=\s*"([^"]+)"""")
    val GRADLE_VAR_REF = Regex("""\$\{?(\w+)\}?""")

    // Version catalog: TOML sections. `[^}]+` in TOML_ENTRY allows multi-line inline tables.
    val TOML_VERSIONS_SECTION = Regex("""\[versions\]([\s\S]*?)(?=\n\[|\Z)""")
    val TOML_LIBRARIES_SECTION = Regex("""\[libraries\]([\s\S]*?)(?=\n\[|\Z)""")
    val TOML_PLUGINS_SECTION = Regex("""\[plugins\]([\s\S]*?)(?=\n\[|\Z)""")
    val TOML_VERSION_ENTRY = Regex("""^\s*([A-Za-z][\w-]*)\s*=\s*"([^"]+)"""", RegexOption.MULTILINE)
    val TOML_ENTRY = Regex("""^\s*([A-Za-z][\w-]*)\s*=\s*\{([^}]+)\}""", RegexOption.MULTILINE)

    val CATALOG_GROUP = Regex("""\bgroup\s*=\s*"([^"]+)"""")
    val CATALOG_NAME = Regex("""\bname\s*=\s*"([^"]+)"""")
    val CATALOG_MODULE = Regex("""\bmodule\s*=\s*"([^"]+)"""")
    val CATALOG_ID = Regex("""\bid\s*=\s*"([^"]+)"""")
    // `version = "..."` but NOT `version.ref = "..."`.
    val CATALOG_VERSION_LITERAL = Regex("""(?<![\w.])version\b\s*=\s*"([^"]+)"""")
    val CATALOG_VERSION_REF = Regex("""\bversion\.ref\s*=\s*"([^"]+)"""")
  }
}

data class Coordinate(val groupId: String, val artifactId: String? = null)
