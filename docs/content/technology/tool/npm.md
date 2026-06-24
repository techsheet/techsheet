---
title: "NPM"
aliases:
- "/tool/npm"
bookToC: false
techsheet:
  key: "npm"
  type: "tool"
  category: "Build"
  related:
  - type: "tool"
    key: "nodejs"
    comment: "bundled runtime platform"
  - type: "tool"
    key: "yarn"
    comment: "alternative package manager for the same ecosystem"
  - type: "language"
    key: "javascript"
    comment: "primary language of the ecosystem"
  - type: "language"
    key: "typescript"
    comment: "major ecosystem language, packages distributed via npm"
---

**The default package manager for [Node.js](nodejs.md), providing dependency management, script execution,
and registry access for the [JavaScript](../language/javascript.md)
and [TypeScript](../language/typescript.md) ecosystem.**

npm (Node Package Manager) ships with every [Node.js](nodejs.md) installation and serves as both a
command-line tool and a client for the npm registry, the largest single-language package repository in existence with
over two million packages. It resolves and installs dependency trees from a `package.json` manifest, producing a
deterministic `package-lock.json` lockfile that pins exact versions for reproducible builds. The tool also functions as
a task runner through its `scripts` field, allowing projects to define build, test, and deployment commands without
additional tooling. Scoped packages, workspaces for monorepo management, and `npx` for one-off package execution round
out its core feature set.

The registry and CLI together form the backbone of modern web development, used by virtually
every [JavaScript](../language/javascript.md) and [TypeScript](../language/typescript.md) project for
dependency management. npm introduced semantic versioning conventions to the broader ecosystem and popularized the
small-module philosophy that characterizes Node.js development. Since GitHub's acquisition of npm, Inc. in 2020, the
registry has gained features such as provenance attestations, improved security auditing (`npm audit`), and package
signing. Alternative clients like [Yarn](yarn.md) and pnpm offer different performance and dependency
resolution strategies but consume the same registry and `package.json` format.

## Further Information

- [npmjs.com](https://www.npmjs.com/)
- [npm Documentation](https://docs.npmjs.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/Npm)
