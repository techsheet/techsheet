package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SpringDataDetector : AbstractJvmDependencyDetector(
  name = "Spring Data",
  framework = FrameworkType.SPRING_DATA,
  coordinates = listOf(
    Coordinate("org.springframework.data"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-jpa"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-jdbc"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-r2dbc"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-rest"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-mongodb"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-mongodb-reactive"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-redis"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-redis-reactive"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-cassandra"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-cassandra-reactive"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-couchbase"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-couchbase-reactive"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-elasticsearch"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-ldap"),
    Coordinate("org.springframework.boot", "spring-boot-starter-data-neo4j"),
  ),
)
