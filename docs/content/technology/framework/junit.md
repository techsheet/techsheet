---
title: "JUnit"
aliases:
- "/framework/junit"
bookToC: false
techsheet:
  key: "junit"
  type: "framework"
  category: "Testing"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "language"
    key: "java"
    comment: "primary language"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "framework"
    key: "mockito"
    comment: "commonly paired mocking framework"
  - type: "framework"
    key: "testng"
    comment: "direct alternative for JVM testing"
---

**The standard unit testing framework for [Java](../language/java.md) and [JVM](../tool/jvm.md)-based
languages, providing annotations, assertions, and an extensible test execution model.**

JUnit is an open-source testing framework that established the xUnit pattern for the Java ecosystem. The current
generation, JUnit 5 (also known as the JUnit Platform), is composed of three modules: JUnit Platform (the foundation for
launching testing frameworks on the JVM), JUnit Jupiter (the new programming model and extension model), and JUnit
Vintage (backward compatibility with JUnit 3 and 4). Its annotation-driven approach, including `@Test`,
`@BeforeEach`, `@ParameterizedTest`, and `@Nested`, enables declarative test structure with support for parameterized
tests, dynamic tests, conditional execution, and parallel test execution.

Originally created by Kent Beck and Erich Gamma in 1997, JUnit played a central role in popularizing test-driven
development (TDD) and shaped the design of testing frameworks across many languages. It integrates natively with all
major build tools including [Maven](../tool/maven.md), [Gradle](../tool/gradle.md),
and [SBT](../tool/sbt.md), and is supported by every major IDE.
The framework is commonly used alongside [Mockito](mockito.md) for mocking and
[AssertJ](assertj.md) for fluent assertions. JUnit 5's extension model replaced the older runner and
rule mechanisms, enabling custom lifecycle callbacks, parameter resolution, and third-party integrations such as
[Testcontainers](testcontainers.md) and Spring TestContext.

## Further Information

- [junit.org/junit5](https://junit.org/junit5/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Wikipedia](https://en.wikipedia.org/wiki/JUnit)
