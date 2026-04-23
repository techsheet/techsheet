package org.techsheet.cli.util

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AnsiStyleTest {

  @Test
  fun `fancy mode wraps text in ANSI codes and resets`() {
    val s = AnsiStyle(plain = false)
    val out = s.cyan("hello")
    assertTrue(out.startsWith("\u001B[36m"), "expected cyan prefix, got: $out")
    assertTrue(out.endsWith("\u001B[0m"), "expected reset suffix, got: $out")
    assertTrue(out.contains("hello"))
  }

  @Test
  fun `plain mode returns text unchanged`() {
    val s = AnsiStyle(plain = true)
    assertEquals("hello", s.cyan("hello"))
    assertEquals("hello", s.yellowBold("hello"))
    assertEquals("hello", s.green("hello"))
    assertEquals("hello", s.dim("hello"))
  }

  @Test
  fun `visibleLength strips ANSI sequences before measuring`() {
    val colored = AnsiStyle(plain = false).cyan("hello")
    assertEquals(5, AnsiStyle.visibleLength(colored))
    assertEquals(5, AnsiStyle.visibleLength("hello"))
    assertEquals(0, AnsiStyle.visibleLength(""))
  }

  @Test
  fun `visibleLength handles concatenated styled segments`() {
    val s = AnsiStyle(plain = false)
    val combined = s.cyan("ab") + " " + s.dim("cd")
    assertEquals(5, AnsiStyle.visibleLength(combined))
  }

  @Test
  fun `plain wraps add no codes anywhere`() {
    val s = AnsiStyle(plain = true)
    val out = s.cyan("a") + s.dim("b") + s.green("c")
    assertFalse(out.contains("\u001B"), "plain output must contain no escape sequences: $out")
  }
}
