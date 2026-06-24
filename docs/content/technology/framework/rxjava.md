---
title: "RxJava"
aliases:
- "/framework/rxjava"
bookToC: false
techsheet:
  key: "rxjava"
  type: "framework"
  category: "Concurrency"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "framework"
    key: "reactor"
    comment: "direct alternative, Reactive Streams on JVM"
  - type: "framework"
    key: "kotlinx-coroutines"
    comment: "alternative async model for Kotlin"
  - type: "language"
    key: "java"
    comment: "primary language"
  - type: "language"
    key: "kotlin"
    comment: "secondary language, full interop"
---

**A reactive extensions library for composing asynchronous and event-based programs on the [JVM](../tool/jvm.md)
using observable sequences.**

RxJava is a [Java](../language/java.md) implementation of ReactiveX (Reactive Extensions), a programming model for
processing asynchronous data streams through composable operators. It provides a rich set of observable types (
Observable, Flowable, Single, Maybe, Completable), each tailored to specific cardinality and backpressure requirements.
The library's operator-based API enables declarative composition of complex asynchronous workflows including mapping,
filtering, combining, error handling, and scheduling, while abstracting away low-level concerns such as threading,
synchronization, and resource management.

The library gained widespread adoption in Android development, where it became the dominant approach to managing UI
events, network calls, and database access before [Kotlin coroutines](kotlinx-coroutines.md) emerged
as an alternative. On the server side, RxJava is used in conjunction with frameworks
like [Vert.x](vertx.md) and has influenced the design
of [Project Reactor](reactor.md), which shares the Reactive Streams specification. RxJava 3, the
current major version, targets Java 8+ and fully implements the Reactive Streams API, aligning it with the
`java.util.concurrent.Flow` types introduced in Java 9.

## Further Information

- [github.com/ReactiveX/RxJava](https://github.com/ReactiveX/RxJava)
- [reactivex.io](https://reactivex.io/)
- [Wikipedia](https://en.wikipedia.org/wiki/ReactiveX)
