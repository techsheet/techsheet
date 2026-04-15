package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class DockerDetector : AbstractFilePresentDetector(
  "Docker",
  { it.withTool(ToolType.DOCKER) },
  "Dockerfile",
  ) {

  override val depth = 5
}
