---
title: "Kotlin"
aliases:
- "/language/kotlin"
bookToC: false
techsheet:
  key: "kotlin"
  type: "language"
  related:
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "language"
    key: "java"
    comment: "JVM sibling, full interop"
  - type: "language"
    key: "scala"
    comment: "JVM sibling, functional alternative"
  - type: "language"
    key: "groovy"
    comment: "JVM sibling, dynamic scripting"
  - type: "tool"
    key: "gradle"
    comment: "primary build tool, Kotlin DSL"
---

**A modern, statically typed programming language for the [JVM](../tool/jvm.md), Android, and multiplatform
development, designed for conciseness, safety, and full [Java](java.md) interoperability.**

Kotlin is a general-purpose, cross-platform language developed by JetBrains, first released in 2011 and reaching 1.0 in

2016. It compiles to JVM bytecode, JavaScript, or native binaries via LLVM, and is fully interoperable with
      [Java](java.md), allowing incremental adoption in existing codebases. The language emphasizes
      null safety through its type
      system, distinguishing nullable and non-nullable types at compile time. Coroutines provide structured concurrency
      as a
      first-class language feature, and extension functions, data classes, sealed classes, and smart casts enable
      expressive
      code with minimal boilerplate. Kotlin supports both object-oriented and functional programming paradigms, with
      higher-order functions, lambda expressions, and type inference throughout.

Google designated Kotlin the preferred language for Android development in 2019, and it has since become the dominant
language for new Android projects. On the server side, Kotlin is widely used with Spring Boot, Ktor, and Quarkus.
Kotlin Multiplatform (KMP) enables sharing business logic across JVM, iOS, web, and desktop targets from a single
codebase. [Gradle](../tool/gradle.md) adopted Kotlin as its primary DSL (Kotlin DSL), and the language has become
a common choice for build scripting and developer tooling. Recent releases (1.9+, 2.0) introduced the K2 compiler with
significantly faster compilation, stable multiplatform support, and continued refinement of the type system.

## Further Information

- [kotlinlang.org](https://kotlinlang.org/)
- [Kotlin Playground](https://play.kotlinlang.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Kotlin_(programming_language))
