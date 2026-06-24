---
title: Jakarta EE
aliases:
  - /framework/jakarta-ee
bookToC: false
techsheet:
  key: jakarta-ee
  type: framework
  category: Application
  languages:
    - java
  related:
    - type: language
      key: java
      comment: "implementation language"
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: framework
      key: spring-boot
      comment: "dominant alternative for Java enterprise apps"
    - type: framework
      key: quarkus
      comment: "cloud-native Jakarta EE alternative"
    - type: framework
      key: hibernate
      comment: "reference implementation of JPA"
---

**A set of specifications for enterprise [Java](../language/java.md) that standardizes APIs for building portable,
scalable, server-side applications.**

Jakarta EE (formerly Java EE and J2EE) is a collection of coordinated specifications maintained by the Eclipse
Foundation
under an open governance model. It defines standard APIs for dependency injection (CDI), persistence (JPA), RESTful web
services (JAX-RS), messaging (JMS), security, transactions, and server-side web development (Servlets, JSF). Each
specification has one or more certified implementations provided by application server vendors such as Eclipse
GlassFish,
Red Hat WildFly, IBM Open Liberty, and Payara, allowing applications to be portable across runtimes without code
changes.

The platform originated as J2EE in 1999 under Sun Microsystems and was renamed Java EE under Oracle before being
transferred to the Eclipse Foundation in 2017, where it was rebranded as Jakarta EE with a new `jakarta.*` namespace
starting in version 9. Modern Jakarta EE (10+) has shifted toward lightweight, CDI-centric programming models and
cloud-native deployment, competing with frameworks like [Spring Boot](spring-boot.md),
[Quarkus](quarkus.md), and [Micronaut](micronaut.md), the latter two of which
themselves build on top of Jakarta EE specifications such as JPA and JAX-RS.

## Further Information

- [jakarta.ee](https://jakarta.ee/)
- [Eclipse Foundation Jakarta EE Specifications](https://jakarta.ee/specifications/)
- [Wikipedia](https://en.wikipedia.org/wiki/Jakarta_EE)
