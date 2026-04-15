package org.techsheet.cli.domain

data class TechSheet(
  val buildTools: List<BuildTool> = emptyList(),
  val programmingLanguage: List<ProgrammingLanguage> = emptyList(),
) {

  fun withBuildTool(buildTool: BuildTool): TechSheet =
    copy(buildTools = buildTools + buildTool)

  fun withBuildTool(type: BuildToolType, version: String? = null): TechSheet =
    withBuildTool(BuildTool(type = type, version = version))

  fun withProgrammingLanguage(language: ProgrammingLanguage): TechSheet =
    copy(programmingLanguage = programmingLanguage + language)

  fun withProgrammingLanguage(type: ProgrammingLanguageType, version: String? = null): TechSheet =
    withProgrammingLanguage(ProgrammingLanguage(type = type, version = version))

  companion object {
    fun empty() = TechSheet()
  }
}
