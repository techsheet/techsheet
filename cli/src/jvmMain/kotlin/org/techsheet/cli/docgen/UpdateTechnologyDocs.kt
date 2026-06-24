package org.techsheet.cli.docgen

import org.techsheet.cli.domain.*
import java.io.File

fun main(args: Array<String>) {
  val docsRoot = File(args.firstOrNull() ?: error("needs exactly one arg"))

  val allTechnologies: List<DetectedTechnology> = buildList {
    addAll(LanguageType.entries)
    addAll(ToolType.entries)
    addAll(FrameworkType.entries)
    addAll(ServiceType.entries)
  }

  val byType = allTechnologies.groupBy { it.type }
  val expectedFilesByType = mutableMapOf<String, MutableSet<String>>()

  for (tech in allTechnologies) {
    val typeDir = File(docsRoot, tech.type)
    typeDir.mkdirs()
    expectedFilesByType.getOrPut(tech.type) { mutableSetOf() }.add("${tech.key}.md")

    val file = File(typeDir, "${tech.key}.md")
    val frontMatter = generateFrontMatter(tech)

    if (file.exists()) {
      val body = extractBody(file.readText())
      file.writeText(frontMatter + body)
      println("Updated: ${file.toRelativeString(docsRoot)}")
    } else {
      file.writeText(frontMatter + "\n")
      println("Created: ${file.toRelativeString(docsRoot)}")
    }
  }

  writeIndexFile(File(docsRoot, "language"), "Languages", 10, byType["language"] ?: emptyList())
  writeIndexFile(File(docsRoot, "framework"), "Frameworks", 20, byType["framework"] ?: emptyList())
  writeIndexFile(File(docsRoot, "tool"), "Tools", 30, byType["tool"] ?: emptyList())
  writeIndexFile(File(docsRoot, "service"), "Services", 40, byType["service"] ?: emptyList())

  for ((type, expected) in expectedFilesByType) {
    val typeDir = File(docsRoot, type)
    if (!typeDir.isDirectory) continue
    typeDir.listFiles()
      ?.filter { it.isFile && it.extension == "md" && it.name != "_index.md" && it.name !in expected }
      ?.forEach {
        it.delete()
        println("Deleted: ${it.toRelativeString(docsRoot)}")
      }
  }
}

private fun generateFrontMatter(tech: DetectedTechnology): String = buildString {
  appendLine("---")
  appendLine("title: ${yamlString(tech.title)}")
  appendLine("aliases:")
  appendLine("  - /${tech.type}/${tech.key}")
  appendLine("bookToC: false")
  appendLine("techsheet:")
  appendLine("  key: ${tech.key}")
  appendLine("  type: ${tech.type}")
  when (tech) {
    is ToolType -> appendLine("  category: ${tech.category.title}")
    is FrameworkType -> {
      appendLine("  category: ${tech.category.title}")
      if (tech.languages.isNotEmpty()) {
        appendLine("  languages:")
        tech.languages.forEach { appendLine("    - ${it.key}") }
      }
    }
    is ServiceType -> appendLine("  category: ${tech.category.title}")
  }
  appendLine("---")
}

private fun extractBody(content: String): String {
  val lines = content.lines()
  if (lines.isEmpty() || lines[0].trim() != "---") return content

  for (i in 1 until lines.size) {
    if (lines[i].trim() == "---") {
      return lines.subList(i + 1, lines.size).joinToString("\n")
    }
  }
  return content
}

private fun writeIndexFile(dir: File, title: String, weight: Int, technologies: List<DetectedTechnology>) {
  dir.mkdirs()
  val indexFile = File(dir, "_index.md")
  val sorted = technologies.sortedBy { it.title.lowercase() }
  indexFile.writeText(buildString {
    appendLine("---")
    appendLine("weight: $weight")
    appendLine("bookCollapseSection: true")
    appendLine("---")
    appendLine()
    appendLine("# $title")
    appendLine()
    appendLine("*This section contains all ${title.lowercase()} detected by the TechSheet CLI.*")
    appendLine()
    for (tech in sorted) {
      appendLine("- [${tech.title}](${tech.key}/)")
    }
  })
  println("Updated index: ${indexFile.toRelativeString(dir.parentFile)}")
}

private val YAML_SPECIAL = setOf(':', '#', '{', '}', '[', ']', '&', '*', '?', '|', '>', '!', '%', '@', '"', '\'')

private fun yamlString(s: String): String {
  if (s.any { it in YAML_SPECIAL }) {
    return "\"${s.replace("\\", "\\\\").replace("\"", "\\\"")}\""
  }
  return s
}
