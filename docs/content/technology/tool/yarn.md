---
title: Yarn
aliases:
  - /tool/yarn
bookToC: false
techsheet:
  key: yarn
  type: tool
  category: Build
  related:
    - type: tool
      key: npm
      comment: "direct alternative, same registry and manifest format"
    - type: tool
      key: nodejs
      comment: "underlying runtime platform"
    - type: language
      key: javascript
      comment: "primary language of the ecosystem"
    - type: language
      key: typescript
      comment: "major ecosystem language, packages distributed via Yarn"
---

**A fast, reliable package manager for [JavaScript](../language/javascript.md)
and [TypeScript](../language/typescript.md) that introduced deterministic dependency resolution and workspaces to
the [Node.js](nodejs.md) ecosystem.**

Yarn was created at Meta (then Facebook) in 2016 to address performance and consistency shortcomings
of [npm](npm.md) at scale. It consumes the same `package.json` manifest and npm registry as its
counterpart but introduced several foundational concepts to JavaScript dependency management: deterministic installs via
a lockfile (`yarn.lock`), offline caching of downloaded packages, and parallel fetching for significantly faster
installation times. Yarn 1 (Classic) established these patterns, while Yarn Berry (2+) rearchitected the tool around
Plug'n'Play (PnP), an installation strategy that eliminates the `node_modules` directory entirely by mapping imports
directly to compressed package archives stored in a `.yarn/cache` directory, reducing disk usage and improving startup
performance.

The workspaces feature, which Yarn pioneered, enables monorepo management by allowing multiple packages to coexist in a
single repository with shared dependencies hoisted to a common root. This capability has been widely adopted across
the [Node.js](nodejs.md) ecosystem and influenced competing tools including [npm](npm.md)
workspaces and pnpm. Yarn Berry supports extensibility through a plugin architecture, offers built-in `patch:` and
`portal:` protocols for dependency overrides, and enforces strict dependency declarations that prevent phantom
dependency access. The tool integrates with zero-install workflows where the dependency cache is committed to version
control, enabling CI environments to skip the install step entirely.

## Further Information

- [yarnpkg.com](https://yarnpkg.com/)
- [Yarn GitHub Repository](https://github.com/yarnpkg/berry)
- [Wikipedia](https://en.wikipedia.org/wiki/Yarn_(package_manager))
