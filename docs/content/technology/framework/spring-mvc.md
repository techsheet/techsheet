---
title: Spring MVC
aliases:
  - /framework/spring-mvc
bookToC: false
techsheet:
  key: spring-mvc
  type: framework
  category: Application
  languages:
    - java
    - kotlin
  related:
    - type: framework
      key: spring-boot
      comment: "opinionated bootstrap layer"
    - type: framework
      key: spring-webflux
      comment: "reactive alternative in Spring"
    - type: framework
      key: spring-security
      comment: "authentication and authorization companion"
    - type: language
      key: java
      comment: "primary implementation language"
---

**The web framework module of the Spring Framework, providing a servlet-based model-view-controller architecture for
building [Java](../language/java.md) and [Kotlin](../language/kotlin.md) web applications.**

Spring MVC is a request-driven web framework built on the Java Servlet API and the broader Spring Framework's
inversion-of-control container. It implements the model-view-controller pattern through a central `DispatcherServlet`
that routes incoming HTTP requests to annotated controller methods, which return model data to pluggable view resolvers.
The framework supports annotation-based configuration (`@Controller`, `@RequestMapping`, `@RestController`), flexible
data binding, validation via JSR 380 (Bean Validation), content negotiation, and built-in support for producing JSON,
XML, and HTML responses. Its synchronous, one-request-per-thread processing model is straightforward to reason about and
integrates naturally with traditional JDBC data access, JPA providers like [Hibernate](hibernate.md),
and transaction management through [Spring Data](spring-data.md).

In practice, Spring MVC is rarely used standalone; most projects bootstrap it
through [Spring Boot](spring-boot.md), which auto-configures an embedded servlet container (Tomcat,
Jetty, or Undertow) and provides production-ready defaults. It remains the dominant server-side web framework in
the [Java](../language/java.md) ecosystem and is widely adopted for REST APIs, server-rendered web applications,
and enterprise integration layers. With the introduction of [Spring WebFlux](spring-webflux.md) in
Spring 5, developers can choose between Spring MVC's blocking servlet model and a fully reactive, non-blocking
alternative within the same framework family, though Spring MVC continues to be the recommended choice for conventional
workloads.

## Further Information

- [Spring MVC Documentation](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [spring.io](https://spring.io/projects/spring-framework)
- [Wikipedia](https://en.wikipedia.org/wiki/Spring_Framework)
