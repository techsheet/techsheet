---
title: "AssertJ"
aliases:
- "/framework/assertj"
bookToC: false
techsheet:
  key: "assertj"
  type: "framework"
  category: "Testing"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "framework"
    key: "junit"
    comment: "primary test runner complement"
  - type: "framework"
    key: "mockito"
    comment: "common testing companion"
  - type: "language"
    key: "java"
    comment: "primary language"
  - type: "language"
    key: "kotlin"
    comment: "supported language"
---

**A fluent assertion library for [Java](../language/java.md) and [Kotlin](../language/kotlin.md) that
provides rich, type-safe assertions with readable error messages.**

AssertJ is a testing library that provides a comprehensive set of strongly-typed assertions through a fluent,
method-chaining API. Its core design principle is discoverability: IDE auto-completion guides developers through
available assertions for each type, eliminating the need to memorize matcher names or consult documentation. The library
uses a soft assertion mechanism that can collect multiple failures in a single test run, and its extensible architecture
allows custom assertion classes for domain-specific types. Unlike Hamcrest-style matchers, AssertJ assertions are
invoked directly on the value under test, resulting in a left-to-right reading flow that closely mirrors natural
language.

The library is commonly used alongside [JUnit](junit.md) and [Mockito](mockito.md)
in [JVM](../tool/jvm.md)-based test suites, and it has become the de facto assertion library in many enterprise
Java projects and open-source frameworks, including Spring Boot's test starters. AssertJ ships specialized modules for
Guava, Joda-Time, and database result sets, and its core module provides built-in support for Java 8+ types such as
Optional, Stream, CompletableFuture, and the java.time API. Originally forked from the FEST Assert project, it has
evolved into an independently maintained library under active development with regular releases tracking new JDK
features.

## Further Information

- [assertj.github.io/doc](https://assertj.github.io/doc/)
- [GitHub](https://github.com/assertj/assertj)
- [Wikipedia](https://en.wikipedia.org/wiki/AssertJ)
