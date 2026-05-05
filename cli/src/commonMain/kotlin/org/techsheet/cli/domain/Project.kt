package org.techsheet.cli.domain

import kotlin.uuid.Uuid
import kotlinx.serialization.Serializable

@Serializable
data class Project(
  val id: Uuid = Uuid.random(),
  val name: String,
  val description: String? = null,
  val team: ProjectTeam? = null,
  val urls: List<ProjectUrl>? = null,
  val server: ProjectServer? = null,
) {
  companion object {

    const val DEFAULT_NAME = "unknown-project"
  }
}

@Serializable
data class ProjectTeam(
  val id: Uuid = Uuid.random(),
  val name: String,
)

@Serializable
data class ProjectUrl(
  val name: String,
  val url: String,
)

@Serializable
data class ProjectServer(
  val url: String,
)
