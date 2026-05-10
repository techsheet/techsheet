package org.techsheet.cli.domain

data class DetectedService(
  val type: ServiceType,
  val version: String?,
)

enum class ServiceType(
  override val key: String,
  override val title: String,
  val category: ServiceCategory,
) : DetectedTechnology {
  POSTGRES("postgres", "PostgreSQL", ServiceCategory.DATABASE),
  ;

  override val type: String = "service"
}

enum class ServiceCategory(val title: String) {
  DATABASE("Database"),
  QUEUE("Queue"),
  SERVER("Server"),
}
