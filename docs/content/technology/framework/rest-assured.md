---
title: "REST Assured"
aliases:
- "/framework/rest-assured"
bookToC: false
techsheet:
  key: "rest-assured"
  type: "framework"
  category: "Testing"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "framework"
    key: "junit"
    comment: "typical test runner"
  - type: "language"
    key: "java"
    comment: "primary language"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "framework"
    key: "wiremock"
    comment: "complementary API stubbing"
---

**A Java DSL for testing and validating REST APIs with a fluent, BDD-style syntax.**

REST Assured is an open-source [Java](../language/java.md) library that simplifies testing of RESTful HTTP
services. It
provides a domain-specific language built around a given/when/then structure inspired by behavior-driven development,
allowing developers to write expressive HTTP request and response assertions without boilerplate. The library handles
serialization and deserialization transparently using Jackson, Gson, or JAXB, and supports JsonPath and XmlPath
expressions for extracting and validating nested response data. Authentication schemes including OAuth 1/2, basic, form,
and certificate-based authentication are supported natively.

The framework is typically used alongside [JUnit](junit.md) or TestNG as the test runner and
integrates naturally with
assertion libraries such as [AssertJ](assertj.md) and Hamcrest matchers. It runs on the
[JVM](../tool/jvm.md) and can be used from both [Java](../language/java.md)
and [Kotlin](../language/kotlin.md). REST Assured supports
multipart uploads, logging of request/response details, specification reuse through request and response specifications,
and Spring MockMvc integration for testing Spring controllers without starting a full HTTP server. It is one of the most
widely adopted libraries for API integration testing in JVM-based projects.

## Further Information

- [rest-assured.io](https://rest-assured.io/)
- [GitHub](https://github.com/rest-assured/rest-assured)
- [Wikipedia](https://en.wikipedia.org/wiki/REST-assured)
