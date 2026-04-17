package org.techsheet.cli.domain

data class Service(
  val type: ServiceType,
  val version: String?,
)

enum class ServiceType(
  val title: String,
  val url: String,
  val category: ServiceCategory,
)

enum class ServiceCategory(val title: String) {
  DATABASE("Database"),
  QUEUE("Queue"),
  SERVER("Server"),
}
