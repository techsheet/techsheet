package org.techsheet.cli

import co.touchlab.kermit.Logger
import okio.FileSystem
import okio.Path
import okio.SYSTEM

data class AnalyzerContext(
  val path: Path,
  val log: Logger,
  val fs: FileSystem = FileSystem.SYSTEM,
  val maxDepth: Int = 10,
) {

  private val files = fs
    .listRecursively(path)
    .filter { candidate ->
      val segments = candidate.relativeTo(path).segments
      (segments.size - 1) <= maxDepth && segments.none(IGNORED_DIR_SEGMENTS::contains)
    }
    .filter { fs.metadataOrNull(it)?.isRegularFile == true }

  //TODO: Use files to find stuff instead of walking full project file-tree on every detector

  fun hasFile(relative: String): Boolean = fs.exists(path / relative)

  fun readFileContents(relative: String): String? = readFileContents(path / relative)

  fun readFileContents(target: Path): String? =
    if (fs.exists(target)) {
      fs.read(target) { readUtf8() }
    } else {
      null
    }

  @Deprecated("Don't walk FS on every detector")
  fun walk(maxDepth: Int): Sequence<Path> = fs
    .listRecursively(path)
    .filter { candidate ->
      val segments = candidate.relativeTo(path).segments
      (segments.size - 1) <= maxDepth && segments.none(IGNORED_DIR_SEGMENTS::contains)
    }
    .filter { fs.metadataOrNull(it)?.isRegularFile == true }

  companion object {
    // Noise directories that no detector should look into.
    private val IGNORED_DIR_SEGMENTS = setOf(
      "node_modules",
      ".git",
      ".gradle",
      ".idea",
      "build",
      "target",
      "dist",
      "out",
      "venv",
      ".venv",
      "__pycache__",
    )
  }
}
