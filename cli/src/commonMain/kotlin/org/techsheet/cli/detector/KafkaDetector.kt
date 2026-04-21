package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class KafkaDetector : AbstractJvmDependencyDetector(
  name = "Apache Kafka",
  framework = FrameworkType.KAFKA,
  coordinates = listOf(Coordinate("org.apache.kafka")),
)
