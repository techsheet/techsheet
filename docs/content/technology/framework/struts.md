---
title: Struts
aliases:
  - /framework/struts
bookToC: false
techsheet:
  key: struts
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
      key: spring-mvc
      comment: "modern alternative for Java web MVC"
    - type: framework
      key: jakarta-ee
      comment: "underlying specification platform (Servlets, JSP)"
---

**An open-source Model-View-Controller (MVC) framework for building Java web applications on the Servlet API.**

Apache Struts is a [Java](../language/java.md)-based web application framework that implements the MVC design
pattern on top
of the [Jakarta EE](jakarta-ee.md) Servlet and JSP specifications. Originally created by Craig
McClanahan and
donated to the Apache Software Foundation in 2000, Struts became one of the first widely adopted frameworks for
structuring Java web applications. It provides a centralized controller servlet that dispatches requests to action
classes based on XML configuration, separating business logic from presentation. The framework introduced conventions
for form validation, internationalization, and templating that influenced an entire generation of web frameworks.

The original Struts 1.x held a dominant position in enterprise Java development throughout the early to mid-2000s but
was eventually superseded by [Spring MVC](spring-mvc.md) and other frameworks offering
convention-over-configuration
and annotation-driven development. Struts 2, released in 2007 as a merger with WebWork, brought a redesigned
architecture with interceptor-based request processing, OGNL expression language support, and a plugin system. While
Struts 2 remains under active maintenance by the Apache Software Foundation, its adoption has declined significantly in
favor of [Spring Boot](spring-boot.md) and more recent [JVM](../tool/jvm.md)-based frameworks.
The project has
been the subject of several high-profile security vulnerabilities, most notably the 2017 CVE that led to the Equifax
data breach, which underscored the risks of running outdated framework versions in production.

## Further Information

- [struts.apache.org](https://struts.apache.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Apache_Struts)
- [Apache Struts Security Bulletins](https://struts.apache.org/announce)
