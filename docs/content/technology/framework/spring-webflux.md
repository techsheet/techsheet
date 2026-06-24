---
title: "Spring WebFlux"
aliases:
- "/framework/spring-webflux"
bookToC: false
techsheet:
  key: "spring-webflux"
  type: "framework"
  category: "Application"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "framework"
    key: "reactor"
    comment: "reactive foundation library"
  - type: "framework"
    key: "spring-boot"
    comment: "parent application framework"
  - type: "framework"
    key: "spring-mvc"
    comment: "imperative counterpart in Spring"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
---

**A non-blocking, reactive web framework in the Spring ecosystem for building
event-driven [Java](../language/java.md) and [Kotlin](../language/kotlin.md) applications on
the [JVM](../tool/jvm.md).**

Spring WebFlux is the reactive-stack web framework introduced in Spring Framework 5 as a non-blocking alternative
to [Spring MVC](spring-mvc.md). Built on [Project Reactor](reactor.md) and the
Reactive Streams specification, it processes HTTP requests through an asynchronous, event-loop model rather than the
thread-per-request approach of traditional servlet-based frameworks. The framework offers two programming models: an
annotation-based model that mirrors Spring MVC's controller style, and a functional endpoint model that uses handler
functions and router functions for a more explicit, lambda-oriented composition. It runs on non-blocking servers such as
Netty, Undertow, and Servlet 3.1+ containers, with Reactor Netty as the default runtime.

The framework is designed for workloads that require high concurrency with minimal threads, such as API gateways,
streaming endpoints, and service-to-service communication in microservice architectures. It integrates with Spring's
broader reactive ecosystem, including Spring Data R2DBC for reactive database
access, [Spring Security](spring-security.md) for reactive authentication and authorization, and
Spring Cloud Gateway for reactive API routing. [Spring Boot](spring-boot.md) provides
auto-configuration support through the `spring-boot-starter-webflux` dependency, and WebFlux applications can use
`WebClient` as a non-blocking alternative to `RestTemplate`. Since Spring Framework 6 and Spring Boot 3.x, WebFlux
requires Java 17+ and supports GraalVM native images for reduced startup time and memory consumption.

## Further Information

- [Spring WebFlux Reference](https://docs.spring.io/spring-framework/reference/web/webflux.html)
- [spring.io/projects/spring-framework](https://spring.io/projects/spring-framework)
- [Wikipedia](https://en.wikipedia.org/wiki/Spring_Framework)
