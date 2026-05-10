package org.techsheet.cli.reporter

import okio.FileSystem

/**
 * Reporter that reports nothing
 */
class NoopReporter(
    fs: FileSystem,
) : Reporter(fs) {

  override fun serialize(): String = ""
}
