package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import okio.FileSystem
import okio.ForwardingFileSystem
import okio.Path
import okio.Path.Companion.toOkioPath
import org.techsheet.cli.detectorv2.Detector
import org.techsheet.cli.detectorv2.Detectors
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
import java.nio.file.Files
import kotlin.test.Test
import kotlin.test.assertEquals

class AnalyzerDispatchTest {

  private val silent = Logger(StaticConfig(minSeverity = Severity.Assert), tag = "test")

  private fun projectWith(name: String, contents: String): Path =
    Files.createTempDirectory("analyzer-dispatch-").toOkioPath()
      .also { FileSystem.SYSTEM.write(it / name) { writeUtf8(contents) } }

  private class CountingFs(var reads: Int = 0) : ForwardingFileSystem(FileSystem.SYSTEM) {
    override fun source(file: Path) = super.source(file).also { reads++ }
  }

  @Test fun `content is not read when no detector forces it`() {
    val root = projectWith("pom.xml", "<project/>")

    class Observer : Detector("observer", Matcher.Filename("pom.xml")) {
      override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet = sheet
    }

    val fs = CountingFs()
    Analyzer(silent, Detectors(listOf(Observer()))).analyze(AnalyzerContext(root, silent, fs))

    assertEquals(0, fs.reads, "no detector forced content; fs.source must not have been called on pom.xml")
  }

  @Test fun `content is read once when multiple detectors consume it`() {
    val root = projectWith("pom.xml", "<project/>")

    class A : Detector("a", Matcher.Filename("pom.xml")) {
      override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
        sheet.also { content.value }
    }
    class B : Detector("b", Matcher.Filename("pom.xml")) {
      override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
        sheet.also { content.value }
    }

    val fs = CountingFs()
    Analyzer(silent, Detectors(listOf(A(), B()))).analyze(AnalyzerContext(root, silent, fs))

    assertEquals(1, fs.reads, "two detectors shared one Lazy; fs.source must be called exactly once")
  }
}
