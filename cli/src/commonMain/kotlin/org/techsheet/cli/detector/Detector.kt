package org.techsheet.cli.detector

import org.techsheet.cli.domain.AnalyzerContext
import org.techsheet.cli.domain.TechSheet

abstract class Detector(val name: String) {

  abstract fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet
}
