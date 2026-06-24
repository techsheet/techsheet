package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class LuaDetector : AbstractLanguageDetector(
  name = "Lua",
  type = LanguageType.LUA,
  ".lua",
)
