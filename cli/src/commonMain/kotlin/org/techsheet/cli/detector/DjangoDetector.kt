package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet

class DjangoDetector : AbstractPythonDependencyDetector(
  name = "Django",
  framework = FrameworkType.DJANGO,
  packageName = "django",
) {

  // `manage.py` is a definitive Django marker — every project scaffolded by
  // `django-admin startproject` ships one, even when dependencies are pinned
  // elsewhere (Poetry env, system install, Docker-only setups).
  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    super.detect(ctx, sheet).let { updated ->
      if (updated == sheet && ctx.walk(depth).any { it.name == "manage.py" })
        sheet.withFramework(FrameworkType.DJANGO, version = null)
      else updated
    }
}
