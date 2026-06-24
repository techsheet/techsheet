---
title: Akka HTTP
aliases:
  - /framework/akka-http
bookToC: false
techsheet:
  key: akka-http
  type: framework
  category: Application
  languages:
    - scala
    - java
  related:
    - type: framework
      key: akka
      comment: "underlying actor system"
    - type: language
      key: scala
      comment: "primary language"
    - type: framework
      key: play-framework
      comment: "alternative JVM web framework, also Akka-based"
    - type: framework
      key: http4s
      comment: "alternative Scala HTTP framework"
---

**A reactive HTTP toolkit for building REST APIs and streaming services on top of [Akka](akka.md)
actors and Akka Streams.**

Akka HTTP is a full server- and client-side HTTP stack built as a module of the [Akka](akka.md)
toolkit. It provides a
routing DSL for defining HTTP endpoints declaratively, with support for path matching, parameter extraction, content
negotiation, and marshalling/unmarshalling of request and response entities. The framework is built entirely on Akka
Streams, which means it handles backpressure natively and processes HTTP connections as materialised stream graphs. This
design makes it well-suited for workloads that require high concurrency and controlled resource consumption without
thread-per-request overhead. Both [Scala](../language/scala.md) and [Java](../language/java.md) APIs are
provided, though the Scala DSL is considered the more idiomatic interface.

The toolkit is used in production for microservices, API gateways, and streaming HTTP endpoints, particularly in
organisations already invested in the Akka ecosystem. Akka HTTP served as the default HTTP layer in the
[Play Framework](play-framework.md) (since Play 2.6) and remains a common choice for Scala-based
backend services on the [JVM](../tool/jvm.md). Following Lightbend's relicensing of Akka to the Business Source
License in 2022, the Apache Pekko project was created as an open-source fork, with Pekko HTTP offering an
API-compatible alternative under the Apache 2.0 licence.

## Further Information

- [Akka HTTP Documentation](https://doc.akka.io/libraries/akka-http/current/)
- [GitHub Repository](https://github.com/akka/akka-http)
- [Wikipedia](https://en.wikipedia.org/wiki/Akka_(toolkit))
