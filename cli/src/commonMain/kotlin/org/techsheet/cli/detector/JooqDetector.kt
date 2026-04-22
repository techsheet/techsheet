package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class JooqDetector : AbstractJvmFrameworkDetector(
  name = "jOOQ",
  framework = FrameworkType.JOOQ,
  coordinates = listOf(Coordinate("org.jooq")),
  pluginIds = listOf("nu.studer.jooq", "org.jooq.jooq-codegen-gradle"),
)
