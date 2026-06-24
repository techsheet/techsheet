---
title: Kotlinx Coroutines
aliases:
  - /framework/kotlinx-coroutines
bookToC: false
techsheet:
  key: kotlinx-coroutines
  type: framework
  category: Concurrency
  languages:
    - kotlin
  related:
    - type: language
      key: kotlin
      comment: "primary language"
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: framework
      key: ktor
      comment: "Kotlin web framework built on coroutines"
    - type: framework
      key: reactor
      comment: "JVM concurrency alternative, reactive streams"
    - type: framework
      key: arrow
      comment: "Kotlin functional companion library"
---

**A structured concurrency library for [Kotlin](../language/kotlin.md) that provides lightweight, composable
primitives for asynchronous and concurrent programming.**

Kotlinx Coroutines is the official JetBrains library for writing asynchronous, non-blocking code
in [Kotlin](../language/kotlin.md). It builds on Kotlin's language-level `suspend` function support to provide
coroutine builders (`launch`, `async`), structured concurrency through `CoroutineScope`, and a rich set of concurrency
primitives including channels, flows, mutexes, and supervisors. The library's design philosophy centers on structured
concurrency, ensuring that coroutines are always launched within a defined scope and that failures propagate predictably
through the coroutine hierarchy. Unlike callback-based or reactive-stream approaches, coroutines allow developers to
write sequential-looking code that executes asynchronously, with cancellation and exception handling built into the
framework.

The library targets all Kotlin platforms, including [JVM](../tool/jvm.md), JavaScript, and Kotlin/Native, making
it a core building block for Kotlin Multiplatform projects. On the JVM, it integrates with existing concurrency models
through dispatchers (`Dispatchers.IO`, `Dispatchers.Default`, `Dispatchers.Main`) and provides interoperability adapters
for reactive streams, `CompletableFuture`, and Android's lifecycle-aware components. [Ktor](ktor.md),
Jetpack Compose, and the Android Jetpack libraries all use kotlinx-coroutines as their primary concurrency mechanism.
The `Flow` API, introduced as a cold asynchronous stream abstraction, has become the standard approach for reactive data
pipelines in Kotlin, serving as a Kotlin-native alternative to [Project Reactor](reactor.md)
and [RxJava](rxjava.md).

## Further Information

- [github.com/Kotlin/kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Kotlin Coroutines Guide](https://kotlinlang.org/docs/coroutines-guide.html)
- [Wikipedia](https://en.wikipedia.org/wiki/Kotlin_(programming_language)#Coroutines)
