package org.techsheet.docs

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import org.techsheet.analyzer.domain.DetectedTechnology
import org.techsheet.analyzer.domain.FrameworkType
import org.techsheet.analyzer.domain.LanguageType
import org.techsheet.analyzer.domain.ServiceType
import org.techsheet.analyzer.domain.ToolType
import java.io.File

private val yaml = Yaml(configuration = YamlConfiguration(strictMode = false))

fun main(args: Array<String>) {
  val technologyDir = File(args[0])
  val readmePath = File(args[1])
  val docsIndexPath = File(args[2])

  val allTechnologies: List<DetectedTechnology> = buildList {
    addAll(LanguageType.entries)
    addAll(ToolType.entries)
    addAll(FrameworkType.entries)
    addAll(ServiceType.entries)
  }

  val byType = allTechnologies.groupBy { it.type }
  val expectedFilesByType = mutableMapOf<String, MutableSet<String>>()

  for (tech in allTechnologies) {
    val typeDir = File(technologyDir, tech.type)
    typeDir.mkdirs()
    expectedFilesByType.getOrPut(tech.type) { mutableSetOf() }.add("${tech.key}.md")

    val file = File(typeDir, "${tech.key}.md")
    val frontMatter = buildFrontMatter(tech)

    if (file.exists()) {
      val existing = parseFrontMatter(file.readText())
      frontMatter.techsheet.related = existing?.techsheet?.related
      file.writeText(encodeFrontMatter(frontMatter) + extractBody(file.readText()))
      println("Updated: ${file.toRelativeString(technologyDir)}")
    } else {
      file.writeText(encodeFrontMatter(frontMatter) + "\n")
      println("Created: ${file.toRelativeString(technologyDir)}")
    }
  }

  writeIndexFiles(technologyDir, byType)
  cleanupOrphans(technologyDir, expectedFilesByType)
  updateDetectorCounts(readmePath)
  updateDetectorCounts(docsIndexPath)
}

@Serializable
data class TechFrontMatter(
  val title: String,
  val aliases: List<String>,
  val bookToC: Boolean = false,
  val techsheet: TechsheetMeta,
)

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class TechsheetMeta(
  val key: String,
  val type: String,
  @EncodeDefault(EncodeDefault.Mode.NEVER) val category: String? = null,
  @EncodeDefault(EncodeDefault.Mode.NEVER) val languages: List<String>? = null,
  @EncodeDefault(EncodeDefault.Mode.NEVER) var related: List<RelatedTechnology>? = null,
)

@Serializable
data class RelatedTechnology(
  val type: String,
  val key: String,
  val comment: String,
)

private fun buildFrontMatter(tech: DetectedTechnology): TechFrontMatter {
  val meta = TechsheetMeta(
    key = tech.key,
    type = tech.type,
    category = when (tech) {
      is ToolType -> tech.category.title
      is FrameworkType -> tech.category.title
      is ServiceType -> tech.category.title
      else -> null
    },
    languages = (tech as? FrameworkType)
      ?.languages?.takeIf { it.isNotEmpty() }
      ?.map { it.key },
  )
  return TechFrontMatter(
    title = tech.title,
    aliases = listOf("/${tech.type}/${tech.key}"),
    techsheet = meta,
  )
}

private fun encodeFrontMatter(fm: TechFrontMatter): String =
  "---\n" + yaml.encodeToString(TechFrontMatter.serializer(), fm) + "\n---\n"

private fun parseFrontMatter(content: String): TechFrontMatter? {
  val raw = content.substringAfter("---\n", "").substringBefore("\n---", "")
  if (raw.isBlank()) return null
  return try {
    yaml.decodeFromString(TechFrontMatter.serializer(), raw)
  } catch (_: Exception) {
    null
  }
}

private fun extractBody(content: String): String {
  val afterFirst = content.substringAfter("---\n", "")
  val afterSecond = afterFirst.substringAfter("---\n", "")
  return afterSecond.ifEmpty { afterFirst.substringAfter("---", "") }
}

private fun writeIndexFiles(technologyDir: File, byType: Map<String, List<DetectedTechnology>>) {
  writeIndexFile(File(technologyDir, "language"), "Languages", 10, byType["language"] ?: emptyList())
  writeIndexFile(File(technologyDir, "framework"), "Frameworks", 20, byType["framework"] ?: emptyList())
  writeIndexFile(File(technologyDir, "tool"), "Tools", 30, byType["tool"] ?: emptyList())
  writeIndexFile(File(technologyDir, "service"), "Services", 40, byType["service"] ?: emptyList())
}

private fun writeIndexFile(dir: File, title: String, weight: Int, technologies: List<DetectedTechnology>) {
  dir.mkdirs()
  val sorted = technologies.sortedBy { it.title.lowercase() }
  File(dir, "_index.md").writeText(buildString {
    appendLine("---")
    appendLine("weight: $weight")
    appendLine("bookCollapseSection: true")
    appendLine("---")
    appendLine()
    appendLine("# $title")
    appendLine()
    appendLine("*This section contains all ${title.lowercase()} detected by the TechSheet Analyzer.*")
    appendLine()
    sorted.forEach { appendLine("- [${it.title}](${it.key}.md)") }
  })
  println("Updated index: ${dir.name}/_index.md")
}

private fun cleanupOrphans(technologyDir: File, expectedFilesByType: Map<String, Set<String>>) {
  for ((type, expected) in expectedFilesByType) {
    val typeDir = File(technologyDir, type)
    if (!typeDir.isDirectory) continue
    typeDir.listFiles()
      ?.filter { it.isFile && it.extension == "md" && it.name != "_index.md" && it.name !in expected }
      ?.forEach {
        it.delete()
        println("Deleted: ${it.toRelativeString(technologyDir)}")
      }
  }
}

private fun updateDetectorCounts(file: File) {
  val languages = LanguageType.entries.size
  val frameworks = FrameworkType.entries.size
  val tools = ToolType.entries.size

  val content = file.readText()
  val updated = content
    .replace(Regex("""\[\d+\+ languages]"""), "[${languages}+ languages]")
    .replace(Regex("""\[\d+\+ frameworks]"""), "[${frameworks}+ frameworks]")
    .replace(Regex("""\[\d+\+ tools]"""), "[${tools}+ tools]")

  if (updated != content) {
    file.writeText(updated)
    println("Updated counts in ${file.name}: $languages languages, $frameworks frameworks, $tools tools")
  }
}
