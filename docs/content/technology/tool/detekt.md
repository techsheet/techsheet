---
title: "Detekt"
aliases:
- "/tool/detekt"
bookToC: false
techsheet:
  key: "detekt"
  type: "tool"
  category: "Format"
  related:
  - type: "language"
    key: "kotlin"
    comment: "target language"
  - type: "tool"
    key: "ktlint"
    comment: "complementary Kotlin linter/formatter"
  - type: "tool"
    key: "gradle"
    comment: "primary build tool integration"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
---

**A static code analysis tool for [Kotlin](../language/kotlin.md) that detects code smells, complexity issues, and
style violations.**

Detekt is a static analysis engine designed specifically for [Kotlin](../language/kotlin.md) codebases. It
inspects source code without executing it, identifying potential problems such as excessive complexity, long methods,
naming convention violations, and common anti-patterns. The tool ships with over 200 built-in rules organized into
categories including style, complexity, naming, performance, and potential bugs. Rules are highly configurable through a
YAML configuration file, and teams can write custom rules as compiler plugins or by extending the rule provider API.
Detekt integrates with the [Kotlin compiler](../language/kotlin.md) analysis infrastructure, operating on the
abstract syntax tree to perform its inspections.

In practice, detekt is typically integrated into [Gradle](gradle.md)-based build pipelines via an official
Gradle plugin, though it also supports Maven and standalone CLI invocation. It produces reports in HTML, XML, SARIF, and
plain text formats, making it compatible with CI systems and code quality dashboards. Detekt is often used
alongside [ktlint](ktlint.md), which focuses narrowly on formatting and code style, while detekt covers
broader structural and complexity analysis. The project is maintained under the detekt organization on GitHub and
follows Kotlin's release cadence closely, adding support for new language features shortly after they stabilize.

## Further Information

- [detekt.dev](https://detekt.dev/)
- [GitHub](https://github.com/detekt/detekt)
- [Wikipedia](https://en.wikipedia.org/wiki/Detekt)
