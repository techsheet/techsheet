---
title: "Javalin"
aliases:
- "/framework/javalin"
bookToC: false
techsheet:
  key: "javalin"
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
    comment: "primary language"
  - type: "language"
    key: "kotlin"
    comment: "supported language, first-class API"
  - type: "framework"
    key: "ktor"
    comment: "lightweight Kotlin alternative"
  - type: "framework"
    key: "vertx"
    comment: "lightweight JVM alternative"
---

**A lightweight web framework for [Java](../language/java.md) and [Kotlin](../language/kotlin.md) designed
for simplicity and rapid development of REST APIs and web applications.**

Javalin is built on top of the Jetty web server and runs on the [JVM](../tool/jvm.md). It provides a minimal,
expressive API inspired by frameworks like Sinatra (Ruby) and Koa (JavaScript), favoring convention and conciseness over
configuration. The framework supports both blocking and asynchronous request handling, WebSockets, server-sent events,
and a built-in validation system for request parameters and body content. Javalin's API is designed to be equally
idiomatic in both Java and Kotlin, using a fluent builder pattern that avoids annotations and code generation in favor
of explicit, programmatic route definitions.

The framework targets developers building microservices, REST APIs, and lightweight web applications who want a
low-ceremony alternative to full-stack frameworks like [Spring Boot](spring-boot.md)
or [Micronaut](micronaut.md). Javalin includes an OpenAPI (Swagger) plugin for automatic API
documentation generation, along with plugins for templating engines, JSON serialization, and role-based access control.
Since its initial release in 2017, Javalin has maintained a focus on a small core with optional plugins, keeping the
learning curve shallow and the dependency footprint minimal.

## Further Information

- [javalin.io](https://javalin.io/)
- [GitHub](https://github.com/javalin/javalin)
- [Wikipedia](https://en.wikipedia.org/wiki/Javalin_(web_framework))
