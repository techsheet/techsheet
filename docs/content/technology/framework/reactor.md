---
title: "Project Reactor"
aliases:
- "/framework/reactor"
bookToC: false
techsheet:
  key: "reactor"
  type: "framework"
  category: "Concurrency"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "framework"
    key: "spring-webflux"
    comment: "primary consumer, reactive web stack"
  - type: "framework"
    key: "rxjava"
    comment: "alternative Reactive Streams implementation"
  - type: "language"
    key: "java"
    comment: "primary language"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
---

**A reactive programming library for building non-blocking, backpressure-aware applications on
the [JVM](../tool/jvm.md).**

Project Reactor is a fully non-blocking reactive programming foundation that implements the Reactive Streams
specification. It provides two core publisher types: `Mono` (0..1 elements) and `Flux` (0..N elements), which model
asynchronous sequences with built-in backpressure support. The library emphasizes a functional, declarative composition
model where data transformations are expressed as operator chains over reactive pipelines, avoiding callback-based
concurrency in favor of a structured, composable API.

Reactor serves as the reactive foundation for [Spring WebFlux](spring-webflux.md) and the broader
Spring ecosystem's reactive stack, including Spring Data R2DBC and Spring Cloud Gateway. Written
in [Java](../language/java.md)
with first-class [Kotlin](../language/kotlin.md) extension support, it competes
with [RxJava](rxjava.md) as a Reactive Streams
implementation but is more tightly integrated with Spring. Reactor Netty provides a reactive HTTP and TCP/UDP client and
server built on Netty, and the `reactor-test` module offers dedicated testing utilities such as `StepVerifier` for
verifying reactive sequences.

## Further Information

- [projectreactor.io](https://projectreactor.io/)
- [Reactor Reference Guide](https://projectreactor.io/docs/core/release/reference/)
- [Wikipedia](https://en.wikipedia.org/wiki/Project_Reactor)
