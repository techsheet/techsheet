---
title: "ScalaTest"
aliases:
- "/framework/scalatest"
bookToC: false
techsheet:
  key: "scalatest"
  type: "framework"
  category: "Testing"
  languages:
  - "scala"
  related:
  - type: "language"
    key: "scala"
    comment: "primary language"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "framework"
    key: "junit"
    comment: "JVM testing alternative, runner compatibility"
  - type: "tool"
    key: "sbt"
    comment: "primary build tool for Scala projects"
---

**The most widely adopted testing framework for [Scala](../language/scala.md), offering multiple DSL styles for
writing expressive and readable tests on the [JVM](../tool/jvm.md).**

ScalaTest is an open-source testing toolkit designed to support a variety of testing styles through interchangeable
specification traits, including `FunSuite`, `FlatSpec`, `WordSpec`, `FunSpec`, and `FreeSpec`. Each style provides a
distinct DSL for structuring test definitions, allowing teams to choose the approach that best fits their domain and
conventions. The framework provides a rich assertion and matcher library (`Matchers`, `MustMatchers`) with type-safe
comparison operators, and supports asynchronous testing, property-based testing (via integration with ScalaCheck),
fixture management, and tagging for selective test execution. Its architecture is trait-based, leveraging Scala's mixin
composition to let users combine testing styles with reusable setup and teardown logic.

ScalaTest integrates natively with [SBT](../tool/sbt.md), [Maven](../tool/maven.md), and
[Gradle](../tool/gradle.md), and can generate [JUnit](junit.md)-compatible XML reports for CI
pipeline consumption. The framework also provides a JUnit runner, enabling execution within JUnit-based tooling. It is
the default testing framework in many Scala project templates and is widely used across the Scala ecosystem, from
data-intensive applications built on Apache Spark to microservice architectures using Play Framework and Akka. ScalaTest
3.x introduced a modular structure that separates the core engine from individual style traits, and added support for
Scala 3 alongside continued compatibility with Scala 2.12 and 2.13.

## Further Information

- [scalatest.org](https://www.scalatest.org/)
- [ScalaTest User Guide](https://www.scalatest.org/user_guide)
- [Wikipedia](https://en.wikipedia.org/wiki/ScalaTest)
