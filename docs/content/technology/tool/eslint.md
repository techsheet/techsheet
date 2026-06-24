---
title: "ESLint"
aliases:
- "/tool/eslint"
bookToC: false
techsheet:
  key: "eslint"
  type: "tool"
  category: "Format"
  related:
  - type: "language"
    key: "javascript"
    comment: "primary target language"
  - type: "language"
    key: "typescript"
    comment: "major supported language"
  - type: "tool"
    key: "nodejs"
    comment: "runtime platform"
  - type: "tool"
    key: "prettier"
    comment: "complementary formatter, often paired"
---

**A pluggable static analysis tool for identifying and fixing problems in [JavaScript](../language/javascript.md)
and [TypeScript](../language/typescript.md) code.**

ESLint is an open-source linting utility that analyzes source code to find problematic patterns, enforce coding
conventions, and catch potential bugs before runtime. It operates on an Abstract Syntax Tree (AST) produced by
parsers such as Espree (for JavaScript) or @typescript-eslint/parser (for TypeScript), and applies a configurable
set of rules that can be individually enabled, disabled, or customized. ESLint's architecture is fully pluggable:
rules, parsers, and processors can all be extended through plugins, allowing teams to encode project-specific
conventions alongside community-maintained rule sets.

ESLint runs on [Node.js](nodejs.md) and is the dominant linting solution in the JavaScript ecosystem,
used across frontend frameworks like React, Vue, and Angular as well as server-side Node.js applications. It is
frequently paired with [Prettier](prettier.md), which handles formatting while ESLint focuses on code
quality and correctness rules. The introduction of the flat configuration format (eslint.config.js) in version 9
replaced the legacy .eslintrc system, simplifying configuration merging and plugin resolution. ESLint also supports
linting JSON, Markdown, and CSS through its language plugin system introduced in the same release cycle.

## Further Information

- [eslint.org](https://eslint.org/)
- [GitHub](https://github.com/eslint/eslint)
- [Wikipedia](https://en.wikipedia.org/wiki/ESLint)
