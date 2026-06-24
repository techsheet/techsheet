---
title: Play Framework
aliases:
  - /framework/play-framework
bookToC: false
techsheet:
  key: play-framework
  type: framework
  category: Application
  languages:
    - java
    - scala
  related:
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: language
      key: scala
      comment: "primary language"
    - type: framework
      key: akka-http
      comment: "Scala web alternative, shared Akka ecosystem"
    - type: framework
      key: spring-boot
      comment: "major JVM web framework alternative"
    - type: tool
      key: sbt
      comment: "default build tool"
---

**A reactive, full-stack web application framework for [Scala](../language/scala.md)
and [Java](../language/java.md) built on a stateless, non-blocking architecture.**

Play Framework is a high-productivity web framework that runs on the [JVM](../tool/jvm.md) and follows the
convention-over-configuration
principle. Unlike traditional Java EE servlet-based frameworks, it uses a fully asynchronous, non-blocking I/O model
built on Akka Streams and the Akka actor system. The framework provides a built-in development server with hot code
reloading, a type-safe routing DSL, built-in JSON handling, and first-class support for WebSockets and Server-Sent
Events. Its template engine, Twirl, compiles templates to Scala functions, catching errors at compile time rather than
at runtime.

Originally created by Guillaume Bort in 2007 and later maintained by Lightbend, Play gained significant adoption in
the Scala ecosystem as the go-to web framework alongside [Akka HTTP](akka-http.md). It is commonly
built with [SBT](../tool/sbt.md), though Gradle support is also available. Notable users have included LinkedIn,
Samsung, and The Guardian. Following Lightbend's shift in focus, the project transitioned to community-driven
maintenance under the Apache Pekko ecosystem, with Play 3.0 replacing Akka dependencies with their Apache Pekko
equivalents due to Akka's license change.

## Further Information

- [playframework.com](https://www.playframework.com/)
- [Play Framework GitHub](https://github.com/playframework/playframework)
- [Wikipedia](https://en.wikipedia.org/wiki/Play_Framework)
