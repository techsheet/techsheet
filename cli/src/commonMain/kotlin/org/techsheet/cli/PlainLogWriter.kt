package org.techsheet.cli

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.Severity

/**
 * Log writer that prints just the message — no timestamp, tag, or severity prefix.
 * Used by the CLI so the analysis output reads like plain prose rather than a log.
 */
class PlainLogWriter : LogWriter() {
  override fun log(severity: Severity, message: String, tag: String, throwable: Throwable?) {
    println(message)
    throwable?.let { println(it.stackTraceToString()) }
  }
}
