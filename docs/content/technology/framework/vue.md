---
title: "Vue.js"
aliases:
- "/framework/vue"
bookToC: false
techsheet:
  key: "vue"
  type: "framework"
  category: "Application"
  languages:
  - "javascript"
  - "typescript"
  related:
  - type: "language"
    key: "javascript"
    comment: "primary implementation language"
  - type: "language"
    key: "typescript"
    comment: "widely used typed variant in Vue projects"
  - type: "framework"
    key: "react"
    comment: "direct alternative, component-based SPA library"
  - type: "framework"
    key: "angular"
    comment: "direct alternative, full-featured SPA framework"
  - type: "framework"
    key: "svelte"
    comment: "direct alternative, compiler-based UI framework"
---

**A progressive, component-based [JavaScript](../language/javascript.md) framework for building user interfaces
and single-page applications.**

Vue.js is an open-source front-end framework created by Evan You that emphasizes an incrementally adoptable
architecture,
allowing developers to use as little or as much of the framework as a project requires. Its reactivity system
automatically tracks dependencies at the component level and precisely updates only the DOM elements that need to change
when state is modified. Vue's Single-File Component (SFC) format colocates template, logic, and styles in a single
`.vue` file, enforcing a clear separation of concerns within each component while keeping related code together. The
framework supports both an Options API, which organizes component logic by option type (data, methods, computed,
lifecycle hooks), and a Composition API, which enables logic reuse and organization by feature through composable
functions.

The framework powers a mature ecosystem that includes an official router (Vue Router), state management library (Pinia,
successor to Vuex), and build tooling (Vite, originally created to serve the Vue development workflow). Nuxt is the
leading Vue meta-framework for server-side rendering, static site generation, and full-stack development. Vue 3
introduced a rewritten virtual DOM, the Composition API, Teleport for portal rendering, Suspense for async components,
and first-class [TypeScript](../language/typescript.md) support with improved type inference throughout the
framework. The template compiler performs static analysis to hoist constant nodes and generate optimized render
functions, resulting in competitive runtime performance among virtual-DOM-based frameworks.

## Further Information

- [vuejs.org](https://vuejs.org/)
- [Vue.js GitHub Repository](https://github.com/vuejs/core)
- [Wikipedia](https://en.wikipedia.org/wiki/Vue.js)
