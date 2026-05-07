package org.techsheet.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.CliktError
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import org.techsheet.cli.domain.*
import org.techsheet.cli.reporter.ReporterFactory
import org.techsheet.cli.reporter.YamlReporter
import kotlin.uuid.Uuid

class InitCommand : CliktCommand(name = "init") {

  private val force: Boolean by option("-f", "--force", help = "Overwrite existing ${YamlReporter.DEFAULT_FILE_NAME}")
    .flag()

  private val file: String? by option(
    "--file",
    help = "Path to write the techsheet.yml (default: ${YamlReporter.DEFAULT_FILE_NAME} inside the source directory)",
  )

  private val name: String by option("--name", help = "Project name")
    .prompt("Project name")

  private val description: String? by option("--description", help = "Project description")
    .prompt("Description", default = null)

  private val teamName: String? by option("--team", help = "Team name")
    .prompt("Team name", default = null)

  private val websiteUrl: String? by option("--website", help = "Website URL")
    .prompt("Website URL", default = null)

  private val repoUrl: String? by option("--repo", help = "Repository URL")
    .prompt("Repository URL", default = null)

  private val source: String by argument(
    name = "source",
    help = "Project directory (defaults to current directory)",
  ).default("./")

  override fun help(context: Context): String = """
    Initialize a new techsheet.yml for a project.

    Interactively prompts for project metadata and writes a techsheet.yml file.
  """.trimIndent()

  override fun run() {
    val fs = FileSystem.SYSTEM
    val sourcePath = fs.canonicalize(source.toPath())
    val targetFile = file?.toPath(normalize = true) ?: (sourcePath / YamlReporter.DEFAULT_FILE_NAME)

    if (fs.exists(targetFile) && !force) {
      throw CliktError("$targetFile already exists. Use --force to overwrite.")
    }

    val project = Project(
      id = Uuid.random(),
      name = name,
      description = description
        ?.takeIf { it.isNotBlank() },
      team = teamName
        ?.takeIf { it.isNotBlank() }
        ?.let { ProjectTeam(id = Uuid.random(), name = it) },
      urls = listOfNotNull(
        websiteUrl
          ?.takeIf { it.isNotBlank() }
          ?.let { ProjectUrl(name = "Website", url = it) },
        repoUrl
          ?.takeIf { it.isNotBlank() }
          ?.let { ProjectUrl(name = "Repository", url = it) },
      ).ifEmpty { null },
    )

    val report = TechSheetReport.of(TechSheet(project = project))
    ReporterFactory(report = report, readonly = false, fs = fs).yaml.report(targetFile)

    echo("Written to $targetFile")
  }
}
