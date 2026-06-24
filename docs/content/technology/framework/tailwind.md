---
title: Tailwind CSS
aliases:
  - /framework/tailwind
bookToC: false
techsheet:
  key: tailwind
  type: framework
  category: UI
  languages:
    - css
  related:
    - type: language
      key: css
      comment: "target language"
    - type: language
      key: javascript
      comment: "configuration and plugin language"
    - type: tool
      key: nodejs
      comment: "build-time runtime"
    - type: framework
      key: react
      comment: "common companion framework"
---

**A utility-first CSS framework that provides low-level, composable class names for building custom user interfaces
directly in markup.**

Tailwind CSS takes a fundamentally different approach to styling compared to traditional
component-based [CSS](../language/css.md) frameworks. Instead of providing pre-designed UI components, it exposes
a comprehensive set of single-purpose utility classes that map directly to CSS properties. The framework relies on a
build-time compiler, running on [Node.js](../tool/nodejs.md), that scans source files for class usage and
generates an optimized stylesheet containing only the classes actually referenced. This design eliminates dead CSS by
default and enforces a constrained design system through a centrally configured theme that governs spacing scales, color
palettes, typography, and breakpoints.

The framework is widely adopted in modern frontend development, particularly alongside component-based libraries such
as [React](react.md), [Vue.js](vue.md),
and [Svelte](svelte.md), where utility classes are co-located with component markup. Tailwind CSS v3
introduced a just-in-time engine as the default compilation mode, arbitrary value support, and native container queries.
Version 4, released in 2025, replaced the [JavaScript](../language/javascript.md)-based configuration file with a
CSS-first configuration model, adopted a Rust-based engine (Oxide) for significantly faster builds, and introduced
automatic content detection, removing the need to manually specify source paths.

## Further Information

- [tailwindcss.com](https://tailwindcss.com/)
- [Tailwind CSS Documentation](https://tailwindcss.com/docs)
- [Wikipedia](https://en.wikipedia.org/wiki/Tailwind_CSS)
