package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class LuaDetector : AbstractLanguageDetector(
  name = "Lua",
  type = LanguageType.LUA,
  ".lua",
)
