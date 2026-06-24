---
title: Next.js
aliases:
  - /framework/nextjs
bookToC: false
techsheet:
  key: nextjs
  type: framework
  category: Application
  languages:
    - javascript
    - typescript
  related:
    - type: framework
      key: react
      comment: "underlying UI library"
    - type: tool
      key: nodejs
      comment: "runtime platform"
    - type: language
      key: typescript
      comment: "primary development language"
    - type: framework
      key: express
      comment: "alternative Node.js server framework"
---

**A full-stack [React](react.md) framework for building server-rendered and statically generated web
applications on [Node.js](../tool/nodejs.md).**

Next.js is an opinionated application framework built on top of [React](react.md) that provides
file-system-based routing,
server-side rendering (SSR), static site generation (SSG), and incremental static regeneration (ISR) out of the box. It
uses a hybrid rendering model that allows developers to choose the rendering strategy per page or per component,
enabling
fine-grained control over performance and data freshness. The framework handles code splitting, image optimization,
font loading, and script management automatically, reducing the configuration burden typically associated with
production
React deployments.

Next.js is developed and maintained by Vercel and has become one of the dominant frameworks for building modern web
applications in [TypeScript](../language/typescript.md) and [JavaScript](../language/javascript.md). The App
Router, introduced in version 13, shifted the framework toward React
Server Components, enabling server-first rendering with streaming and nested layouts. Version 14 and 15 continued this
trajectory with Server Actions for form handling and mutations, Partial Prerendering that combines static and dynamic
content in a single response, and Turbopack as a successor to Webpack for faster development builds.

## Further Information

- [nextjs.org](https://nextjs.org/)
- [Next.js Documentation](https://nextjs.org/docs)
- [Wikipedia](https://en.wikipedia.org/wiki/Next.js)
