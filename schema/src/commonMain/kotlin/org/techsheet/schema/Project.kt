package org.techsheet.schema

import kotlin.uuid.Uuid
import kotlinx.serialization.Serializable

/**
 * Optional project metadata attached to a [TechSheet]
 *
 * Provides context about the project that owns the sheet, useful for registries and dashboards
 * that aggregate multiple sheets.
 *
 * @property id Stable UUID that uniquely identifies this project across all sheets.
 * @property name Short human-readable project name.
 * @property description Optional longer description of what the project does.
 * @property team The team responsible for this project.
 * @property urls Named URLs associated with the project such as website, repository or documentation.
 * @property server The primary deployment server for this project.
 * @since 2.0.0
 */
@Serializable
data class Project(
  val id: Uuid,
  val name: String,
  val description: String? = null,
  val team: ProjectTeam? = null,
  val urls: List<ProjectUrl>? = null,
  val server: ProjectServer? = null,
)

/**
 * The team responsible for a project
 *
 * @property id Stable UUID that uniquely identifies this team.
 * @property name Human-readable team name.
 * @since 2.0.0
 */
@Serializable
data class ProjectTeam(
  val id: Uuid = Uuid.random(),
  val name: String,
)

/**
 * A named URL associated with a project
 *
 * @property name Short label describing the link.
 * @property url The absolute URL.
 * @since 2.0.0
 */
@Serializable
data class ProjectUrl(
  val name: String,
  val url: String,
)

/**
 * The TechSheet server to upload reports to
 *
 * @property url Base URL of the TechSheet server.
 * @since 2.0.0
 */
@Serializable
data class ProjectServer(
  val url: String,
)
