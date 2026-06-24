---
title: AsciiDoc
aliases:
  - /language/asciidoc
bookToC: false
techsheet:
  key: asciidoc
  type: language
  related:
    - type: language
      key: markdown
      comment: "lightweight markup alternative"
    - type: language
      key: html
      comment: "common output target"
---

**A plain-text document format and publishing toolchain designed for writing technical documentation with semantic
richness beyond what lightweight markup languages typically offer.**

AsciiDoc is a human-readable markup language that maps directly to a semantic document model, supporting features such
as
conditional includes, cross-references, admonitions, footnotes, table-of-contents generation, and multi-file document
composition. Unlike [Markdown](markdown.md), which was designed for short-form web writing, AsciiDoc
targets long-form,
structured documents and provides a consistent syntax for complex elements like sidebars, source code callouts, and
bibliography sections without requiring embedded [HTML](html.md). The format uses a regular,
predictable syntax where
block-level structures are delimited explicitly, avoiding the ambiguity issues present in many Markdown dialects.

The reference implementation is Asciidoctor, a Ruby-based processor with ports to JavaScript (Asciidoctor.js) and the
JVM (AsciidoctorJ). AsciiDoc is widely used for software documentation (Spring Framework, Red Hat product docs), book
authoring (O'Reilly Atlas), and technical standards. Output formats include HTML, PDF (via Asciidoctor PDF), EPUB, and
DocBook. In 2020, an effort began under the Eclipse Foundation to formalize the AsciiDoc Language Specification,
establishing a vendor-neutral standard for parsers and tooling.

## Further Information

- [asciidoc.org](https://asciidoc.org/)
- [Asciidoctor](https://asciidoctor.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/AsciiDoc)
