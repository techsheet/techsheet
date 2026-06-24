---
title: Maven
aliases:
  - /tool/maven
bookToC: false
techsheet:
  key: maven
  type: tool
  category: Build
  related:
    - type: tool
      key: jvm
      comment: "target runtime platform"
    - type: tool
      key: gradle
      comment: "primary alternative, Groovy/Kotlin DSL"
    - type: language
      key: java
      comment: "primary build language"
    - type: tool
      key: sbt
      comment: "alternative JVM build tool for Scala"
---

**A convention-over-configuration build automation and dependency management tool for [Java](../language/java.md)
and other [JVM](jvm.md) languages.**

Apache Maven is a build tool centered on the concept of a Project Object Model (POM), an XML descriptor that declares a
project's dependencies, build plugins, and lifecycle phases. Its convention-over-configuration approach enforces a
standard directory layout and a fixed build lifecycle (validate, compile, test, package, verify, install, deploy),
reducing the need for explicit build scripts. Maven resolves transitive dependencies from remote repositories such as
Maven Central using coordinate-based artifact identification (groupId, artifactId, version), and its plugin architecture
allows every phase of the build lifecycle to be extended or overridden.

The tool dominates [Java](../language/java.md) enterprise development and is the default build system for many
Spring, Jakarta EE, and Quarkus projects. It also supports [Kotlin](../language/kotlin.md),
[Scala](../language/scala.md), and [Groovy](../language/groovy.md) through compiler plugins. Maven Central,
the default repository, is one of the largest public software registries, hosting over 600,000 unique artifacts.
[Gradle](gradle.md) has emerged as the main alternative, offering more flexible build scripting and
incremental builds, though Maven remains the most widely adopted build tool in the Java ecosystem.

## Further Information

- [maven.apache.org](https://maven.apache.org/)
- [Maven Central Repository](https://central.sonatype.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/Apache_Maven)
