package org.techsheet.cli.detectorv2

import kotlin.test.Test
import kotlin.test.assertEquals

class MatcherTest {
  @Test fun `Filename is a data class`() =
    assertEquals(Matcher.Filename("pom.xml"), Matcher.Filename("pom.xml"))

  @Test fun `Extension keeps leading dot`() =
    assertEquals(".py", Matcher.Extension(".py").ext)

  @Test fun `FileAt varargs constructor matches primary`() = assertEquals(
    Matcher.FileAt(listOf(".devcontainer", "devcontainer.json")),
    Matcher.FileAt(".devcontainer", "devcontainer.json"),
  )

  @Test fun `DirectoryAt varargs constructor matches primary`() = assertEquals(
    Matcher.DirectoryAt(listOf(".github", "workflows")),
    Matcher.DirectoryAt(".github", "workflows"),
  )

  @Test fun `FileAt single-segment equivalent to root-anchored`() =
    assertEquals(Matcher.FileAt(listOf("pom.xml")), Matcher.FileAt("pom.xml"))
}
