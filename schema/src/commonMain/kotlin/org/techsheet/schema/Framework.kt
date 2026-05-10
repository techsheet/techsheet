package org.techsheet.schema

import kotlinx.serialization.Serializable

@Serializable
data class Framework(
  override val id: String,
  override val name: String,
  override val url: String? = null,
  override val version: String? = null,
  val category: String? = null,
) : Technology
