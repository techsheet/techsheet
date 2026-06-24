---
title: Spock
aliases:
  - /framework/spock
bookToC: false
techsheet:
  key: spock
  type: framework
  category: Testing
  languages:
    - groovy
  related:
    - type: language
      key: groovy
      comment: "primary language"
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: framework
      key: junit
      comment: "JUnit platform runner, alternative"
    - type: tool
      key: gradle
      comment: "common build tool pairing"
---

**A specification-driven testing and specification framework for [JVM](../tool/jvm.md) applications, written
in [Groovy](../language/groovy.md).**

Spock is a testing framework that combines a highly expressive specification language with a powerful, opinionated test
runner built on the JUnit platform. Tests are structured as specifications using labeled blocks (`given`, `when`,
`then`, `expect`, `where`) that read as executable documentation of system behavior. Spock integrates mocking,
stubbing, and data-driven testing as first-class features directly in the framework, eliminating the need for separate
libraries. Its data-driven testing support through `where` blocks and data tables allows compact parameterization of
test cases without external annotations or providers.

The framework runs on the [JVM](../tool/jvm.md) and leverages [Groovy](../language/groovy.md)'s
dynamic typing and concise syntax to reduce boilerplate in test code, while remaining fully interoperable with
[Java](../language/java.md) production code. Spock is widely adopted in [Gradle](../tool/gradle.md)-based
JVM projects and is the de facto testing framework for [Groovy](../language/groovy.md) codebases. Spock 2.x
migrated from the JUnit 4 runner to the JUnit 5 (Jupiter) platform, enabling seamless coexistence with
[JUnit](junit.md)-based tests in the same project and compatibility with modern IDE and build tool
integrations.

## Further Information

- [spockframework.org](https://spockframework.org/)
- [Spock Framework Reference Documentation](https://spockframework.org/spock/docs/2.3/index.html)
- [Wikipedia](https://en.wikipedia.org/wiki/Spock_(testing_framework))
