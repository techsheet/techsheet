package org.techsheet.cli.domain

import co.touchlab.kermit.Logger
import okio.FileSystem
import okio.Path
import okio.SYSTEM

data class AnalyzerContext(
  val path: Path,
  val log: Logger,
  val fs: FileSystem = FileSystem.SYSTEM,
) {

  fun hasFile(relative: String): Boolean = fs.exists(path / relative)

  fun readFileContents(relative: String): String? = readFileContents(path / relative)

  fun readFileContents(target: Path): String? =
    if (fs.exists(target)) fs.read(target) { readUtf8() } else null

  fun walk(maxDepth: Int): Sequence<Path> = fs
    .listRecursively(path)
    .filter { (it.relativeTo(path).segments.size - 1) <= maxDepth }
    .filter { fs.metadataOrNull(it)?.isRegularFile == true }
}
