package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class KafkaDetector : AbstractJvmFrameworkDetector(
  name = "Apache Kafka",
  framework = FrameworkType.KAFKA,
  coordinates = listOf(Coordinate("org.apache.kafka")),
)
