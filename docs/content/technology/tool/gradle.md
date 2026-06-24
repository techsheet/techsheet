---
title: Gradle
aliases:
  - /tool/gradle
bookToC: false
techsheet:
  key: gradle
  type: tool
  category: Build
  related:
    - type: tool
      key: jvm
      comment: "target runtime platform"
    - type: tool
      key: maven
      comment: "primary alternative for JVM builds"
    - type: language
      key: kotlin
      comment: "Kotlin DSL and supported language"
    - type: language
      key: groovy
      comment: "Groovy DSL and supported language"
---

**An open-source build automation tool designed for flexibility and performance across JVM, Android, and polyglot
projects.**

Gradle uses a directed acyclic graph to model task dependencies and employs an incremental build cache that avoids
re-executing tasks whose inputs have not changed. Build scripts are written in either
a [Kotlin](../language/kotlin.md) DSL or a
[Groovy](../language/groovy.md) DSL, giving authors full programmatic control over the build logic while
maintaining a declarative
structure through conventions. The tool's configuration-avoidance API and build cache enable it to scale to large
multi-project builds with hundreds of modules, and its daemon process keeps a warm JVM in memory between invocations to
reduce startup time.

Gradle is the official build system for Android application development and is widely adopted for
[Java](../language/java.md), [Kotlin](../language/kotlin.md), [Scala](../language/scala.md), and
Groovy projects on the
[JVM](jvm.md). It integrates with [Maven](maven.md) repositories for dependency resolution
and supports plugins for
native compilation, code generation, containerization, and publishing. The Gradle Wrapper (`gradlew`) allows projects to
pin a specific Gradle version, ensuring reproducible builds without requiring a pre-installed distribution.

## Further Information

- [gradle.org](https://gradle.org/)
- [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html)
- [Wikipedia](https://en.wikipedia.org/wiki/Gradle)
