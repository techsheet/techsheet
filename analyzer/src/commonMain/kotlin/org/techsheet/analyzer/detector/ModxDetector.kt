package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType
import org.techsheet.analyzer.domain.Matcher

class ModxDetector : AbstractFileMarkerFrameworkDetector(
  name = "MODX",
  framework = FrameworkType.MODX,
  // modx.class.php is the MODX core class — uniquely-named, always present in core.
  marker = Matcher.Filename("modx.class.php"),
)
