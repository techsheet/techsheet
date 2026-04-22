package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.Matcher

class DjangoMarkerDetector : AbstractFileMarkerFrameworkDetector(
  name = "Django (manage.py)",
  framework = FrameworkType.DJANGO,
  marker = Matcher.Filename("manage.py"),
)
