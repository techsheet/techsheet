package org.techsheet.schema

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.Serializable

@Serializable
data class TechSheet(
  @EncodeDefault(EncodeDefault.Mode.ALWAYS)
  val schema: Int = 2,
  val project: Project? = null,
  val languages: List<Language>,
  val frameworks: List<Framework>,
  val services: List<Service>,
  val tools: List<Tool>,
)
