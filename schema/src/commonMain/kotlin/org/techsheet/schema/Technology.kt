package org.techsheet.schema

/**
 * Common properties shared by all technology entries in a [TechSheet]
 *
 * @property id Globally unique identifier
 * @property name Human-readable display name
 * @property url Optional canonical reference URL
 * @property version Detected or declared version string. Null when unknown
 * @since 2.0.0
 */
interface Technology {
  val id: String
  val name: String
  val url: String?
  val version: String?
}
