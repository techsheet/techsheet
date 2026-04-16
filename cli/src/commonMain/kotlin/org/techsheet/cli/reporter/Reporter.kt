package org.techsheet.cli.reporter

import org.techsheet.cli.domain.TechSheet

interface Reporter {

  fun report(sheet: TechSheet)
}
