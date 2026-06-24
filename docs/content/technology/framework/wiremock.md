---
title: "WireMock"
aliases:
- "/framework/wiremock"
bookToC: false
techsheet:
  key: "wiremock"
  type: "framework"
  category: "Testing"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "framework"
    key: "junit"
    comment: "primary test framework companion"
  - type: "framework"
    key: "testcontainers"
    comment: "complementary integration testing tool"
  - type: "framework"
    key: "rest-assured"
    comment: "complementary API testing library"
---

**A flexible HTTP mock server for stubbing and verifying external service calls in automated tests.**

WireMock is an HTTP mock server that runs on the [JVM](../tool/jvm.md) and allows developers to simulate the
behavior of external APIs during testing. It supports request matching by URL, headers, query parameters, and request
body content using exact, regex, and JSONPath-based matchers. The server can run embedded within
a [JUnit](junit.md) test, as a standalone process, or as a Docker container, and provides both
a [Java](../language/java.md)/[Kotlin](../language/kotlin.md) API and a JSON-over-HTTP admin interface for
programmatic stub configuration. WireMock also supports response templating, fault injection, configurable delays, and
record-playback of real API interactions for generating stubs automatically.

The framework is widely adopted in microservice architectures where isolating services from their dependencies during
integration and contract testing is essential. It integrates naturally with [JUnit](junit.md) through
dedicated extensions and rules, and is frequently combined with [REST Assured](rest-assured.md) for
end-to-end API verification and [Testcontainers](testcontainers.md) for managing its Docker-based
standalone mode. WireMock Cloud (formerly MockLab) extends the open-source project with a hosted, team-oriented mock
service, and the project has expanded its language support through SDKs for Python, Go, and Rust alongside its core JVM
implementation.

## Further Information

- [wiremock.org](https://wiremock.org/)
- [WireMock Documentation](https://wiremock.org/docs/)
- [Wikipedia](https://en.wikipedia.org/wiki/WireMock)
