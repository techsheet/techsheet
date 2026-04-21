package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet

class AspNetCoreDetector : Detector("ASP.NET Core", Matcher.Extension(".csproj")) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.takeIf { WEB_SDK.containsMatchIn(it) || ASPNETCORE_FRAMEWORK.containsMatchIn(it) }
      ?.let { text ->
        sheet.withFramework(
          FrameworkType.ASP_NET_CORE,
          version = TARGET_FRAMEWORK.find(text)?.groupValues?.getOrNull(1),
        )
      }
      ?: sheet

  private companion object {
    val WEB_SDK = Regex("""Sdk\s*=\s*["']Microsoft\.NET\.Sdk\.Web["']""")
    val ASPNETCORE_FRAMEWORK =
      Regex("""FrameworkReference\s+Include\s*=\s*["']Microsoft\.AspNetCore\.App["']""")
    val TARGET_FRAMEWORK =
      Regex("""<TargetFramework>\s*net(\d+\.\d+)\s*</TargetFramework>""")
  }
}
