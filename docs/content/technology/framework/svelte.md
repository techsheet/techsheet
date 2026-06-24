---
title: "Svelte"
aliases:
- "/framework/svelte"
bookToC: false
techsheet:
  key: "svelte"
  type: "framework"
  category: "Application"
  languages:
  - "javascript"
  - "typescript"
  related:
  - type: "framework"
    key: "react"
    comment: "direct alternative, component-based UI"
  - type: "framework"
    key: "vue"
    comment: "direct alternative, component-based UI"
  - type: "language"
    key: "typescript"
    comment: "primary language"
  - type: "tool"
    key: "nodejs"
    comment: "build and runtime platform"
---

**A component-based frontend framework that shifts work from the browser to a compile step, producing highly optimized
vanilla [JavaScript](../language/javascript.md).**

Svelte is a component framework for building web user interfaces, written
in [JavaScript](../language/javascript.md) or [TypeScript](../language/typescript.md). Unlike traditional
frameworks such as [React](react.md) and [Vue.js](vue.md), which ship a runtime
library to the browser and perform work through a virtual DOM, Svelte compiles components into efficient imperative code
at build time. This compiler-first approach eliminates the virtual DOM diffing overhead entirely, resulting in smaller
bundle sizes and faster runtime performance. Components are authored in `.svelte` files that combine HTML markup, scoped
CSS, and reactive script blocks in a single-file format, with reactivity driven by language-level assignments rather
than explicit API calls.

The framework gained significant traction after its 2019 rewrite (Svelte 3), which introduced a simplified reactivity
model based on top-level variable assignments. SvelteKit, the official application framework built on top of Svelte,
provides server-side rendering, file-based routing, and progressive enhancement, filling a role analogous
to [Next.js](nextjs.md) for the [React](react.md) ecosystem. Svelte 5 (released in
2024) introduced "runes," a signals-based reactivity system using explicit primitives like `$state` and `$derived`,
aligning the framework with the broader industry trend toward fine-grained reactivity while maintaining its
compilation-driven architecture.

## Further Information

- [svelte.dev](https://svelte.dev/)
- [Svelte Tutorial](https://learn.svelte.dev/)
- [Wikipedia](https://en.wikipedia.org/wiki/Svelte)
