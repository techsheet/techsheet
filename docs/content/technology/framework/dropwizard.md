---
title: Dropwizard
aliases:
  - /framework/dropwizard
bookToC: false
techsheet:
  key: dropwizard
  type: framework
  category: Application
  languages:
    - java
  related:
    - type: language
      key: java
      comment: "primary language"
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: framework
      key: spring-boot
      comment: "dominant alternative for Java microservices"
    - type: framework
      key: micronaut
      comment: "modern lightweight alternative"
    - type: framework
      key: jakarta-ee
      comment: "provides JAX-RS and Servlet APIs used internally"
---

**An opinionated [Java](../language/java.md) framework for building production-ready RESTful web services with
minimal configuration.**

Dropwizard combines a curated set of stable, mature [Java](../language/java.md) libraries into a lightweight,
operations-friendly framework for developing RESTful services. It bundles Jetty as an embedded HTTP server, Jersey for
JAX-RS-based REST endpoints, Jackson for JSON processing, Hibernate Validator for input validation, and Metrics for
real-time application monitoring. The framework follows a convention-over-configuration approach with a single YAML
configuration file and produces a self-contained fat JAR, making deployment straightforward. By selecting and
integrating these libraries, Dropwizard eliminates the overhead of assembling a bespoke stack while keeping the overall
footprint small.

The framework gained popularity in the early 2010s as a lightweight alternative to
full [Jakarta EE](jakarta-ee.md) application servers, particularly for microservice architectures. It
was originally developed at Yammer and has been widely adopted for internal platform services at companies favoring lean
Java stacks. While [Spring Boot](spring-boot.md) has become the more dominant choice in the broader
Java ecosystem, Dropwizard remains actively maintained and valued for its simplicity, fast startup, and minimal
abstraction over well-understood components.

## Further Information

- [dropwizard.io](https://www.dropwizard.io/)
- [Dropwizard on GitHub](https://github.com/dropwizard/dropwizard)
- [Wikipedia](https://en.wikipedia.org/wiki/Dropwizard)
