package org.techsheet.cli.domain

data class TechSheet(
  val buildTools: List<BuildTool> = emptyList(),
  val programmingLanguage: List<ProgrammingLanguage> = emptyList(),
) {

  fun withBuildTool(buildTool: BuildTool): TechSheet =
    copy(buildTools = buildTools + buildTool)

  fun withProgrammingLanguage(language: ProgrammingLanguage): TechSheet =
    copy(programmingLanguage = programmingLanguage + language)

  companion object {
    fun empty() = TechSheet()
  }
}
