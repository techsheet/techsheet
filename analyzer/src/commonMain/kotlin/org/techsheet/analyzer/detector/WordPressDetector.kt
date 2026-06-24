package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType
import org.techsheet.analyzer.domain.Matcher

class WordPressDetector : AbstractFileMarkerFrameworkDetector(
  name = "WordPress",
  framework = FrameworkType.WORDPRESS,
  // wp-includes/version.php is part of WP core, not gitignored, and pins the WP release.
  marker = Matcher.Filename("version.php"),
  contentMatch = Regex("""\${'$'}wp_version\s*=\s*['"]([^'"]+)['"]"""),
)
