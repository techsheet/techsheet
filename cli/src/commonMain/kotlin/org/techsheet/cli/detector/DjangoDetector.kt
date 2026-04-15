package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechnologyType

class DjangoDetector : AbstractPythonDependencyDetector(
  name = "Django",
  technology = TechnologyType.DJANGO,
  packageName = "django",
) {

  // `manage.py` is a definitive Django marker — every project scaffolded by
  // `django-admin startproject` ships one, even when dependencies are pinned
  // elsewhere (Poetry env, system install, Docker-only setups).
  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    super.detect(ctx, sheet).let { updated ->
      if (updated == sheet && ctx.walk(depth).any { it.name == "manage.py" })
        sheet.withTechnology(TechnologyType.DJANGO, version = null)
      else updated
    }
}
