---
title: "ktlint"
aliases:
- "/tool/ktlint"
bookToC: false
techsheet:
  key: "ktlint"
  type: "tool"
  category: "Format"
  related:
  - type: "language"
    key: "kotlin"
    comment: "target language"
  - type: "tool"
    key: "detekt"
    comment: "complementary Kotlin static analysis"
  - type: "tool"
    key: "editorconfig"
    comment: "configuration source for code style rules"
  - type: "tool"
    key: "gradle"
    comment: "primary build tool integration"
---

**An open-source linter and formatter for [Kotlin](../language/kotlin.md) that enforces a consistent code style
with minimal configuration.**

ktlint is a static analysis tool focused on [Kotlin](../language/kotlin.md) code style enforcement, combining
linting and automatic formatting in a single tool. It implements the official Kotlin coding conventions and the Android
Kotlin style guide as its default rule sets, allowing teams to adopt a consistent style without extensive configuration.
The tool is designed around the principle of zero-config by default,
reading [EditorConfig](editorconfig.md) files for customization, and supports custom rule sets through a
well-defined Rule API. Its parser operates directly on the Kotlin AST, enabling precise detection and correction of
formatting violations including indentation, spacing, import ordering, and naming conventions.

ktlint integrates with all major build systems through official and community plugins, most
notably [Gradle](gradle.md) via the ktlint-gradle plugin, and can run as a standalone CLI, a pre-commit
hook, or within CI pipelines. It is commonly used alongside [Detekt](detekt.md), which provides broader
static analysis covering code complexity, potential bugs, and design smells, while ktlint handles purely stylistic
concerns. Since its 1.0 release, ktlint has stabilized its rule API and adopted a more modular architecture, making it a
standard component of Kotlin project toolchains in both server-side and Android development.

## Further Information

- [pinterest.github.io/ktlint](https://pinterest.github.io/ktlint/)
- [GitHub](https://github.com/pinterest/ktlint)
- [Wikipedia](https://en.wikipedia.org/wiki/Ktlint)
