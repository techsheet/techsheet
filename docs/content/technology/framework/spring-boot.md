---
title: "Spring Boot"
aliases:
- "/framework/spring-boot"
bookToC: false
techsheet:
  key: "spring-boot"
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
    comment: "alternative cloud-native JVM framework"
  - type: "framework"
    key: "micronaut"
    comment: "alternative compile-time JVM framework"
  - type: "framework"
    key: "hibernate"
    comment: "default JPA provider"
---

**An opinionated, convention-over-configuration framework for building
production-ready [Java](../language/java.md) and [Kotlin](../language/kotlin.md) applications on the Spring
ecosystem.**

Spring Boot simplifies the creation of Spring-based applications by providing auto-configuration, embedded servers (
Tomcat, Jetty, Undertow), and starter dependencies that eliminate most boilerplate setup. It builds on the Spring
Framework's dependency injection and aspect-oriented programming model, adding an opinionated default configuration
layer that can be overridden as needed. The framework manages application lifecycle through executable JAR packaging,
externalized configuration via properties and YAML files, and a comprehensive actuator module for health checks,
metrics, and runtime introspection. Support for both imperative ([Spring MVC](spring-mvc.md)) and
reactive ([Spring WebFlux](spring-webflux.md)) programming models allows applications to choose the
concurrency approach that fits their workload.

The framework dominates enterprise [JVM](../tool/jvm.md) backend development, powering microservices, REST APIs,
batch processing systems, and event-driven architectures across industries. Integration
with [Spring Data](spring-data.md), [Spring Security](spring-security.md), and
Spring Cloud provides a cohesive stack for data access, authentication, and distributed systems concerns. Spring Boot
3.x moved to Jakarta EE 9+ namespaces and requires Java 17+, while adding first-class GraalVM native image support for
ahead-of-time compilation, significantly reducing startup time and memory footprint. The Spring Initializr (
start.spring.io) remains the standard project scaffolding tool for the ecosystem.

## Further Information

- [spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
- [Spring Initializr](https://start.spring.io/)
- [Wikipedia](https://en.wikipedia.org/wiki/Spring_Boot)
