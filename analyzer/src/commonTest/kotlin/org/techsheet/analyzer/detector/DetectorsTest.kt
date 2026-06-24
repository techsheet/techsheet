package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.detector.Detector
import org.techsheet.analyzer.detector.Detectors
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.DetectionResult
import kotlin.test.Test
import kotlin.test.assertEquals

private class Stub(name: String, vararg matchers: Matcher) : Detector(name, *matchers) {
  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult = result
}

class DetectorsTest {
  @Test fun `Filename matchers route by name`() {
    val a = _root_ide_package_.org.techsheet.analyzer.detector.Stub("a", Matcher.Filename("pom.xml"))
    val b = _root_ide_package_.org.techsheet.analyzer.detector.Stub("b", Matcher.Filename("package.json"))
    val detectors = Detectors(listOf(a, b))

    assertEquals(listOf(a), detectors.forFile("services/api/pom.xml", "pom.xml", ".xml"))
    assertEquals(listOf(b), detectors.forFile("frontend/package.json", "package.json", ".json"))
    assertEquals(emptyList(), detectors.forFile("src/Main.kt", "Main.kt", ".kt"))
  }

  @Test fun `Extension matchers route by extension`() {
    val py = _root_ide_package_.org.techsheet.analyzer.detector.Stub("py", Matcher.Extension(".py"))
    val detectors = Detectors(listOf(py))
    assertEquals(listOf(py), detectors.forFile("app/main.py", "main.py", ".py"))
    assertEquals(emptyList(), detectors.forFile("app/main.kt", "main.kt", ".kt"))
  }

  @Test fun `FileAt matchers route by full relative path`() {
    val root = _root_ide_package_.org.techsheet.analyzer.detector.Stub("root-pom", Matcher.FileAt("pom.xml"))
    val deep = _root_ide_package_.org.techsheet.analyzer.detector.Stub(
      "devcontainer",
      Matcher.FileAt(".devcontainer", "devcontainer.json")
    )
    val detectors = Detectors(listOf(root, deep))

    assertEquals(listOf(root), detectors.forFile("pom.xml", "pom.xml", ".xml"))
    assertEquals(
      listOf(deep),
      detectors.forFile(".devcontainer/devcontainer.json", "devcontainer.json", ".json"),
    )
    assertEquals(emptyList(), detectors.forFile("modules/a/pom.xml", "pom.xml", ".xml"))
  }

  @Test fun `DirectoryAt matchers route by full relative path`() {
    val idea = _root_ide_package_.org.techsheet.analyzer.detector.Stub("idea", Matcher.DirectoryAt(".idea"))
    val gh = _root_ide_package_.org.techsheet.analyzer.detector.Stub("gh", Matcher.DirectoryAt(".github", "workflows"))
    val detectors = Detectors(listOf(idea, gh))

    assertEquals(listOf(idea), detectors.forDirectory(".idea"))
    assertEquals(listOf(gh), detectors.forDirectory(".github/workflows"))
    assertEquals(emptyList(), detectors.forDirectory("sub/.idea"))
  }

  @Test fun `multiple matcher kinds on one detector dedupe in lookup`() {
    val d = _root_ide_package_.org.techsheet.analyzer.detector.Stub(
      "d",
      Matcher.Filename("pom.xml"),
      Matcher.Extension(".xml")
    )
    val detectors = Detectors(listOf(d))
    assertEquals(listOf(d), detectors.forFile("services/a/pom.xml", "pom.xml", ".xml"))
  }

  @Test fun `forFile ignores null extension`() {
    val d = _root_ide_package_.org.techsheet.analyzer.detector.Stub("d", Matcher.Filename(".gitignore"))
    val detectors = Detectors(listOf(d))
    assertEquals(listOf(d), detectors.forFile(".gitignore", ".gitignore", null))
  }
}
