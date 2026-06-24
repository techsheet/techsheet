---
title: TypeScript
aliases:
  - /language/typescript
bookToC: false
techsheet:
  key: typescript
  type: language
  related:
    - type: language
      key: javascript
      comment: "base language, TypeScript is a superset"
    - type: tool
      key: nodejs
      comment: "primary server-side runtime"
    - type: framework
      key: angular
      comment: "TypeScript-first application framework"
    - type: tool
      key: npm
      comment: "primary package manager"
---

**A statically typed superset of [JavaScript](javascript.md) that compiles to plain JavaScript for use
in any environment.**

TypeScript is an open-source programming language developed by Microsoft that adds optional static typing, interfaces,
enums, generics, and other type-level constructs on top of [JavaScript](javascript.md). Its structural
type system supports union types,
intersection types, mapped types, conditional types, and template literal types, enabling precise modeling of complex
data shapes and API contracts. The compiler (`tsc`) performs type erasure, emitting standard JavaScript that runs on any
[JavaScript](javascript.md) engine or [Node.js](../tool/nodejs.md) runtime without requiring a
dedicated VM.

TypeScript has become the dominant language for large-scale frontend and full-stack web development, adopted by
frameworks such as [Angular](../framework/angular.md) (which requires it), [React](../framework/react.md),
[Vue.js](../framework/vue.md), and [Next.js](../framework/nextjs.md). On the server side, it is widely used
with [Node.js](../tool/nodejs.md) through frameworks like [Express](../framework/express.md) and NestJS.
TypeScript 5.x introduced decorators aligned with the TC39 proposal, `const` type parameters, and continued
improvements to inference and module resolution. The `--isolatedDeclarations` flag and advances in project references
reflect the language's focus on scaling to very large codebases.

## Further Information

- [typescriptlang.org](https://www.typescriptlang.org/)
- [TypeScript Handbook](https://www.typescriptlang.org/docs/handbook/)
- [Wikipedia](https://en.wikipedia.org/wiki/TypeScript)
