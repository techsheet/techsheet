---
title: "Logback"
aliases:
- "/framework/logback"
bookToC: false
techsheet:
  key: "logback"
  type: "framework"
  category: "Logging"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "framework"
    key: "slf4j"
    comment: "native API facade"
  - type: "framework"
    key: "log4j2"
    comment: "direct alternative"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "language"
    key: "java"
    comment: "primary language"
---

**A reliable, fast, and flexible logging framework for [Java](../language/java.md) applications, designed as the
successor to Log4j.**

Logback is a logging framework for the [JVM](../tool/jvm.md) that natively implements
the [SLF4J](slf4j.md) API, eliminating the bridging layer required by other logging backends. It was
created by Ceki Gulcu, the original author of Log4j, to address architectural shortcomings in that project. Logback's
core design separates concerns into three modules: logback-core provides the foundational appender and encoder
infrastructure, logback-classic implements the SLF4J API and handles log event processing, and logback-access integrates
with servlet containers for HTTP access logging. The framework supports automatic configuration reloading, conditional
processing in configuration files, and fine-grained filtering through TurboFilters and EvaluatorFilters.

Logback is the default logging backend in [Spring Boot](spring-boot.md) and is widely adopted across
JVM-based enterprise applications. Its configuration uses XML or Groovy-based files and supports advanced features such
as rolling file appenders with time- and size-based policies, asynchronous logging via AsyncAppender, and structured
logging through custom encoders. Logback 1.3+ targets Jakarta EE (the javax-to-jakarta namespace migration), while the
1.4 line requires Java 11 or later and aligns with the SLF4J 2.x API, which introduced fluent logging and the
ServiceLoader-based provider mechanism.

## Further Information

- [logback.qos.ch](https://logback.qos.ch/)
- [Logback Manual](https://logback.qos.ch/manual/index.html)
- [Wikipedia](https://en.wikipedia.org/wiki/Logback)
