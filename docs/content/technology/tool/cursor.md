---
title: Cursor
aliases:
  - /tool/cursor
bookToC: false
techsheet:
  key: cursor
  type: tool
  category: AI
  related:
    - type: tool
      key: vscode
      comment: "forked from, shares extension ecosystem"
    - type: tool
      key: windsurf
      comment: "direct alternative, AI-native IDE"
    - type: tool
      key: github-copilot
      comment: "alternative AI coding assistant"
    - type: tool
      key: claude
      comment: "available as integrated AI model"
---

**An AI-native code editor built as a fork of [Visual Studio Code](vscode.md), designed to integrate large
language models directly into the editing and code generation workflow.**

Cursor is a proprietary code editor developed by Anysphere that embeds AI assistance at the core of the development
experience rather than layering it on as a plugin. Built on the [VS Code](vscode.md) codebase, it inherits
the full extension ecosystem, keybinding model, and workspace features of its upstream project while adding native
capabilities for inline code generation, multi-file editing through an agent mode, codebase-aware chat, and
context-driven autocomplete (branded "Tab"). The editor supports multiple underlying model providers, including OpenAI,
Anthropic ([Claude](claude.md)), and Google models, and allows users to switch between them or bring their
own API keys.

The editor gained rapid adoption among professional developers starting in 2023, positioning itself as the flagship of a
new category of AI-native development environments alongside [Windsurf](windsurf.md). Its differentiating
features include a "Composer" agent that can plan and apply changes across multiple files, automatic codebase indexing
for retrieval-augmented context, and the ability to reference documentation or images in prompts. Cursor detects in a
project through the presence of its `.cursor/` configuration directory or `.cursorrules` files.

## Further Information

- [cursor.com](https://www.cursor.com/)
- [Cursor Documentation](https://docs.cursor.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/Cursor_(text_editor))
