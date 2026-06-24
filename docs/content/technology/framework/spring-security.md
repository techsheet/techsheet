---
title: Spring Security
aliases:
  - /framework/spring-security
bookToC: false
techsheet:
  key: spring-security
  type: framework
  category: Security
  languages:
    - java
    - kotlin
  related:
    - type: framework
      key: spring-boot
      comment: "primary host framework"
    - type: framework
      key: spring-mvc
      comment: "secures servlet-based web apps"
    - type: framework
      key: spring-webflux
      comment: "secures reactive web apps"
    - type: tool
      key: jvm
      comment: "runtime platform"
---

**A comprehensive authentication and access-control framework for securing [Java](../language/java.md)
and [Kotlin](../language/kotlin.md) applications built on the Spring ecosystem.**

Spring Security provides a highly customizable security layer that handles authentication, authorization, and protection
against common exploits such as CSRF, session fixation, and clickjacking. Its architecture is built around a chain of
servlet filters (or WebFilter equivalents in reactive stacks) that intercept HTTP requests and apply security logic
before they reach application code. The framework supports a wide range of authentication mechanisms out of the box,
including form-based login, HTTP Basic, OAuth 2.0 / OpenID Connect, SAML 2.0, LDAP, and X.509 certificates.
Authorization decisions are expressed through a combination of URL-based rules, method-level annotations (
`@PreAuthorize`, `@Secured`), and a pluggable access-decision architecture that supports both role-based and
expression-based policies.

Virtually every [Spring Boot](spring-boot.md) application that exposes HTTP endpoints relies on
Spring Security for its security layer, making it the de facto standard for JVM-based web security. The framework
integrates seamlessly with both [Spring MVC](spring-mvc.md) for servlet-based applications
and [Spring WebFlux](spring-webflux.md) for reactive applications, adapting its filter chain model to
each programming paradigm. Spring Security 6.x, aligned with Spring Boot 3.x, moved to Jakarta EE namespaces, adopted a
component-based configuration model replacing the legacy `WebSecurityConfigurerAdapter`, and introduced the
Authorization Server project as a standalone module for building OAuth 2.0 authorization servers.

## Further Information

- [spring.io/projects/spring-security](https://spring.io/projects/spring-security)
- [Spring Security Reference Documentation](https://docs.spring.io/spring-security/reference/)
- [Wikipedia](https://en.wikipedia.org/wiki/Spring_Security)
