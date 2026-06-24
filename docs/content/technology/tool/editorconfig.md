---
title: EditorConfig
aliases:
  - /tool/editorconfig
bookToC: false
techsheet:
  key: editorconfig
  type: tool
  category: Format
  related:
    - type: tool
      key: prettier
      comment: "complementary code formatter"
    - type: tool
      key: eslint
      comment: "complementary linter and formatter"
    - type: tool
      key: git
      comment: "config file typically version-controlled"
---

**A file format and collection of editor plugins for defining and maintaining consistent coding styles across editors
and IDEs.**

EditorConfig consists of a simple, INI-like file format (`.editorconfig`) and plugins for virtually every major text
editor and IDE. It standardizes fundamental formatting properties such as indentation style (tabs vs. spaces),
indentation
size, line ending characters, character encoding, and trailing whitespace handling. The configuration is hierarchical:
files in subdirectories can override settings from parent directories, and a `root = true` declaration stops upward
traversal. This design allows monorepos and polyglot projects to define per-directory or per-file-type formatting rules
in a single, editor-agnostic mechanism.

EditorConfig is supported natively by many editors including Visual Studio, IntelliJ-based IDEs, and GitHub's web
interface, while others such as Vim, Emacs, and Sublime Text require a plugin. It is commonly used alongside
language-specific formatters like [Prettier](prettier.md) or linters
like [ESLint](eslint.md),
where EditorConfig governs low-level whitespace conventions and the dedicated formatter handles language-specific style
rules. Many formatting tools read `.editorconfig` files directly, avoiding redundant configuration. The specification is
maintained as an open community project and has become a de facto standard for cross-editor style consistency.

## Further Information

- [editorconfig.org](https://editorconfig.org/)
- [EditorConfig specification](https://spec.editorconfig.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/EditorConfig)
