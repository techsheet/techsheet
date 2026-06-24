---
title: "SLF4J"
aliases:
- "/framework/slf4j"
bookToC: false
techsheet:
  key: "slf4j"
  type: "framework"
  category: "Logging"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "framework"
    key: "logback"
    comment: "native SLF4J implementation by the same author"
  - type: "framework"
    key: "log4j2"
    comment: "alternative logging backend"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "language"
    key: "java"
    comment: "primary language"
---

**A facade and abstraction layer for logging frameworks on the [JVM](../tool/jvm.md), enabling pluggable logging
backends.**

SLF4J (Simple Logging Facade for Java) is a logging API that decouples application code from the underlying logging
implementation. It defines a minimal set of interfaces centered around the `Logger` and `LoggerFactory` types, allowing
developers to write log statements without binding to a specific backend at compile time. The actual logging
implementation is selected at deployment time by placing exactly one SLF4J binding on the classpath, following the
facade pattern. SLF4J supports parameterized log messages with `{}` placeholders, avoiding the cost of string
concatenation when a log level is disabled, and provides the `MDC` (Mapped Diagnostic Context) API for attaching
contextual data to log events across threads.

Created by Ceki Gulcu, the author of Log4j, SLF4J has become the de facto standard logging API in the
[Java](../language/java.md) and [Kotlin](../language/kotlin.md) ecosystems. Virtually all major frameworks
and libraries, including Spring Boot,
Apache Camel, and Hibernate, depend on SLF4J for their logging output. [Logback](logback.md) is the
reference implementation and native backend, while [Log4j2](log4j2.md) and java.util.logging can be
used through their respective SLF4J bindings. SLF4J 2.0, released in 2022, introduced the `ServiceLoader`-based
provider mechanism (replacing the static binder), a fluent logging API, and built-in support for structured arguments.

## Further Information

- [slf4j.org](https://www.slf4j.org/)
- [SLF4J Manual](https://www.slf4j.org/manual.html)
- [Wikipedia](https://en.wikipedia.org/wiki/SLF4J)
