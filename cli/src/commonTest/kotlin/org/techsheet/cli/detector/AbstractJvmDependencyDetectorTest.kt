package org.techsheet.cli.detector

import okio.Path.Companion.toPath
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

private const val SPRING_GROUP = "org.springframework.boot"
private const val SPRING_ARTIFACT = "spring-boot-starter"
private const val SPRING_PLUGIN = "org.springframework.boot"

private class TestDetector(
  coordinates: List<Coordinate>,
  pluginIds: List<String> = emptyList(),
) : AbstractJvmDependencyDetector(
  name = "Test",
  framework = FrameworkType.SPRING_BOOT,
  coordinates = coordinates,
  pluginIds = pluginIds,
)

private fun analyze(
  filename: String,
  content: String,
  coordinates: List<Coordinate> = listOf(Coordinate(SPRING_GROUP, SPRING_ARTIFACT)),
  pluginIds: List<String> = emptyList(),
): TechSheet = TestDetector(coordinates, pluginIds)
  .onMatch(filename.toPath(), lazy { content }, TechSheet.empty())

private fun TechSheet.springBootVersion(): String? =
  frameworks.firstOrNull { it.type == FrameworkType.SPRING_BOOT }?.version

private fun TechSheet.hasSpringBoot(): Boolean = hasFramework(FrameworkType.SPRING_BOOT)

class AbstractJvmDependencyDetectorTest {

  // ---------- Maven POM ----------

  @Test fun `pom detects dependency with inline version`() {
    val pom = """
      <project>
        <dependencies>
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>3.2.0</version>
          </dependency>
        </dependencies>
      </project>
    """.trimIndent()
    assertEquals("3.2.0", analyze("pom.xml", pom).springBootVersion())
  }

  @Test fun `pom resolves version from properties block`() {
    val pom = """
      <project>
        <properties>
          <spring-boot.version>3.2.1</spring-boot.version>
        </properties>
        <dependencies>
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>${"$"}{spring-boot.version}</version>
          </dependency>
        </dependencies>
      </project>
    """.trimIndent()
    assertEquals("3.2.1", analyze("pom.xml", pom).springBootVersion())
  }

  @Test fun `pom detects parent block`() {
    val pom = """
      <project>
        <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>3.5.0</version>
        </parent>
      </project>
    """.trimIndent()
    val sheet = analyze(
      "pom.xml", pom,
      coordinates = listOf(Coordinate(SPRING_GROUP, "spring-boot-starter-parent")),
    )
    assertEquals("3.5.0", sheet.springBootVersion())
  }

  @Test fun `pom group-only coordinate matches any artifact in group`() {
    val pom = """
      <project>
        <dependencies>
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webmvc</artifactId>
            <version>4.0.0</version>
          </dependency>
        </dependencies>
      </project>
    """.trimIndent()
    val sheet = analyze(
      "pom.xml", pom,
      coordinates = listOf(Coordinate(SPRING_GROUP, artifactId = null)),
    )
    assertEquals("4.0.0", sheet.springBootVersion())
  }

  @Test fun `pom version missing yields null but still emits framework`() {
    val pom = """
      <project>
        <dependencies>
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
          </dependency>
        </dependencies>
      </project>
    """.trimIndent()
    val sheet = analyze("pom.xml", pom)
    assertTrue(sheet.hasSpringBoot())
    assertNull(sheet.springBootVersion())
  }

  @Test fun `pom skips unrelated coordinates`() {
    val pom = """
      <project>
        <dependencies>
          <dependency>
            <groupId>com.example</groupId>
            <artifactId>foo</artifactId>
            <version>1.0.0</version>
          </dependency>
        </dependencies>
      </project>
    """.trimIndent()
    assertFalse(analyze("pom.xml", pom).hasSpringBoot())
  }

  @Test fun `pom unresolvable property reference yields null version`() {
    val pom = """
      <project>
        <dependencies>
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>${"$"}{missing.version}</version>
          </dependency>
        </dependencies>
      </project>
    """.trimIndent()
    val sheet = analyze("pom.xml", pom)
    assertTrue(sheet.hasSpringBoot())
    assertNull(sheet.springBootVersion())
  }

  // ---------- Gradle (Kotlin DSL + Groovy DSL) ----------

  @Test fun `gradle kts coordinate with inline version`() {
    val script = """
      dependencies {
        implementation("org.springframework.boot:spring-boot-starter:3.2.0")
      }
    """.trimIndent()
    assertEquals("3.2.0", analyze("build.gradle.kts", script).springBootVersion())
  }

