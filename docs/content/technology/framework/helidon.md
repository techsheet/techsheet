---
title: Helidon
aliases:
  - /framework/helidon
bookToC: false
techsheet:
  key: helidon
  type: framework
  category: Application
  languages:
    - java
    - kotlin
  related:
    - type: language
      key: java
      comment: "primary language"
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: framework
      key: micronaut
      comment: "alternative cloud-native JVM framework"
    - type: framework
      key: quarkus
      comment: "alternative cloud-native JVM framework"
    - type: framework
      key: jakarta-ee
      comment: "standards base for Helidon MP"
---

**An open-source, lightweight Java framework for building cloud-native microservices, developed by Oracle.**

Helidon provides two distinct programming models on the [JVM](../tool/jvm.md): Helidon SE, a reactive,
functional-style
microframework built on virtual threads and non-blocking I/O, and Helidon MP, a full MicroProfile implementation that
aligns with [Jakarta EE](jakarta-ee.md) standards. Written in [Java](../language/java.md), the
framework emphasizes a small footprint, fast
startup times, and minimal memory consumption. Helidon SE exposes a builder-based, transparent API with no annotation
magic or dependency injection, while Helidon MP layers CDI, JAX-RS, JSON-P/B, and MicroProfile APIs (Config, Health,
Metrics, OpenAPI, Fault Tolerance) on top for developers who prefer a declarative, standards-based approach.

Oracle introduced Helidon in 2018 as Project J4C (Java for Cloud), and it has since become a key component in the
Oracle Cloud Native ecosystem. Helidon 4 adopted Java 21 virtual threads (Project Loom) as its concurrency foundation,
replacing the earlier reactive Netty-based engine with a blocking-style API that retains non-blocking performance
characteristics. The framework integrates with GraalVM Native Image for ahead-of-time compilation, and offers built-in
support for gRPC, WebSocket, GraphQL, and observability through OpenTelemetry. It competes directly with
[Micronaut](micronaut.md) and [Quarkus](quarkus.md) in the cloud-native Java
space.

## Further Information

- [helidon.io](https://helidon.io/)
- [Helidon on GitHub](https://github.com/helidon-io/helidon)
- [Wikipedia](https://en.wikipedia.org/wiki/Helidon)
