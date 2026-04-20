package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.TechSheet

abstract class Detector(val name: String) {

  abstract val matchers: List<Matcher>

  open fun skipIf(path: Path, sheet: TechSheet): Boolean = false

  abstract fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet
}
