---
title: "Quarkus"
aliases:
- "/framework/quarkus"
bookToC: false
techsheet:
  key: "quarkus"
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
    key: "micronaut"
    comment: "alternative compile-time JVM framework"
  - type: "framework"
    key: "spring-boot"
    comment: "dominant JVM framework alternative"
  - type: "language"
    key: "kotlin"
    comment: "supported implementation language"
---

**A Kubernetes-native [Java](../language/java.md) framework tailored for GraalVM native images and HotSpot,
designed for fast startup and low memory consumption in cloud environments.**

Quarkus is a full-stack framework built on established [Java](../language/java.md) standards including Jakarta
EE (CDI, JAX-RS, JPA) and Eclipse MicroProfile. It employs an extensions architecture that shifts as much processing as
possible to build time, performing classpath scanning, configuration parsing, and annotation processing during
compilation rather than at application startup. This build-time augmentation approach produces applications with startup
times measured in tens of milliseconds when compiled to GraalVM native images, and dramatically reduced memory
footprints compared to traditional [JVM](../tool/jvm.md) frameworks. The framework supports both imperative and
reactive programming models through a unified programming surface, with Vert.x integrated as its core reactive engine.

Red Hat initiated the project in 2019 under the name "Supersonic Subatomic Java," targeting the specific constraints of
container-orchestrated and serverless environments. Quarkus provides first-class support
for [Kotlin](../language/kotlin.md) alongside Java, and its Dev Services feature automatically provisions
containerized databases, message brokers, and other infrastructure during development. The extension ecosystem covers
over 400 integrations including [Hibernate](hibernate.md) ORM with Panache, RESTEasy, SmallRye (
MicroProfile implementations), [Apache Kafka](kafka.md), and gRPC. Quarkus Dev Mode offers live
reload with background compilation, a Dev UI console, and continuous testing, substantially streamlining the development
feedback loop on the JVM.

## Further Information

- [quarkus.io](https://quarkus.io/)
- [Quarkus Guides](https://quarkus.io/guides/)
- [Wikipedia](https://en.wikipedia.org/wiki/Quarkus)
