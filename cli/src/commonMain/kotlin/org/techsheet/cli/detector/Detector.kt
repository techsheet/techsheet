package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult

abstract class Detector(val name: String, vararg matchers: Matcher) {

  val matchers: List<Matcher> = matchers.toList()

  open fun skipIf(path: Path, result: DetectionResult): Boolean = false

  abstract fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult
}
