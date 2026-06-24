---
title: "Prettier"
aliases:
- "/tool/prettier"
bookToC: false
techsheet:
  key: "prettier"
  type: "tool"
  category: "Format"
  related:
  - type: "tool"
    key: "eslint"
    comment: "complementary linter"
  - type: "tool"
    key: "editorconfig"
    comment: "complementary editor configuration"
  - type: "tool"
    key: "nodejs"
    comment: "runtime platform"
  - type: "language"
    key: "javascript"
    comment: "primary language formatted"
  - type: "language"
    key: "typescript"
    comment: "primary language formatted"
---

**An opinionated code formatter that enforces a consistent style by parsing and reprinting code.**

Prettier is a deterministic code formatter
for [JavaScript](../language/javascript.md), [TypeScript](../language/typescript.md), [CSS](../language/css.md), [HTML](../language/html.md), [Markdown](../language/markdown.md),
and several other languages. It works by parsing source code into an abstract syntax tree (AST) and reprinting it
according to its own formatting rules, eliminating all stylistic debates from a codebase. The tool deliberately limits
configuration options, enforcing a single canonical style that prioritizes readability and minimal diffs. This
opinionated approach distinguishes it from traditional linters like [ESLint](eslint.md), which detect
logical errors and allow extensive rule customization, while Prettier focuses exclusively on whitespace, line breaks,
and structural formatting.

Prettier runs on [Node.js](nodejs.md) and integrates with all major editors,
including [Visual Studio Code](vscode.md) and [IntelliJ IDEA](intellij-idea.md), as well as
CI pipelines via [GitHub Actions](github-actions.md) and other automation tools. It is commonly paired
with ESLint using shared configurations that disable ESLint's formatting rules to avoid conflicts. Since its initial
release in 2017, Prettier has become the de facto formatting standard in the JavaScript and TypeScript ecosystem, and
its plugin architecture has extended support to additional languages and file formats including GraphQL, YAML, and XML.

## Further Information

- [prettier.io](https://prettier.io/)
- [Prettier Playground](https://prettier.io/playground/)
- [Wikipedia](https://en.wikipedia.org/wiki/Prettier_(software))
