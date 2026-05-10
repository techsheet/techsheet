package org.techsheet.cli.reporter

import okio.FileSystem
import okio.Path
import org.techsheet.schema.Tool

abstract class Reporter(
  private val fs: FileSystem,
) {

  abstract fun serialize(): String

  open fun report(targetFile: Path) {
    targetFile.parent?.also { fs.createDirectories(it) }
    fs.write(targetFile) { writeUtf8(serialize()) }
  }

  companion object {
    internal val LANGUAGE_SECTION_HEADERS = listOf("Name", "Version", "ID", "Notes")
    internal val FRAMEWORK_SECTION_HEADERS = listOf("Name", "Version", "Category", "ID", "Notes")
    internal val SERVICE_SECTION_HEADERS = listOf("Name", "Version", "Category", "ID", "Notes")
    internal val TOOL_SECTION_HEADERS = listOf("Name", "Version", "Category", "ID", "Notes")
  }
}

internal fun Tool.displayName(): String = flavor?.let { "$name ($it)" } ?: name
