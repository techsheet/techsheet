---
title: "Kotest"
aliases:
- "/framework/kotest"
bookToC: false
techsheet:
  key: "kotest"
  type: "framework"
  category: "Testing"
  languages:
  - "kotlin"
  related:
  - type: "language"
    key: "kotlin"
    comment: "primary language"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "framework"
    key: "junit"
    comment: "JVM testing alternative, interop layer"
  - type: "framework"
    key: "mockito"
    comment: "complementary mocking library"
---

**A comprehensive, multiplatform testing framework for [Kotlin](../language/kotlin.md) that provides expressive
DSLs for writing tests, assertions, and property-based checks.**

Kotest (formerly KotlinTest) is a flexible testing framework built specifically
for [Kotlin](../language/kotlin.md), running on the [JVM](../tool/jvm.md), JavaScript, and Kotlin/Native
targets. It offers multiple testing styles including FunSpec, StringSpec, BehaviorSpec, DescribeSpec, and WordSpec,
allowing developers to choose the structure that best fits their project. The framework includes a rich assertion
library with over 300 matchers, a property-based testing engine inspired by Haskell's QuickCheck, and support for
coroutines as a first-class concept. Tests are defined using Kotlin DSLs rather than annotations, enabling dynamic test
generation and deeply nested test hierarchies.

The framework integrates with [JUnit](junit.md) Platform as a test engine, making it compatible with
existing build tool configurations and IDE support in IntelliJ IDEA and Gradle. Kotest supports data-driven testing,
non-deterministic test helpers (eventually, continually), lifecycle callbacks, and extensions for framework integration
with Spring, Ktor, and Testcontainers. Its multiplatform support allows shared test code across JVM, JS, and Native
targets within Kotlin Multiplatform projects, making it a natural choice for teams invested in the Kotlin ecosystem.

## Further Information

- [kotest.io](https://kotest.io/)
- [GitHub](https://github.com/kotest/kotest)
- [Wikipedia](https://en.wikipedia.org/wiki/Kotest)
