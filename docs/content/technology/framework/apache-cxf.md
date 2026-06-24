---
title: "Apache CXF"
aliases:
- "/framework/apache-cxf"
bookToC: false
techsheet:
  key: "apache-cxf"
  type: "framework"
  category: "Application"
  languages:
  - "java"
  related:
  - type: "language"
    key: "java"
    comment: "implementation language"
  - type: "framework"
    key: "jakarta-ee"
    comment: "specification provider (JAX-WS, JAX-RS)"
  - type: "framework"
    key: "spring-boot"
    comment: "common integration target"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
---

**An open-source services framework for building and consuming SOAP and RESTful web services on
the [JVM](../tool/jvm.md).**

Apache CXF is a [Java](../language/java.md)-based framework that provides a full implementation of the JAX-WS and
JAX-RS specifications,
enabling developers to build web services using a code-first or contract-first approach. It supports SOAP 1.1/1.2,
WS-Security, WS-ReliableMessaging, WS-Addressing, and other WS-* standards, alongside first-class REST support through
JAX-RS (Jakarta RESTful Web Services). CXF generates WSDL from Java classes and vice versa, and its interceptor-based
architecture allows fine-grained control over message processing pipelines for both clients and servers.

The framework is widely deployed in enterprise environments where SOAP interoperability and standards compliance are
required, particularly in financial services, government, and telecommunications. CXF integrates with
[Spring](spring-boot.md) and can be embedded in [Jakarta EE](jakarta-ee.md)
application servers or run standalone with an embedded Jetty or Undertow container. Originally formed from the merger of
the Celtix and XFire projects, CXF has been a top-level Apache Software Foundation project since 2008 and continues to
track updates to the Jakarta XML Web Services and Jakarta RESTful Web Services specifications.

## Further Information

- [cxf.apache.org](https://cxf.apache.org/)
- [CXF Documentation](https://cxf.apache.org/docs/index.html)
- [Wikipedia](https://en.wikipedia.org/wiki/Apache_CXF)
