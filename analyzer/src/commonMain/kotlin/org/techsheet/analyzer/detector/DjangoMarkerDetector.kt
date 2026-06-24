package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType
import org.techsheet.analyzer.domain.Matcher

class DjangoMarkerDetector : AbstractFileMarkerFrameworkDetector(
  name = "Django (manage.py)",
  framework = FrameworkType.DJANGO,
  marker = Matcher.Filename("manage.py"),
)
