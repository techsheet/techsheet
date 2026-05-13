package org.techsheet.core

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import com.charleskorn.kaml.YamlException
import kotlinx.serialization.json.Json

class Parser(
  private val schemaLoader: SchemaLoader = SchemaLoader(),
) {

  private val yaml = Yaml(configuration = YamlConfiguration(strictMode = false))

  fun parse(yamlContent: String): ParserResult =
    readYaml(yamlContent)
      .flatMap { validateSchema(it) }
      .flatMap { validateDomain(it) }

  private fun validateSchema(sheet: TechSheet): ParserResult {
    val json = Json.encodeToJsonElement(TechSheet.serializer(), sheet)
    val schema = schemaLoader.load(sheet.schema)
    val errors = mutableListOf<String>()

    return schema
      .validate(json) {
        // mutable library API, unfortunately
        errors.add("${it.objectPath}: ${it.message}")
      }
      .let { valid ->
        if (valid) {
          ParserResult.Success(sheet)
        } else {
          ParserResult.Failure("TechSheet has validation errors", errors)
        }
      }
  }

  private fun validateDomain(sheet: TechSheet): ParserResult =
    when {
      sheet.isEmpty() ->
        ParserResult.Failure("TechSheet has validation errors", listOf("/: Sheet is fully empty"))

      else ->
        ParserResult.Success(sheet)
    }

  private fun readYaml(yamlContent: String) =
    try {
      ParserResult.Success(
        yaml.decodeFromString(TechSheet.serializer(), yamlContent)
      )
    } catch (e: YamlException) {
      ParserResult.Failure(
        "Error while parsing YAML",
        listOf("/${e.path.toHumanReadableString()}: ${e.message.removeSuffix(".")}")
      )
    }
}

sealed class ParserResult {

  abstract val errors: List<String>

  val isSuccess: Boolean
    get() =
      fold({ true }, { false })

  val isFailure: Boolean
    get() =
      fold({ false }, { true })

  fun orNull(): TechSheet? =
    fold({ it }, { null })

  fun asResult(): Result<TechSheet> =
    fold({ Result.success(it) }, { Result.failure(TechsheetParserException(it)) })

  fun orThrow(): TechSheet =
    asResult().getOrThrow()

  fun flatMap(transform: (TechSheet) -> ParserResult): ParserResult =
    fold(transform, { it })

  fun <T> fold(onSuccess: (TechSheet) -> T, onFailure: (Failure) -> T): T =
    when (this) {
      is Success -> onSuccess(sheet)
      is Failure -> onFailure(this)
    }

  data class Success(
    val sheet: TechSheet,
  ) : ParserResult() {
    override val errors: List<String> = emptyList()
  }

  data class Failure(
    val message: String,
    override val errors: List<String>,
  ) : ParserResult()
}

class TechsheetParserException(failure: ParserResult.Failure) :
  RuntimeException("Parsing of techsheet failed: ${failure.message}")
