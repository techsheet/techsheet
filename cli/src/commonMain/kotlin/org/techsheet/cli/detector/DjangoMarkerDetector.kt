package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet

class DjangoMarkerDetector : Detector("Django (manage.py)", Matcher.Filename("manage.py")) {

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasFramework(FrameworkType.DJANGO)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withFramework(FrameworkType.DJANGO)
}
