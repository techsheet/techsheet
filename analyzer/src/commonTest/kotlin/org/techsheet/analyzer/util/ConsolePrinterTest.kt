package org.techsheet.analyzer.util

import com.github.ajalt.mordant.rendering.AnsiLevel
import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.terminal.TerminalRecorder
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.FrameworkType
import org.techsheet.analyzer.domain.LanguageType
import org.techsheet.analyzer.domain.ServiceType
import org.techsheet.analyzer.domain.ToolType
import org.techsheet.analyzer.util.ConsolePrinter
import kotlin.test.Test
import kotlin.test.assertContains

class ConsolePrinterTest {

  val techSheet = DetectionResult()
    .withLanguage(LanguageType.KOTLIN, "2.3.20")
    .withLanguage(LanguageType.TYPESCRIPT)
    .withFramework(FrameworkType.SPRING_BOOT, "4.0.0")
    .withFramework(FrameworkType.SPRING_WEBFLUX)
    .withFramework(FrameworkType.SPRING_DATA)
    .withService(ServiceType.POSTGRES)
    .withTool(ToolType.INTELLIJ_IDEA)
    .toTechSheet()

  @Test
  fun `prints formatted report`() {
    val output = recordOutput(AnsiLevel.TRUECOLOR) {
      it.printReport(techSheet)
    }

    assertContains(output, "\u001B[36m─────\u001B[39m \u001B[96;1mTechSheet\u001B[39;22m \u001B[3;2mv")
    assertContains(output, "\u001B[93;1mLanguages\u001B[39;22m \u001B[33;3m(2)\u001B[39;23m")
    assertContains(output, "\u001B[97m  Kotlin\u001B[39m \u001B[37;3m2.3.20\u001B[39;23m")
    assertContains(output, "\u001B[93;1mFrameworks\u001B[39;22m \u001B[33;3m(3)\u001B[39;23m")
    assertContains(output, "\u001B[92;1m Application\u001B[39;22m \u001B[32;3m(2)\u001B[39;23m")
    assertContains(output, "\u001B[36m──────────────────────────────────────────────────────────────\u001B[39m")
  }

  @Test
  fun `prints unformatted report`() {
    val output = recordOutput(AnsiLevel.NONE) {
      it.printReport(techSheet)
    }

    assertContains(output, "───── TechSheet v")
    assertContains(output, "Languages (2)")
    assertContains(output, " Kotlin 2.3.20")
    assertContains(output, "Frameworks (3)")
    assertContains(output, " Application (2)")
    assertContains(output, "──────────────────────────────────────────────────────────────")
  }
  private fun recordOutput(ansiLevel: AnsiLevel, block: (ConsolePrinter) -> Unit): String {
    val recorder = TerminalRecorder()

    val terminal = Terminal(
      terminalInterface = recorder,
      ansiLevel = ansiLevel,
      width = 120,
      nonInteractiveWidth = 120
    )
    val printer = ConsolePrinter(terminal)

    block(printer)

    return recorder.output()
  }
}
