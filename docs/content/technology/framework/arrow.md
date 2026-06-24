---
title: "Arrow"
aliases:
- "/framework/arrow"
bookToC: false
techsheet:
  key: "arrow"
  type: "framework"
  category: "Concurrency"
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
    key: "kotlinx-coroutines"
    comment: "foundation, Arrow extends coroutines with typed errors and resources"
  - type: "framework"
    key: "cats-effect"
    comment: "Scala equivalent, functional effect system"
---

**A functional programming library for [Kotlin](../language/kotlin.md) that provides typed error handling,
resource safety, and high-level concurrency primitives.**

Arrow brings functional programming idioms to [Kotlin](../language/kotlin.md) in an idiomatic way, building
directly on top of [Kotlin Coroutines](kotlinx-coroutines.md) and the Kotlin type system rather than
emulating Haskell or [Scala](../language/scala.md) patterns. The library is organized around typed error
handling (using `Either` and `Raise`), resource-safe computation (via `ResourceScope`), resilience patterns (circuit
breakers, retries, scheduling), and immutable data transformation through optics. Arrow's design philosophy prioritizes
Kotlin-native APIs, leveraging suspend functions, context receivers, and inline classes to minimize runtime overhead
while providing compile-time safety guarantees.

Arrow is used primarily in [Kotlin](../language/kotlin.md) backend services running on
the [JVM](../tool/jvm.md), often alongside [Ktor](ktor.md) or Spring Boot. The project
underwent a major redesign with Arrow 2.x, removing its earlier monad transformer stack and Haskell-inspired type class
hierarchy in favor of a simpler, coroutines-first approach centered on the `Raise` DSL for typed errors. This shift made
the library significantly more accessible to mainstream Kotlin developers while retaining the precision of functional
error handling and resource management.

## Further Information

- [arrow-kt.io](https://arrow-kt.io/)
- [Arrow Documentation](https://arrow-kt.io/docs/)
- [Wikipedia](https://en.wikipedia.org/wiki/Arrow_(Kotlin_library))