  @Test fun `gradle kts coordinate without version`() {
    val script = """
      dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
      }
    """.trimIndent()
    val sheet = analyze("build.gradle.kts", script)
    assertTrue(sheet.hasSpringBoot())
    assertNull(sheet.springBootVersion())
  }

  @Test fun `gradle kts resolves dollar-var reference`() {
    val script = """
      val springBootVersion = "3.3.0"
      dependencies {
        implementation("org.springframework.boot:spring-boot-starter:${"$"}springBootVersion")
      }
    """.trimIndent()
    assertEquals("3.3.0", analyze("build.gradle.kts", script).springBootVersion())
  }

  @Test fun `gradle kts resolves curly-dollar-var reference`() {
    val script = """
      val springBootVersion = "3.3.1"
      dependencies {
        implementation("org.springframework.boot:spring-boot-starter:${"$"}{springBootVersion}")
      }
    """.trimIndent()
    assertEquals("3.3.1", analyze("build.gradle.kts", script).springBootVersion())
  }

  @Test fun `gradle groovy resolves def-var reference`() {
    val script = """
      def springBootVersion = "3.3.2"
      dependencies {
        implementation "org.springframework.boot:spring-boot-starter:${"$"}springBootVersion"
      }
    """.trimIndent()
    assertEquals("3.3.2", analyze("build.gradle", script).springBootVersion())
  }

  @Test fun `gradle plugin id with single-quoted groovy version`() {
    val script = """
      plugins {
        id 'org.springframework.boot' version '4.0.5'
      }
    """.trimIndent()
    val sheet = analyze("build.gradle", script, coordinates = emptyList(), pluginIds = listOf(SPRING_PLUGIN))
    assertEquals("4.0.5", sheet.springBootVersion())
  }

  @Test fun `gradle plugin id with inline version`() {
    val script = """
      plugins {
        id("org.springframework.boot") version "3.2.0"
      }
    """.trimIndent()
    val sheet = analyze("build.gradle.kts", script, coordinates = emptyList(), pluginIds = listOf(SPRING_PLUGIN))
    assertEquals("3.2.0", sheet.springBootVersion())
  }

  @Test fun `gradle plugin id without version still emits framework`() {
    val script = """
      plugins {
        id("org.springframework.boot")
      }
    """.trimIndent()
    val sheet = analyze("build.gradle.kts", script, coordinates = emptyList(), pluginIds = listOf(SPRING_PLUGIN))
    assertTrue(sheet.hasSpringBoot())
    assertNull(sheet.springBootVersion())
  }

  @Test fun `gradle group-only coordinate matches any artifact`() {
    val script = """
      dependencies {
        implementation("org.springframework.boot:spring-boot-starter-webflux:4.0.5")
      }
    """.trimIndent()
    val sheet = analyze(
      "build.gradle.kts", script,
      coordinates = listOf(Coordinate(SPRING_GROUP)),
    )
    assertEquals("4.0.5", sheet.springBootVersion())
  }

  @Test fun `gradle alias reference does not match group-id`() {
    // alias(libs.plugins.springBoot) — no coordinate string, no id() call. Should NOT emit.
    val script = """
      plugins {
        alias(libs.plugins.springBoot)
      }
    """.trimIndent()
    val sheet = analyze("build.gradle.kts", script, coordinates = emptyList(), pluginIds = listOf(SPRING_PLUGIN))
    assertFalse(sheet.hasSpringBoot())
  }

  @Test fun `gradle ignores unrelated coordinates`() {
    val script = """
      dependencies {
        implementation("com.example:foo:1.0.0")
      }
    """.trimIndent()
    assertFalse(analyze("build.gradle.kts", script).hasSpringBoot())
  }

  // ---------- Version catalog (libs.versions.toml) ----------

  @Test fun `catalog library with group and name and inline version`() {
    val toml = """
      [libraries]
      springBootStarter = { group = "org.springframework.boot", name = "spring-boot-starter", version = "3.2.0" }
    """.trimIndent()
    assertEquals("3.2.0", analyze("libs.versions.toml", toml).springBootVersion())
  }

  @Test fun `catalog library with module and version-ref resolves via versions block`() {
    val toml = """
      [versions]
      springBoot = "3.2.5"

      [libraries]
      springBootStarter = { module = "org.springframework.boot:spring-boot-starter", version.ref = "springBoot" }
    """.trimIndent()
    assertEquals("3.2.5", analyze("libs.versions.toml", toml).springBootVersion())
  }

  @Test fun `catalog plugin with id and version-ref`() {
    val toml = """
      [versions]
      sb = "4.0.5"

      [plugins]
      springBoot = { id = "org.springframework.boot", version.ref = "sb" }
    """.trimIndent()
    val sheet = analyze(
      "libs.versions.toml", toml,
      coordinates = emptyList(),
      pluginIds = listOf(SPRING_PLUGIN),
    )
    assertEquals("4.0.5", sheet.springBootVersion())
  }

