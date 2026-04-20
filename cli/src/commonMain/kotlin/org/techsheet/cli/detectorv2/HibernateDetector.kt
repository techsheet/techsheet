package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class HibernateDetector : AbstractJvmDependencyDetector(
  name = "Hibernate",
  framework = FrameworkType.HIBERNATE,
  coordinates = listOf(
    // Hibernate 6.x+ moved to `org.hibernate.orm`; `org.hibernate` still covers 5.x and below.
    Coordinate("org.hibernate.orm"),
    Coordinate("org.hibernate"),
  ),
  pluginIds = listOf("org.hibernate.orm"),
)
