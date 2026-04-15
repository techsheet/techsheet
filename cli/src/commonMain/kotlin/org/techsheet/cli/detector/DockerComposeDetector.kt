package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class DockerComposeDetector : AbstractFilePresentDetector(
  "Docker Compose",
  { it.withTool(ToolType.DOCKER_COMPOSE) },
  "docker-compose.yml",
  ) {

  override val depth = 2
}
