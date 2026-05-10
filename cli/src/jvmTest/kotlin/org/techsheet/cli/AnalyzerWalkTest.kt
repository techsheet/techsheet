package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toOkioPath
import org.techsheet.cli.detector.Detector
import org.techsheet.cli.detector.Detectors
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType
import java.nio.file.Files
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AnalyzerWalkTest {

  private val silent = Logger(StaticConfig(minSeverity = Severity.Assert), tag = "test")

  private fun tempProject(prepare: (Path) -> Unit): Path =
    Files.createTempDirectory("analyzer-walk-").toOkioPath().also(prepare)

  private fun writeFile(path: Path, contents: String = "") {
    path.parent?.let(FileSystem.SYSTEM::createDirectories)
    FileSystem.SYSTEM.write(path) { writeUtf8(contents) }
  }

  @Test fun `ignored directories are not enumerated`() {
    val root = tempProject { dir ->
      writeFile(dir / "node_modules" / "tripwire.json", """{ "tripwire": true }""")
      writeFile(dir / "src" / "main.kt", "fun main() {}")
    }

    class Tripwire : Detector("tripwire", Matcher.Filename("tripwire.json")) {
      var hit = false
      override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
        result.also { hit = true }
    }
    val tw = Tripwire()

    Analyzer(silent, Detectors(listOf(tw))).analyze(AnalyzerContext(root, silent))
    assertEquals(false, tw.hit, "node_modules contents must not be dispatched")
  }

  @Test fun `DirectoryAt fires even when the directory is ignored for descent`() {
    val root = tempProject { dir ->
      writeFile(dir / ".idea" / "workspace.xml", "<x/>")
    }

    class Idea : Detector("idea", Matcher.DirectoryAt(".idea")) {
      override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
        result.withTool(ToolType.INTELLIJ_IDEA)
    }

    val result = Analyzer(silent, Detectors(listOf(Idea()))).analyze(AnalyzerContext(root, silent))
    assertTrue(result.hasTool(ToolType.INTELLIJ_IDEA), "DirectoryAt('.idea') must fire on root .idea")
  }
}
