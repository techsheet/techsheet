package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class KafkaDetector : AbstractJvmDependencyDetector(
  name = "Apache Kafka",
  framework = FrameworkType.KAFKA,
  coordinates = listOf(Coordinate("org.apache.kafka")),
)
