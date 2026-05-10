package org.techsheet.cli

import co.touchlab.kermit.Logger
import okio.FileMetadata
import okio.Path
import org.techsheet.cli.detector.*
import org.techsheet.cli.domain.DetectionResult

class Analyzer(
  private val log: Logger,
  private val detectors: Detectors = Detectors(),
) {

  fun analyze(ctx: AnalyzerContext): DetectionResult =
    walkFromRoot(ctx).fold(DetectionResult()) { acc, entry ->
      dispatch(ctx, entry, acc)
    }

  private data class WalkEntry(val path: Path, val metadata: FileMetadata)

  private fun walkFromRoot(ctx: AnalyzerContext): Sequence<WalkEntry> = walkDir(ctx, ctx.path)

  private fun walkDir(ctx: AnalyzerContext, dir: Path): Sequence<WalkEntry> =
    ctx.fs.list(dir).asSequence()
      .mapNotNull { child -> ctx.fs.metadataOrNull(child)?.let { WalkEntry(child, it) } }
      .flatMap { entry ->
        when {
          entry.metadata.isDirectory == true -> sequenceOf(entry) +
            entry.takeIf { it.path.name !in IGNORED_DIR_SEGMENTS }
              ?.let { walkDir(ctx, it.path) }
              .orEmpty()
          entry.metadata.isRegularFile -> sequenceOf(entry)
          else -> emptySequence()
        }
      }

  private fun dispatch(ctx: AnalyzerContext, entry: WalkEntry, current: DetectionResult): DetectionResult =
    entry.path.relativeTo(ctx.path).segments.joinToString("/").let { relative ->
      log.d { displayPath(relative, entry.metadata) }
      hitsFor(entry, relative)
        .takeIf { it.isNotEmpty() }
        ?.let { hits ->
          val content = contentOf(ctx, entry)
          hits.fold(current) { acc, d -> applyDetector(d, entry.path, content, acc) }
        }
        ?: current.also { log.d { " - No matching detectors" } }
    }

  private fun hitsFor(entry: WalkEntry, relative: String): List<Detector> = when {
    entry.metadata.isRegularFile -> detectors.forFile(relative, entry.path.name, extensionOf(entry.path.name))
    entry.metadata.isDirectory == true -> detectors.forDirectory(relative)
    else -> emptyList()
  }

  private fun displayPath(relative: String, metadata: FileMetadata): String =
    if (metadata.isDirectory == true) "Analyzing: ./$relative/" else "Analyzing: ./$relative"

  private fun contentOf(ctx: AnalyzerContext, entry: WalkEntry): Lazy<String?> = lazy {
    entry.takeIf { it.metadata.isRegularFile }?.let { readUtf8OrWarn(ctx, it.path) }
  }

  private fun readUtf8OrWarn(ctx: AnalyzerContext, path: Path): String? =
    runCatching { ctx.fs.read(path) { readUtf8() } }
      .onFailure { log.w(it) { "Failed to read $path; continuing without content" } }
      .getOrNull()

  private fun applyDetector(d: Detector, path: Path, content: Lazy<String?>, current: DetectionResult): DetectionResult =
    if (d.skipIf(path, current)) {
      current.also { log.d { " - Skipping detector: ${d.name}" } }
    } else {
      d.onMatch(path, content, current).also { log.d { " - Running detector: ${d.name}" } }
    }

  private fun extensionOf(name: String): String? =
    name.lastIndexOf('.')
      .takeIf { it > 0 }
      ?.let(name::substring)

  companion object {
    // TODO: We should take this to a seperate place and make it configurable
    private val IGNORED_DIR_SEGMENTS = setOf(
      "node_modules", ".git", ".gradle", ".idea", "build", "target", "dist", "out",
      "venv", ".venv", "__pycache__",
    )
  }
}
