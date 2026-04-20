package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.TechSheet
import kotlin.test.Test
import kotlin.test.assertEquals

private class Stub(name: String, override val matchers: List<Matcher>) : Detector(name) {
  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet = sheet
}

class DispatchIndexTest {
  @Test fun `Filename matchers route by name`() {
    val a = Stub("a", listOf(Matcher.Filename("pom.xml")))
    val b = Stub("b", listOf(Matcher.Filename("package.json")))
    val idx = DispatchIndex(listOf(a, b))

    assertEquals(listOf(a), idx.forFile("services/api/pom.xml", "pom.xml", ".xml"))
    assertEquals(listOf(b), idx.forFile("frontend/package.json", "package.json", ".json"))
    assertEquals(emptyList(), idx.forFile("src/Main.kt", "Main.kt", ".kt"))
  }

  @Test fun `Extension matchers route by extension`() {
    val py = Stub("py", listOf(Matcher.Extension(".py")))
    val idx = DispatchIndex(listOf(py))
    assertEquals(listOf(py), idx.forFile("app/main.py", "main.py", ".py"))
    assertEquals(emptyList(), idx.forFile("app/main.kt", "main.kt", ".kt"))
  }

  @Test fun `FileAt matchers route by full relative path`() {
    val root = Stub("root-pom", listOf(Matcher.FileAt("pom.xml")))
    val deep = Stub("devcontainer", listOf(Matcher.FileAt(".devcontainer", "devcontainer.json")))
    val idx = DispatchIndex(listOf(root, deep))

    assertEquals(listOf(root), idx.forFile("pom.xml", "pom.xml", ".xml"))
    assertEquals(
      listOf(deep),
      idx.forFile(".devcontainer/devcontainer.json", "devcontainer.json", ".json"),
    )
    assertEquals(emptyList(), idx.forFile("modules/a/pom.xml", "pom.xml", ".xml"))
  }

  @Test fun `DirectoryAt matchers route by full relative path`() {
    val idea = Stub("idea", listOf(Matcher.DirectoryAt(".idea")))
    val gh = Stub("gh", listOf(Matcher.DirectoryAt(".github", "workflows")))
    val idx = DispatchIndex(listOf(idea, gh))

    assertEquals(listOf(idea), idx.forDirectory(".idea"))
    assertEquals(listOf(gh), idx.forDirectory(".github/workflows"))
    assertEquals(emptyList(), idx.forDirectory("sub/.idea"))
  }

  @Test fun `multiple matcher kinds on one detector dedupe in lookup`() {
    val d = Stub("d", listOf(Matcher.Filename("pom.xml"), Matcher.Extension(".xml")))
    val idx = DispatchIndex(listOf(d))
    assertEquals(listOf(d), idx.forFile("services/a/pom.xml", "pom.xml", ".xml"))
  }

  @Test fun `forFile ignores null extension`() {
    val d = Stub("d", listOf(Matcher.Filename(".gitignore")))
    val idx = DispatchIndex(listOf(d))
    assertEquals(listOf(d), idx.forFile(".gitignore", ".gitignore", null))
  }
}
