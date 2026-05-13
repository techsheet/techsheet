package org.techsheet.core

import io.github.optimumcode.json.schema.JsonSchema
import io.github.optimumcode.json.schema.JsonSchemaLoader
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.runBlocking
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM

class SchemaLoader(
  private val fallbackLocation: String = DEFAULT_SCHEMA_LOCATION,
  private val fileSystem: FileSystem = FileSystem.SYSTEM,
  private val httpClient: HttpClient = HttpClient(CIO),
) {

  private val cache = mutableMapOf<String, JsonSchema>()

  fun load(location: String?): JsonSchema =
    cache.getOrPut(location ?: fallbackLocation) {
      JsonSchemaLoader.create().fromDefinition(fetch(location ?: fallbackLocation))
    }

  private fun fetch(location: String): String =
    if (location.startsWith("http")) {
      runBlocking { httpClient.get(location).bodyAsText() }
    } else {
      fileSystem.read(location.toPath()) { readUtf8() }
    }

  companion object {
    const val DEFAULT_SCHEMA_LOCATION = "https://techsheet.org/schema/v2/techsheet.json"
  }
}
