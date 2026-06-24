---
title: SCSS/SASS
aliases:
  - /language/scss
bookToC: false
techsheet:
  key: scss
  type: language
  related:
    - type: language
      key: css
      comment: "base language it extends"
    - type: framework
      key: tailwind
      comment: "alternative CSS authoring approach"
    - type: tool
      key: nodejs
      comment: "runtime for Dart Sass compiler"
---

**A preprocessor scripting language that extends [CSS](css.md) with variables, nesting, mixins, and
functions, compiling down to standard stylesheets.**

Sass (Syntactically Awesome Style Sheets) provides two syntaxes: the indentation-based original syntax (`.sass`) and the
more widely adopted SCSS (Sassy CSS) syntax (`.scss`), which is a strict superset of [CSS](css.md). It
introduces programming constructs including variables, control flow (`@if`, `@for`, `@each`), mixins with arguments,
inheritance via `@extend`, and a module system with `@use` and `@forward` for namespace management. All Sass code
compiles to plain CSS, ensuring full compatibility with browsers without any runtime dependency.

Sass became the dominant CSS preprocessor in web development, adopted by major frameworks and design systems including
Bootstrap (versions 4 and 5). The canonical implementation transitioned from Ruby Sass (deprecated 2019) to Dart Sass,
which is distributed as a standalone executable and as an npm package running on [Node.js](../tool/nodejs.md). As
native CSS has gained features like custom properties, nesting, and `@layer`, some projects have migrated away from
Sass, though its module system, mixins, and compile-time logic remain capabilities without direct CSS equivalents.

## Further Information

- [sass-lang.com](https://sass-lang.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/Sass_(style_sheet_language))
