---
title: "Continue"
aliases:
- "/tool/continue"
bookToC: false
techsheet:
  key: "continue"
  type: "tool"
  category: "AI"
  related:
  - type: "tool"
    key: "vscode"
    comment: "primary host IDE"
  - type: "tool"
    key: "intellij-idea"
    comment: "supported host IDE"
  - type: "tool"
    key: "github-copilot"
    comment: "direct competitor, proprietary alternative"
  - type: "tool"
    key: "cursor"
    comment: "alternative AI-powered editor"
---

**An open-source AI code assistant that integrates into existing IDEs to provide autocomplete, chat, and inline editing
powered by configurable language models.**

Continue is an AI-assisted development tool that operates as an extension
for [Visual Studio Code](vscode.md) and [IntelliJ IDEA](intellij-idea.md), rather than
shipping as a standalone editor. Its distinguishing characteristic is full configurability of the underlying language
model: developers can connect any commercial API (OpenAI, Anthropic, Google, Mistral, and others) or self-hosted model (
via Ollama, llama.cpp, or compatible inference servers). The extension provides tab autocomplete, multi-file
context-aware chat, inline code editing, and a context system that lets users attach files, directories, documentation,
or custom retrieval sources to prompts. Configuration is managed through a local JSON file, giving teams explicit
control over model selection, prompt templates, and context providers.

The project is developed by Continue Dev, Inc. and licensed under the Apache 2.0 license. It competes directly
with [GitHub Copilot](github-copilot.md) and proprietary alternatives
like [Cursor](cursor.md), positioning itself as the open-source and model-agnostic option in the AI coding
assistant space. Continue supports workspace-level configuration, which allows engineering teams to standardize model
choices and context providers across a project. The tool has gained adoption particularly among organizations that
require data sovereignty or prefer to use self-hosted models for compliance reasons.

## Further Information

- [continue.dev](https://www.continue.dev/)
- [Continue on GitHub](https://github.com/continuedev/continue)
- [Wikipedia](https://en.wikipedia.org/wiki/Continue_(software))
