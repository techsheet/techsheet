---
title: JVM
aliases:
  - /tool/jvm
bookToC: false
techsheet:
  key: jvm
  type: tool
  category: Runtime
  related:
    - type: language
      key: java
      comment: "primary language of the platform"
    - type: language
      key: kotlin
      comment: "major JVM language, modern alternative to Java"
    - type: language
      key: scala
      comment: "major JVM language, functional paradigm"
    - type: tool
      key: gradle
      comment: "dominant JVM build tool"
    - type: tool
      key: maven
      comment: "traditional JVM build tool"
---

**A platform-independent virtual machine that executes bytecode, serving as the shared runtime
for [Java](../language/java.md), [Kotlin](../language/kotlin.md), [Scala](../language/scala.md), and
other languages.**

The Java Virtual Machine (JVM) is a stack-based abstract computing machine that provides a managed execution environment
for programs compiled to its bytecode format. It handles memory allocation and garbage collection, just-in-time (JIT)
compilation to native machine code, thread scheduling, and a verifier that enforces type safety at class-loading time.
The specification is language-agnostic: any language that compiles to valid `.class` files can run on the JVM, which has
led to a family of languages
including [Java](../language/java.md), [Kotlin](../language/kotlin.md), [Scala](../language/scala.md), [Groovy](../language/groovy.md),
and [Clojure](../language/clojure.md) sharing a common runtime and library ecosystem.

Multiple production-grade implementations exist, including Oracle HotSpot (the reference implementation), Eclipse
OpenJ9, and GraalVM, each offering different performance trade-offs for throughput, latency, and memory footprint.
Recent releases have introduced transformative features: the ZGC and Shenandoah garbage collectors deliver
sub-millisecond pause times, Project Loom added virtual threads for lightweight concurrency, and GraalVM Native Image
enables ahead-of-time compilation to standalone binaries that start in milliseconds. Build tools such
as [Gradle](gradle.md) and [Maven](maven.md) form the standard toolchain for JVM-based
projects.

## Further Information

- [dev.java](https://dev.java/)
- [Eclipse Adoptium](https://adoptium.net/)
- [Wikipedia](https://en.wikipedia.org/wiki/Java_virtual_machine)
