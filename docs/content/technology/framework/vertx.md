---
title: "Vert.x"
aliases:
- "/framework/vertx"
bookToC: false
techsheet:
  key: "vertx"
  type: "framework"
  category: "Application"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "language"
    key: "java"
    comment: "primary implementation language"
  - type: "framework"
    key: "quarkus"
    comment: "built on Vert.x, native integration"
  - type: "framework"
    key: "spring-webflux"
    comment: "reactive JVM alternative"
---

**A polyglot, event-driven application framework for building reactive and high-performance applications on
the [JVM](../tool/jvm.md).**

Vert.x is a toolkit for building reactive applications on the [Java Virtual Machine](../tool/jvm.md), originally
created by Tim Fox and now part of the Eclipse Foundation. Its architecture is based on an event loop model inspired by
Node.js, where a small number of threads handle large numbers of concurrent connections through non-blocking I/O. The
framework provides a multi-reactor pattern, distributing event loops across available CPU cores, and communicates
between
components via a distributed event bus. Written primarily in [Java](../language/java.md), it supports multiple JVM
languages including [Kotlin](../language/kotlin.md), Groovy, and Scala, and offers a modular design where
developers pick only the components they need.

The toolkit is used for building microservices, API gateways, real-time web applications, and high-throughput backend
systems that require handling tens of thousands of concurrent connections with minimal resource consumption.
[Quarkus](quarkus.md) uses Vert.x as its underlying reactive engine, making it a foundational layer
in one of the most prominent cloud-native Java frameworks. Vert.x 4 unified callback, future/promise, and RxJava APIs
into a single coherent model, and introduced a code generation layer for idiomatic bindings across supported languages.

## Further Information

- [vertx.io](https://vertx.io/)
- [Vert.x Documentation](https://vertx.io/docs/)
- [Wikipedia](https://en.wikipedia.org/wiki/Eclipse_Vert.x)
