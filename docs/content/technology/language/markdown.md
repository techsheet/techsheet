---
title: Markdown
aliases:
  - /language/markdown
bookToC: false
techsheet:
  key: markdown
  type: language
  related:
    - type: language
      key: html
      comment: "primary output target"
    - type: language
      key: asciidoc
      comment: "richer lightweight markup alternative"
    - type: language
      key: css
      comment: "styling for rendered output"
---

**A lightweight markup language for creating formatted text using a plain-text syntax designed to be readable without
rendering.**

Markdown uses a minimal set of punctuation characters to indicate structural and inline formatting elements such as
headings, emphasis, links, code blocks, lists, and images. The original syntax, created by John Gruber in 2004, was
intentionally underspecified, leading to divergent implementations. CommonMark, published in 2014, established a formal
specification with a comprehensive suite of edge-case rules, and most modern parsers (including GitHub Flavored
Markdown) build on this foundation. The language converts directly to [HTML](html.md), and its design
philosophy prioritizes source readability so that an unrendered Markdown file remains easy to read and write in any text
editor.

Markdown has become the de facto standard for documentation in software projects, powering README files on GitHub and
GitLab, static site generators (Jekyll, Hugo, MkDocs), knowledge bases (Obsidian, Notion), and developer platforms.
GitHub Flavored Markdown (GFM) extends CommonMark with tables, task lists, strikethrough, and autolinked references.
Other notable variants include MultiMarkdown, which adds citations and footnotes, and R Markdown, which integrates
executable code for reproducible research. For projects requiring more complex document structures such as
cross-references, conditional content, or multi-file composition, [AsciiDoc](asciidoc.md) serves as a
common alternative.

## Further Information

- [CommonMark Specification](https://commonmark.org/)
- [Daring Fireball: Markdown](https://daringfireball.net/projects/markdown/)
- [GitHub Flavored Markdown Spec](https://github.github.com/gfm/)
- [Wikipedia](https://en.wikipedia.org/wiki/Markdown)
