---
title: CSS
aliases:
  - /language/css
bookToC: false
techsheet:
  key: css
  type: language
  related:
    - type: language
      key: html
      comment: "markup language it styles"
    - type: language
      key: scss
      comment: "preprocessor superset"
    - type: framework
      key: tailwind
      comment: "utility-first CSS framework"
---

**A declarative style sheet language used to describe the presentation of documents written
in [HTML](html.md) and XML.**

CSS (Cascading Style Sheets) separates content from visual presentation by defining rules that map selectors to style
declarations. Its cascade and specificity model determines which styles apply when multiple rules target the same
element. The language supports inheritance, media queries for responsive design, custom properties (variables), and a
growing set of layout systems including Flexbox and Grid. CSS is parsed and applied by browser rendering engines and
does not require compilation, though preprocessors like [SCSS](scss.md) extend it with features such
as nesting, mixins, and functions.

Every web browser implements CSS as the standard mechanism for styling web content, making it one of the three
foundational technologies of the World Wide Web alongside [HTML](html.md) and JavaScript. Modern CSS (
Level 3 and beyond, organized as independent modules rather than a single specification) has introduced container
queries, cascade layers (`@layer`), the `:has()` pseudo-class, native nesting, and significant improvements to color
spaces and animation capabilities. Utility-first frameworks like [Tailwind CSS](../framework/tailwind.md) have
become widely adopted, while native language improvements continue to reduce the need for preprocessors.

## Further Information

- [w3.org/Style/CSS](https://www.w3.org/Style/CSS/)
- [MDN Web Docs: CSS](https://developer.mozilla.org/en-US/docs/Web/CSS)
- [Wikipedia](https://en.wikipedia.org/wiki/CSS)
