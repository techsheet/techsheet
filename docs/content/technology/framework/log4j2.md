---
title: Log4j2
aliases:
  - /framework/log4j2
bookToC: false
techsheet:
  key: log4j2
  type: framework
  category: Logging
  languages:
    - java
    - kotlin
  related:
    - type: framework
      key: slf4j
      comment: "common logging facade"
    - type: framework
      key: logback
      comment: "alternative logging backend"
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: language
      key: java
      comment: "primary language"
---

**A high-performance, extensible logging framework for [Java](../language/java.md) applications, built as the
successor to the original Log4j.**

Log4j2 is an open-source logging library developed by the Apache Software Foundation, designed as a complete rewrite of
Log4j 1.x. It provides an asynchronous logging architecture based on the LMAX Disruptor library, achieving significantly
higher throughput and lower latency than its predecessor and competing frameworks. The framework supports a plugin-based
architecture for appenders, layouts, filters, and lookups, uses a garbage-free mode to minimize GC pressure in
latency-sensitive applications, and features automatic configuration reloading without losing log events. Log4j2 runs on
the [JVM](../tool/jvm.md) and supports configuration through XML, JSON, YAML, and properties files.

The framework is widely adopted in enterprise [Java](../language/java.md)
and [Kotlin](../language/kotlin.md)
applications, and serves as a backend implementation for [SLF4J](slf4j.md) through the
log4j-slf4j-impl
bridge. Log4j2 gained significant attention in December 2021 due to the Log4Shell vulnerability (CVE-2021-44228), which
affected its JNDI lookup feature and prompted a rapid series of security patches. Since then, the project has
strengthened its security posture and continues active development under the Apache Logging Services umbrella.

## Further Information

- [logging.apache.org/log4j/2.x](https://logging.apache.org/log4j/2.x/)
- [Log4j2 GitHub Repository](https://github.com/apache/logging-log4j2)
- [Wikipedia](https://en.wikipedia.org/wiki/Log4j)
