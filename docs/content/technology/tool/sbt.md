---
title: "SBT"
aliases:
- "/tool/sbt"
bookToC: false
techsheet:
  key: "sbt"
  type: "tool"
  category: "Build"
  related:
  - type: "language"
    key: "scala"
    comment: "primary language"
  - type: "tool"
    key: "jvm"
    comment: "target runtime platform"
  - type: "tool"
    key: "gradle"
    comment: "alternative JVM build tool"
  - type: "tool"
    key: "maven"
    comment: "alternative JVM build tool"
---

**The standard build tool for [Scala](../language/scala.md) projects, providing incremental compilation and an
interactive development shell.**

sbt (Simple Build Tool, later Scala Build Tool) is a build tool designed specifically
for [Scala](../language/scala.md) and [Java](../language/java.md) projects running on
the [JVM](jvm.md). Build definitions are written in Scala itself, using a DSL based on immutable settings
and task keys that form a directed acyclic graph of dependencies. The tool features continuous compilation triggered by
file changes, an interactive shell that keeps a warm JVM process between commands, and incremental compilation powered
by Zinc, which analyzes dependencies at the source-file level to recompile only what has changed.

The tool resolves dependencies from [Maven](maven.md) repositories using Coursier and supports
multi-project builds through a hierarchical structure of sub-projects within a single build definition. sbt's plugin
ecosystem covers code generation, packaging (sbt-assembly, sbt-native-packager), release management, and cross-building
against multiple Scala versions simultaneously. The transition from sbt 1.x to sbt 2.x brings a move to Scala 3 for
build definitions, a BSP-first architecture replacing the legacy server protocol, and improved caching mechanisms.

## Further Information

- [scala-sbt.org](https://www.scala-sbt.org/)
- [sbt Reference Manual](https://www.scala-sbt.org/1.x/docs/)
- [Wikipedia](https://en.wikipedia.org/wiki/Sbt_(software))
