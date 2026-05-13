package org.techsheet.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TechSheet(
  @SerialName("\$schema")
  val schema: String? = null,
  val project: Project? = null,
  val languages: List<Language> = emptyList(),
  val frameworks: List<Framework> = emptyList(),
  val services: List<Service> = emptyList(),
  val tools: List<Tool> = emptyList(),
) {

  fun isEmpty(): Boolean =
    project == null && languages.isEmpty() && frameworks.isEmpty() && services.isEmpty() && tools.isEmpty()
}
