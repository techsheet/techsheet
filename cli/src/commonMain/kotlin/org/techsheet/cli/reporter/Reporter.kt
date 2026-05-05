package org.techsheet.cli.reporter

import okio.FileSystem
import okio.Path
import okio.SYSTEM
import org.techsheet.cli.domain.ToolEntry

abstract class Reporter(
  private val fs: FileSystem
) {

  abstract fun serialize(): String

  open fun report(targetFile: Path) {
    targetFile.parent?.also { fs.createDirectories(it) }
    fs.write(targetFile) { writeUtf8(serialize()) }
  }

  open fun output() = print(serialize())

  companion object {
    internal val LANGUAGE_SECTION_HEADERS = listOf("Name", "Version", "ID", "Notes")
    internal val FRAMEWORK_SECTION_HEADERS = listOf("Name", "Version", "Category", "ID", "Notes")
    internal val SERVICE_SECTION_HEADERS = listOf("Name", "Version", "Category", "ID", "Notes")
    internal val TOOL_SECTION_HEADERS = listOf("Name", "Version", "Category", "ID", "Notes")
  }
}

internal fun ToolEntry.displayName(): String = flavor?.let { "$name ($it)" } ?: name
