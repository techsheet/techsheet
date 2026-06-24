---
title: Mockito
aliases:
  - /framework/mockito
bookToC: false
techsheet:
  key: mockito
  type: framework
  category: Testing
  languages:
    - java
    - kotlin
  related:
    - type: framework
      key: junit
      comment: "primary test runner companion"
    - type: language
      key: java
      comment: "primary language"
    - type: language
      key: kotlin
      comment: "supported language"
    - type: framework
      key: assertj
      comment: "commonly paired assertion library"
---

**A mocking framework for unit tests in [Java](../language/java.md) and [Kotlin](../language/kotlin.md) that
creates test doubles through a clean, fluent API.**

Mockito is an open-source testing framework that enables the creation of mock objects, stubs, and spies for
unit testing on the [JVM](../tool/jvm.md). It uses a fluent API based on method chaining (
`when(...).thenReturn(...)`,
`verify(...)`) to define mock behavior and verify interactions, favoring readability over configuration. Mockito
relies on runtime bytecode generation via the Byte Buddy library to create subclass-based mocks, and since
version 5 it supports mocking of final classes and methods by default through an inline mock maker. The framework
follows a strict philosophy of testing only interactions between objects rather than their internal state, promoting
loosely coupled designs.

Mockito is the most widely adopted mocking framework in the Java ecosystem and integrates directly with
[JUnit](junit.md) through its `MockitoExtension` (JUnit 5) and `MockitoJUnitRunner` (JUnit 4).
It is frequently combined with assertion libraries such as [AssertJ](assertj.md) and with
Spring Boot's `@MockBean` infrastructure for integration testing. The framework also provides `mockito-kotlin`,
a dedicated extension module that offers idiomatic Kotlin DSL support and proper handling of Kotlin's non-nullable
types and default arguments. Mockito 5, released in 2023, moved to a Java 11 baseline, adopted Byte Buddy as
its sole mock maker, and enabled mocking of final classes without explicit opt-in.

## Further Information

- [site.mockito.org](https://site.mockito.org/)
- [GitHub](https://github.com/mockito/mockito)
- [Wikipedia](https://en.wikipedia.org/wiki/Mockito)
