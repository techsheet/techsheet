---
title: GitHub Copilot
aliases:
  - /tool/github-copilot
bookToC: false
techsheet:
  key: github-copilot
  type: tool
  category: AI
  related:
    - type: tool
      key: vscode
      comment: "primary IDE integration"
    - type: tool
      key: claude
      comment: "direct alternative, AI coding assistant"
    - type: tool
      key: cursor
      comment: "direct alternative, AI-native IDE"
    - type: tool
      key: github-actions
      comment: "same platform, GitHub ecosystem"
---

**An AI-powered code completion and generation tool developed by GitHub, integrated directly into code editors.**

GitHub Copilot uses large language models trained on publicly available code to provide real-time code suggestions,
whole-function generation, and natural-language-to-code translation within a developer's editing environment. It
operates as an editor extension, primarily for [Visual Studio Code](vscode.md), JetBrains IDEs, and
Neovim, offering inline completions that adapt to the surrounding code context, file structure, and open tabs. The
system supports chat-based interaction for code explanation, refactoring, and debugging alongside its autocomplete
capabilities.

Originally launched in 2021 as a technical preview powered by OpenAI Codex, the tool has evolved into a broader
platform encompassing Copilot Chat, Copilot for CLI, and Copilot Workspace for task-driven development. It supports
most mainstream programming languages, with particularly strong results in [Python](../language/python.md),
[JavaScript](../language/javascript.md), [TypeScript](../language/typescript.md), and
Go. GitHub has integrated Copilot into the github.com pull request workflow for automated
code review and summary generation, positioning it as a central component of the GitHub development platform.

## Further Information

- [github.com/features/copilot](https://github.com/features/copilot)
- [GitHub Copilot Documentation](https://docs.github.com/en/copilot)
- [Wikipedia](https://en.wikipedia.org/wiki/GitHub_Copilot)
