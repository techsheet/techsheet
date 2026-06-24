---
title: Ktor
aliases:
  - /framework/ktor
bookToC: false
techsheet:
  key: ktor
  type: framework
  category: Application
  languages:
    - kotlin
  related:
    - type: language
      key: kotlin
      comment: "primary language, idiomatic Kotlin API"
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: framework
      key: kotlinx-coroutines
      comment: "coroutine foundation for async I/O"
    - type: framework
      key: micronaut
      comment: "alternative JVM/Kotlin web framework"
---

**An asynchronous web framework for [Kotlin](../language/kotlin.md), built on coroutines and designed for
connected applications.**

Ktor is an open-source framework developed by JetBrains for building asynchronous servers and clients
in [Kotlin](../language/kotlin.md). It runs on the [JVM](../tool/jvm.md) and
leverages [Kotlin coroutines](kotlinx-coroutines.md) as its core concurrency model, providing a
non-blocking I/O foundation without the complexity of reactive streams or callback chains. Ktor uses a modular plugin
architecture where features such as routing, serialization, authentication, and WebSocket support are installed
individually rather than bundled monolithically. Its DSL-driven configuration allows entire applications to be defined
in code without annotations or external XML, distinguishing it from annotation-heavy frameworks in the JVM ecosystem.

Ktor is used for building REST APIs, microservices, and HTTP clients in Kotlin-centric projects. The framework supports
multiple server engines including Netty, Jetty, and CIO (Coroutine-based I/O), and its client module is available on
Kotlin Multiplatform targets beyond the JVM, including native and JavaScript. Ktor 3.x adopted Kotlin 2.0 and introduced
improved configuration APIs, expanded multiplatform support, and refined its plugin system. The framework is maintained
by JetBrains alongside the Kotlin language itself, ensuring close alignment with language evolution.

## Further Information

- [ktor.io](https://ktor.io/)
- [Ktor Documentation](https://ktor.io/docs/welcome.html)
- [Wikipedia](https://en.wikipedia.org/wiki/Ktor)
