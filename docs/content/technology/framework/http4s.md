---
title: http4s
aliases:
  - /framework/http4s
bookToC: false
techsheet:
  key: http4s
  type: framework
  category: Application
  languages:
    - scala
  related:
    - type: language
      key: scala
      comment: "primary language"
    - type: framework
      key: cats-effect
      comment: "foundational effect system"
    - type: framework
      key: akka-http
      comment: "Scala HTTP alternative"
    - type: framework
      key: play-framework
      comment: "Scala web framework alternative"
    - type: tool
      key: jvm
      comment: "runtime platform"
---

**A purely functional HTTP library for [Scala](../language/scala.md), built on
typelevel [Cats Effect](cats-effect.md) for composable, streaming server and client applications.**

http4s models HTTP services as Kleisli functions from requests to responses wrapped in an effect type, making the entire
HTTP layer referentially transparent and composable. The library uses fs2 for streaming request and response bodies,
enabling constant-memory processing of large payloads. Its design leverages [Scala](../language/scala.md)'s type
system extensively, encoding
HTTP semantics such as media types, headers, and status codes as typed values rather than raw strings. http4s supports
multiple server backends including Blaze (its original Netty-based backend), Ember (a pure-functional backend built on
fs2), and Jetty, as well as client implementations for making outbound HTTP requests.

The library is a core component of the Typelevel ecosystem and is widely adopted in [Scala](../language/scala.md)
services that follow a
functional programming approach. It integrates naturally with other Typelevel libraries such as circe for JSON, doobie
for database access, and tapir for API documentation. http4s runs on the [JVM](../tool/jvm.md) and has
experimental Scala Native
support. The 0.23.x series targets [Cats Effect](cats-effect.md) 3 and represents the current stable
line, while the 1.0
milestone aims to provide long-term API stability.

## Further Information

- [http4s.org](https://http4s.org/)
- [GitHub](https://github.com/http4s/http4s)
- [Wikipedia](https://en.wikipedia.org/wiki/Http4s)
