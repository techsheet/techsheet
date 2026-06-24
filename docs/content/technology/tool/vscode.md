---
title: Visual Studio Code
aliases:
  - /tool/vscode
bookToC: false
techsheet:
  key: vscode
  type: tool
  category: IDE
  related:
    - type: tool
      key: intellij-idea
      comment: "alternative full-featured IDE"
    - type: tool
      key: editorconfig
      comment: "cross-editor configuration standard"
    - type: tool
      key: github-copilot
      comment: "AI pair-programming extension"
    - type: language
      key: typescript
      comment: "built with TypeScript, first-class support"
---

**A free, open-source code editor built on web technologies, extensible through a rich marketplace of extensions.**

Visual Studio Code (VS Code) is a source-code editor developed by Microsoft that runs on Electron, combining
a [Node.js](nodejs.md) backend with a Chromium-based frontend. It provides built-in support
for [TypeScript](../language/typescript.md), [JavaScript](../language/javascript.md),
and [Node.js](nodejs.md) debugging out of the box, while its Language Server Protocol (LSP) and Debug
Adapter Protocol (DAP) allow language-agnostic tooling integration. The editor features IntelliSense code completion, an
integrated terminal, [Git](git.md) version control support, and a workspace model that supports both
single-folder and multi-root configurations. Its extension API exposes nearly every aspect of the editor, from syntax
highlighting via TextMate grammars to custom webview panels and notebook renderers.

Since its 2015 release, VS Code has become the most widely adopted code editor across the software industry,
consistently leading developer surveys. The extension marketplace hosts tens of thousands of extensions covering
language support, debugging, linting, container tooling, and AI-assisted development through tools
like [GitHub Copilot](github-copilot.md). Remote development capabilities, including Dev Containers, SSH
remotes, and GitHub Codespaces, allow developers to work against environments running on remote machines or
inside [Docker](docker.md) containers. The editor is itself written
in [TypeScript](../language/typescript.md), and its open-source core (Code - OSS) has spawned derivatives such as
Cursor and Windsurf that build on the same foundation.

## Further Information

- [code.visualstudio.com](https://code.visualstudio.com/)
- [VS Code on GitHub](https://github.com/microsoft/vscode)
- [Wikipedia](https://en.wikipedia.org/wiki/Visual_Studio_Code)
