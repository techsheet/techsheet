package org.techsheet.cli

import java.nio.file.Files
import java.nio.file.Path

abstract class AbstractCommandTest {

  protected fun emptyDir(): String =
    Files.createTempDirectory("techsheet-cmd-test").toString()

  protected fun tempFile(name: String): Path =
    Files.createTempDirectory("techsheet-cmd-test").resolve(name)
}
