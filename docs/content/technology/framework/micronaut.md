---
title: "Micronaut"
aliases:
- "/framework/micronaut"
bookToC: false
techsheet:
  key: "micronaut"
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
    comment: "alternative compile-time JVM framework"
  - type: "framework"
    key: "spring-boot"
    comment: "dominant JVM framework alternative"
  - type: "language"
    key: "kotlin"
    comment: "supported implementation language"
---

**A compile-time, reflection-free application framework for building modular microservices and serverless applications
on the [JVM](../tool/jvm.md).**

Micronaut is a modern [Java](../language/java.md) and [Kotlin](../language/kotlin.md) framework that
performs dependency injection, AOP proxy generation, and configuration processing at compile time rather than at
runtime. This ahead-of-time (AOT) approach eliminates the reflection and runtime classpath scanning used by traditional
frameworks, resulting in near-instant startup times and a low, fixed memory footprint regardless of the number of
injected beans. The framework provides a built-in, non-blocking HTTP server and client based on Netty, a compile-time
validation and serialization layer (Micronaut Serialization), and declarative clients for HTTP, Kafka, RabbitMQ, and
gRPC. Its module system covers data access (Micronaut Data), security, distributed tracing, service discovery, and
configuration sharing through a consistent programming model.

The framework was created by the Grails team at Object Computing and first released in 2018, specifically targeting the
limitations of Spring's runtime reflection model in cloud-native and serverless deployment scenarios. Micronaut
applications are well-suited to GraalVM native image compilation, producing standalone binaries with sub-50ms startup
times. The Micronaut Launch project scaffolding tool (launch.micronaut.io)
supports [Java](../language/java.md), [Kotlin](../language/kotlin.md),
and [Groovy](../language/groovy.md) as implementation languages. Micronaut 4.x adopted Java 17 as the minimum
version and introduced support for virtual threads, HTTP/2, and expression language evaluation, further aligning the
framework with modern JVM capabilities.

## Further Information

- [micronaut.io](https://micronaut.io/)
- [Micronaut Launch](https://launch.micronaut.io/)
- [Wikipedia](https://en.wikipedia.org/wiki/Micronaut_(software_framework))
