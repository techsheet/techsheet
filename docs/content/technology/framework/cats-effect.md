---
title: "Cats Effect"
aliases:
- "/framework/cats-effect"
bookToC: false
techsheet:
  key: "cats-effect"
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
    key: "zio"
    comment: "alternative Scala effect system"
  - type: "framework"
    key: "http4s"
    comment: "web framework built on Cats Effect"
---

**A purely functional runtime system for [Scala](../language/scala.md) that provides safe, composable concurrency
and resource management through the IO monad.**

Cats Effect is a library for the [JVM](../tool/jvm.md) that provides an asynchronous runtime, a set of typeclasses
for
describing effectful computation, and the `IO` monad as its concrete effect type. Built on top of the Cats functional
programming library, it encodes side effects as values, enabling referential transparency and equational reasoning in
concurrent programs. The core abstraction hierarchy (Sync, Async, Concurrent, Temporal) defines capabilities through
typeclasses, allowing application code to be written against abstract effect types and swapped between implementations.
Cats Effect manages fiber-based concurrency with structured cancellation, safe resource acquisition and release via
`Resource`, and integration with Java's non-blocking I/O through its own work-stealing thread pool.

The library serves as the foundation of the Typelevel ecosystem, powering frameworks such
as [http4s](http4s.md) for HTTP
services, Doobie for database access, FS2 for streaming, and Skunk for PostgreSQL connectivity. Cats Effect 3,
released in 2021, introduced a redesigned runtime with significantly improved performance, a fiber-aware scheduler,
and first-class support for tracing and metrics. It competes directly with [ZIO](zio.md) as the two
dominant approaches
to typed functional programming in [Scala](../language/scala.md), with Cats Effect favoring a typeclass-oriented,
MTL-style design
and ZIO favoring an integrated, concrete-first approach.

## Further Information

- [typelevel.org/cats-effect](https://typelevel.org/cats-effect/)
- [Typelevel Ecosystem](https://typelevel.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Cats_Effect)
