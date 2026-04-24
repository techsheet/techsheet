package org.techsheet.cli.domain

interface Technology {
  val title: String
  val key: String
  val type: String

  val id: String
    get() = "$type.$key"

  val url: String
    get() = "https://techsheet.org/$type/$key"
}
