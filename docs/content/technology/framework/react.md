---
title: React
aliases:
  - /framework/react
bookToC: false
techsheet:
  key: react
  type: framework
  category: Application
  languages:
    - javascript
    - typescript
  related:
    - type: language
      key: javascript
      comment: "primary implementation language"
    - type: language
      key: typescript
      comment: "predominant typed variant in React projects"
    - type: framework
      key: nextjs
      comment: "leading React meta-framework"
    - type: framework
      key: angular
      comment: "direct alternative, component-based SPA framework"
    - type: framework
      key: vue
      comment: "direct alternative, component-based SPA framework"
---

**A declarative, component-based [JavaScript](../language/javascript.md) library for building user interfaces.**

React is an open-source UI library created by Meta (formerly Facebook) that introduced a virtual DOM diffing algorithm
to
efficiently update the browser's document object model. Its core abstraction is the component, a reusable, composable
unit that accepts properties and manages its own state. The library's unidirectional data flow, declarative rendering
model, and JSX syntax extension for embedding markup in [JavaScript](../language/javascript.md) distinguished it
from earlier imperative
DOM manipulation approaches. With the introduction of Hooks in version 16.8, React shifted from class-based components
to a function-based programming model, enabling state and side-effect management without inheritance hierarchies.

The library is the foundation of a large ecosystem that includes routing (React Router), state management (Redux,
Zustand, Jotai), and full-stack meta-frameworks such as [Next.js](nextjs.md) and Remix. React Native
extends
the component model to iOS and Android native application development. React 18 introduced concurrent rendering,
automatic batching, and the Suspense mechanism for data fetching, while React Server Components enable server-side
rendering of individual components with zero client-side JavaScript overhead. Most production React codebases today
use [TypeScript](../language/typescript.md) for static type checking of component props and state.

## Further Information

- [react.dev](https://react.dev/)
- [React GitHub Repository](https://github.com/facebook/react)
- [Wikipedia](https://en.wikipedia.org/wiki/React_(JavaScript_library))
