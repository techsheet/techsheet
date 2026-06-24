---
title: Express
aliases:
  - /framework/express
bookToC: false
techsheet:
  key: express
  type: framework
  category: Application
  languages:
    - javascript
    - typescript
  related:
    - type: tool
      key: nodejs
      comment: "runtime platform"
    - type: language
      key: javascript
      comment: "primary implementation language"
    - type: language
      key: typescript
      comment: "commonly used with type definitions"
    - type: framework
      key: nextjs
      comment: "Node.js full-stack framework, often replaces Express"
---

**A minimal and flexible web application framework for [Node.js](../tool/nodejs.md) that provides a robust set of
features for building web servers and APIs.**

Express is an unopinionated, middleware-based framework for [JavaScript](../language/javascript.md)
and [TypeScript](../language/typescript.md) applications running on [Node.js](../tool/nodejs.md). Its core
design revolves around a routing system and a composable middleware pipeline, where each request passes through a chain
of functions that can inspect, modify, or terminate the request-response cycle. This approach keeps the framework
lightweight while allowing developers to assemble exactly the functionality they need through third-party middleware
packages for concerns such as body parsing, session management, authentication, and CORS handling.

Express became the de facto standard for server-side [JavaScript](../language/javascript.md) development and
remains one of the most widely used Node.js frameworks. It serves as the foundation for numerous higher-level
frameworks, including [Next.js](nextjs.md), Sails.js, and NestJS, which build additional structure
and conventions on top of its routing and middleware primitives. Version 5, after a prolonged development period,
brought improvements to path matching, error handling with promise support, and the removal of deprecated APIs, aligning
the framework with modern asynchronous patterns in the Node.js ecosystem.

## Further Information

- [expressjs.com](https://expressjs.com/)
- [Express GitHub Repository](https://github.com/expressjs/express)
- [Wikipedia](https://en.wikipedia.org/wiki/Express.js)
