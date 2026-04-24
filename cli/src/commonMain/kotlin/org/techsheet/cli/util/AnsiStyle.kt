package org.techsheet.cli.util

internal class AnsiStyle(private val plain: Boolean) {

  fun cyan(s: String): String = wrap(s, "\u001B[36m")
  fun yellowBold(s: String): String = wrap(s, "\u001B[1;33m")
  fun green(s: String): String = wrap(s, "\u001B[32m")
  fun dim(s: String): String = wrap(s, "\u001B[2m")

  private fun wrap(s: String, code: String): String =
    if (plain) s else "$code$s$RESET"

  companion object {
    private const val RESET = "\u001B[0m"
    private val ANSI = Regex("\u001B\\[[0-9;]*m")
    fun visibleLength(s: String): Int = ANSI.replace(s, "").length
  }
}
