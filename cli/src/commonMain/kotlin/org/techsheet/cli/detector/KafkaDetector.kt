package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class KafkaDetector : AbstractJvmFrameworkDetector(
  name = "Apache Kafka",
  framework = FrameworkType.KAFKA,
  coordinates = listOf(Coordinate("org.apache.kafka")),
)
