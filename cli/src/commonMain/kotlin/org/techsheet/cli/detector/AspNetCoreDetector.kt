package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechnologyType

class AspNetCoreDetector : Detector("ASP.NET Core") {

  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .filter { it.name.endsWith(".csproj") }
      .mapNotNull(ctx::readFileContents)
      .joinToString("\n")
      .takeIf { it.isNotEmpty() && (WEB_SDK.containsMatchIn(it) || ASPNETCORE_FRAMEWORK.containsMatchIn(it)) }
      ?.let { content ->
        sheet.withTechnology(
          TechnologyType.ASP_NET_CORE,
          version = TARGET_FRAMEWORK.find(content)?.groupValues?.get(1),
        )
      }
      ?: sheet

  companion object {
    private val WEB_SDK = Regex("""Sdk\s*=\s*["']Microsoft\.NET\.Sdk\.Web["']""")
    private val ASPNETCORE_FRAMEWORK =
      Regex("""FrameworkReference\s+Include\s*=\s*["']Microsoft\.AspNetCore\.App["']""")
    private val TARGET_FRAMEWORK =
      Regex("""<TargetFramework>\s*net(\d+\.\d+)\s*</TargetFramework>""")
  }
}
