---
title: Akka
aliases:
  - /framework/akka
bookToC: false
techsheet:
  key: akka
  type: framework
  category: Concurrency
  languages:
    - scala
    - java
  related:
    - type: language
      key: scala
      comment: "primary language"
    - type: language
      key: java
      comment: "supported language via Java API"
    - type: framework
      key: akka-http
      comment: "HTTP module built on Akka"
    - type: framework
      key: play-framework
      comment: "web framework historically built on Akka"
    - type: tool
      key: jvm
      comment: "runtime platform"
---

**A toolkit for building concurrent, distributed, and fault-tolerant applications on the [JVM](../tool/jvm.md)
using the actor model.**

Akka implements the actor model for the [Java Virtual Machine](../tool/jvm.md), providing a high-level abstraction
for concurrent and distributed computation. Actors are lightweight, isolated units of processing that communicate
exclusively through asynchronous message passing, eliminating shared mutable state and the complexity of traditional
thread-based concurrency. The toolkit includes supervision hierarchies for fault tolerance, location-transparent
messaging for distribution across nodes, and Akka Streams for backpressure-aware stream processing. While primarily
written in and designed for [Scala](../language/scala.md), Akka provides a full [Java](../language/java.md)
API.

The framework is widely used in systems that require high throughput, low latency, and resilience, including financial
services platforms, IoT backends, and real-time data pipelines. [Akka HTTP](akka-http.md) and
the [Play Framework](play-framework.md) historically relied on Akka as their runtime foundation. In
2022, Lightbend changed Akka's license from Apache 2.0 to the Business Source License (BSL 1.1) starting with version
2.7, prompting the Apache Pekko project as a community-maintained open-source fork of Akka 2.6.

## Further Information

- [akka.io](https://akka.io/)
- [Akka Documentation](https://doc.akka.io/)
- [Wikipedia](https://en.wikipedia.org/wiki/Akka_(toolkit))
