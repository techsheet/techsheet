---
title: "ZIO"
aliases:
- "/framework/zio"
bookToC: false
techsheet:
  key: "zio"
  type: "framework"
  category: "Concurrency"
  languages:
  - "scala"
  related:
  - type: "language"
    key: "scala"
    comment: "host language"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "framework"
    key: "cats-effect"
    comment: "alternative Scala effect system"
  - type: "framework"
    key: "http4s"
    comment: "functional HTTP library, interop via ZIO"
---

**A type-safe, composable concurrency and asynchronous programming library for [Scala](../language/scala.md) built
around a concrete effect type and structured dependency injection.**

ZIO (Z I/O) is a functional effect system for the [JVM](../tool/jvm.md) that models side effects, concurrency, and
resource management through its core `ZIO[R, E, A]` data type, where `R` represents required dependencies, `E` the error
type, and `A` the success type. This three-parameter encoding enables compile-time tracking of both error channels and
environmental requirements without relying on abstract typeclasses. The library provides fiber-based concurrency with
structured supervision, safe resource handling through `Scope`, software transactional memory (STM), concurrent data
structures (Ref, Queue, Hub), and a streaming abstraction (ZStream). Its built-in dependency injection layer, ZLayer,
allows applications to wire service dependencies as composable, type-checked modules without external DI frameworks.

The library anchors the ZIO ecosystem, which includes ZIO HTTP for web services, ZIO Quill and ZIO JDBC for database
access, ZIO Kafka for event streaming, ZIO JSON for serialization, and ZIO Test as its integrated testing framework. ZIO
2, released in 2022, unified the library into a single module, introduced a simplified API surface, and delivered
substantial performance improvements to its fiber runtime. It competes
with [Cats Effect](cats-effect.md) as one of the two dominant approaches to typed functional
programming in [Scala](../language/scala.md), with ZIO favoring a concrete-first, batteries-included design over
the typeclass-oriented style of the Typelevel stack.

## Further Information

- [zio.dev](https://zio.dev/)
- [GitHub](https://github.com/zio/zio)
- [Wikipedia](https://en.wikipedia.org/wiki/ZIO_(software))
