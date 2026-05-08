package org.techsheet.cli

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.Severity
import com.github.ajalt.mordant.terminal.Terminal

/**
 * Log writer that prints just the message — no timestamp, tag, or severity prefix.
 * Used by the CLI so the analysis output reads like plain prose rather than a log.
 */
class PlainLogWriter(private val terminal: Terminal) : LogWriter() {
  override fun log(severity: Severity, message: String, tag: String, throwable: Throwable?) {
    terminal.println(message)
    throwable?.let { terminal.println(it.stackTraceToString()) }
  }
}
