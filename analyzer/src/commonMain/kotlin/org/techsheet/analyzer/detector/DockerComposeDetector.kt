package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.ToolType

class DockerComposeDetector : Detector("Docker Compose", Matcher.Filename("docker-compose.yml")) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.DOCKER_COMPOSE)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.DOCKER_COMPOSE)
}
