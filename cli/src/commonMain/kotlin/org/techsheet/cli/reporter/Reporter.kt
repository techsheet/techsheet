package org.techsheet.cli.reporter

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet

interface Reporter {

  fun report(ctx: AnalyzerContext, sheet: TechSheet)
}
