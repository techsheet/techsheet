package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher

abstract class Detector(val name: String, vararg matchers: Matcher) {

  val matchers: List<Matcher> = matchers.toList()

  open fun skipIf(path: Path, result: DetectionResult): Boolean = false

  abstract fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult
}