  @Test fun `catalog plugin with id and inline version`() {
    val toml = """
      [plugins]
      springBoot = { id = "org.springframework.boot", version = "3.1.0" }
    """.trimIndent()
    val sheet = analyze(
      "libs.versions.toml", toml,
      coordinates = emptyList(),
      pluginIds = listOf(SPRING_PLUGIN),
    )
    assertEquals("3.1.0", sheet.springBootVersion())
  }

  @Test fun `catalog multi-line inline table is parsed`() {
    val toml = """
      [versions]
      springBoot = "3.2.7"

      [libraries]
      springBootStarter = {
        group = "org.springframework.boot",
        name = "spring-boot-starter",
        version.ref = "springBoot"
      }
    """.trimIndent()
    assertEquals("3.2.7", analyze("libs.versions.toml", toml).springBootVersion())
  }

  @Test fun `catalog missing version-ref target yields null version`() {
    val toml = """
      [libraries]
      springBootStarter = { module = "org.springframework.boot:spring-boot-starter", version.ref = "nope" }
    """.trimIndent()
    val sheet = analyze("libs.versions.toml", toml)
    assertTrue(sheet.hasSpringBoot())
    assertNull(sheet.springBootVersion())
  }

  @Test fun `catalog unrelated entries are skipped`() {
    val toml = """
      [versions]
      other = "1.0.0"

      [libraries]
      other = { module = "com.example:foo", version.ref = "other" }
    """.trimIndent()
    assertFalse(analyze("libs.versions.toml", toml).hasSpringBoot())
  }

  // ---------- sbt ----------

  @Test fun `sbt percent syntax`() {
    val build = """
      libraryDependencies += "org.springframework.boot" % "spring-boot-starter" % "3.2.0"
    """.trimIndent()
    assertEquals("3.2.0", analyze("build.sbt", build).springBootVersion())
  }

  @Test fun `sbt double-percent syntax with Scala-version append`() {
    val build = """
      libraryDependencies += "org.typelevel" %% "cats-core" % "2.10.0"
    """.trimIndent()
    val sheet = analyze(
      "build.sbt", build,
      coordinates = listOf(Coordinate("org.typelevel", "cats-core")),
    )
    assertEquals("2.10.0", sheet.springBootVersion())
  }

  @Test fun `sbt plugins file detects addSbtPlugin`() {
    val plugins = """
      addSbtPlugin("org.playframework" % "sbt-plugin" % "3.0.1")
    """.trimIndent()
    val sheet = analyze(
      "plugins.sbt", plugins,
      coordinates = listOf(Coordinate("org.playframework", "sbt-plugin")),
    )
    assertEquals("3.0.1", sheet.springBootVersion())
  }

  @Test fun `sbt group-only coordinate matches any artifact`() {
    val build = """
      libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "3.4.0"
    """.trimIndent()
    val sheet = analyze(
      "build.sbt", build,
      coordinates = listOf(Coordinate(SPRING_GROUP)),
    )
    assertEquals("3.4.0", sheet.springBootVersion())
  }

  @Test fun `sbt ignores unrelated coordinates`() {
    val build = """
      libraryDependencies += "com.example" % "foo" % "1.0.0"
    """.trimIndent()
    assertFalse(analyze("build.sbt", build).hasSpringBoot())
  }

  // ---------- cross-source ----------

  @Test fun `smart merge keeps higher version across multiple file visits`() {
    val detector = TestDetector(listOf(Coordinate(SPRING_GROUP, SPRING_ARTIFACT)))
    val pomLow = """
      <project>
        <dependencies>
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>3.1.0</version>
          </dependency>
        </dependencies>
      </project>
    """.trimIndent()
    val gradleHigh = """
      dependencies {
        implementation("org.springframework.boot:spring-boot-starter:3.2.5")
      }
    """.trimIndent()
    val afterPom = detector.onMatch("pom.xml".toPath(), lazy { pomLow }, TechSheet.empty())
    val afterBoth = detector.onMatch("build.gradle.kts".toPath(), lazy { gradleHigh }, afterPom)
    assertEquals("3.2.5", afterBoth.springBootVersion())
  }

  @Test fun `null content is a no-op`() {
    val detector = TestDetector(listOf(Coordinate(SPRING_GROUP, SPRING_ARTIFACT)))
    val result = detector.onMatch("pom.xml".toPath(), lazy<String?> { null }, TechSheet.empty())
    assertFalse(result.hasSpringBoot())
  }
}
