package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.Matcher

class JoomlaDetector : AbstractFileMarkerFrameworkDetector(
  name = "Joomla",
  framework = FrameworkType.JOOMLA,
  // administrator/manifests/files/joomla.xml is the Joomla core extension manifest:
  // <name>files_joomla</name> ... <version>X.Y.Z</version>. Always committed.
  marker = Matcher.Filename("joomla.xml"),
  contentMatch = Regex(
    """<name>\s*files_joomla\s*</name>[\s\S]*?<version>\s*([^<\s]+)\s*</version>""",
    RegexOption.IGNORE_CASE,
  ),
)
