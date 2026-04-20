package org.techsheet.cli

import co.touchlab.kermit.Logger
import okio.FileMetadata
import okio.Path
import org.techsheet.cli.detectorv2.*
import org.techsheet.cli.domain.TechSheet

class Analyzer(
  private val log: Logger,
  private val detectors: List<Detector> = ALL_DETECTORS,
) {

  fun analyze(ctx: AnalyzerContext): TechSheet =
    DispatchIndex(detectors).let { index ->
      walkFromRoot(ctx).fold(TechSheet.empty()) { sheet, entry ->
        dispatch(ctx, index, entry, sheet)
      }
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

  private fun dispatch(
    ctx: AnalyzerContext,
    index: DispatchIndex,
    entry: WalkEntry,
    sheet: TechSheet,
  ): TechSheet = hitsFor(ctx, index, entry)
    .takeIf { it.isNotEmpty() }
    ?.let { hits ->
      val content = contentOf(ctx, entry)
      hits.fold(sheet) { acc, d -> applyDetector(d, entry.path, content, acc) }
    }
    ?: sheet

  private fun hitsFor(ctx: AnalyzerContext, index: DispatchIndex, entry: WalkEntry): List<Detector> =
    entry.path.relativeTo(ctx.path).segments.joinToString("/").let { relative ->
      when {
        entry.metadata.isRegularFile -> index.forFile(relative, entry.path.name, extensionOf(entry.path.name))
        entry.metadata.isDirectory == true -> index.forDirectory(relative)
        else -> emptyList()
      }
    }

  private fun contentOf(ctx: AnalyzerContext, entry: WalkEntry): Lazy<String?> = lazy {
    entry.takeIf { it.metadata.isRegularFile }?.let { readUtf8OrWarn(ctx, it.path) }
  }

  private fun readUtf8OrWarn(ctx: AnalyzerContext, path: Path): String? =
    runCatching { ctx.fs.read(path) { readUtf8() } }
      .onFailure { log.w(it) { "Failed to read $path; continuing without content" } }
      .getOrNull()

  private fun applyDetector(d: Detector, path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    if (d.skipIf(path, sheet)) {
      sheet.also { log.d { "Detector ${d.name} skipped $path" } }
    } else {
      d.onMatch(path, content, sheet).also { log.d { "Detector ${d.name} matched $path" } }
    }

  private fun extensionOf(name: String): String? =
    name.lastIndexOf('.')
      .takeIf { it > 0 }
      ?.let(name::substring)

  companion object {
    private val IGNORED_DIR_SEGMENTS = setOf(
      "node_modules", ".git", ".gradle", ".idea", "build", "target", "dist", "out",
      "venv", ".venv", "__pycache__",
    )

    val ALL_DETECTORS: List<Detector> = listOf(
      GradleDetector(),
      MavenDetector(),
      JavaDetector(),
      KotlinDetector(),
      ScalaDetector(),
      JavaScriptDetector(),
      TypeScriptDetector(),
      PythonDetector(),
      CppDetector(),
      CSharpDetector(),
      JavaVersionDetector(),
      JVMDetector(),
      KotlinVersionDetector(),
      ScalaVersionDetector(),
      TypeScriptVersionDetector(),
      PythonVersionDetector(),
      GitLabCiDetector(),
      GitHubActionsDetector(),
      CodeOwnersDetector(),
      DockerDetector(),
      DockerComposeDetector(),
      EditorConfigDetector(),
      RenovateDetector(),
      NpmDetector(),
      YarnDetector(),
      NodeDetector(),
      SbtDetector(),
      AngularDetector(),
      ReactDetector(),
      VueDetector(),
      SvelteDetector(),
      NextDetector(),
      ExpressDetector(),
      QtDetector(),
      AspNetCoreDetector(),
      TailwindDetector(),
      EslintDetector(),
      PrettierDetector(),
      SpringDetector(),
      PlayDetector(),
      DjangoDetector(),
      DjangoMarkerDetector(),
      FlaskDetector(),
      FastApiDetector(),
      PlaywrightDetector(),
      JUnitDetector(),
      GitDetector(),
      IntelliJIdeaDetector(),
      VsCodeDetector(),
    )
  }
}
