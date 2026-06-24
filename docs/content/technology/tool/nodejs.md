---
title: "Node.js"
aliases:
- "/tool/nodejs"
bookToC: false
techsheet:
  key: "nodejs"
  type: "tool"
  category: "Runtime"
  related:
  - type: "language"
    key: "javascript"
    comment: "primary language of the runtime"
  - type: "language"
    key: "typescript"
    comment: "widely used via transpilation or native support"
  - type: "tool"
    key: "npm"
    comment: "bundled package manager"
  - type: "framework"
    key: "express"
    comment: "most popular Node.js web framework"
---

**A cross-platform [JavaScript](../language/javascript.md) runtime built on Chrome's V8 engine, designed for
building scalable network applications.**

Node.js executes [JavaScript](../language/javascript.md) outside the browser using an event-driven, non-blocking
I/O model centered on a single-threaded event loop. This architecture makes it particularly efficient for I/O-heavy
workloads such as HTTP servers, real-time communication, and streaming pipelines, where it can handle thousands of
concurrent connections with minimal resource overhead. The runtime ships with a standard library covering file system
access, networking, cryptography, and child process management, and exposes a native C++ addon API (N-API) for
performance-critical extensions.

The [NPM](npm.md) registry, bundled with every Node.js installation, is the largest software package
ecosystem in the world and forms the backbone of the broader JavaScript tooling landscape. Node.js is the dominant
runtime for server-side JavaScript and [TypeScript](../language/typescript.md) applications, powering frameworks
like [Express](../framework/express.md) and [Next.js](../framework/nextjs.md) as well as build toolchains
for frontend development. Recent versions have added support for ES modules alongside CommonJS, a stable permissions
model, a built-in test runner, and single-executable application distribution, reflecting a continued push toward a
self-contained development platform.

## Further Information

- [nodejs.org](https://nodejs.org/)
- [Node.js Documentation](https://nodejs.org/docs/latest/api/)
- [Wikipedia](https://en.wikipedia.org/wiki/Node.js)
