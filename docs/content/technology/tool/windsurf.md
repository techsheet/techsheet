---
title: Windsurf
aliases:
  - /tool/windsurf
bookToC: false
techsheet:
  key: windsurf
  type: tool
  category: AI
  related:
    - type: tool
      key: codeium
      comment: "predecessor product by the same company"
    - type: tool
      key: cursor
      comment: "direct alternative, AI-native IDE"
    - type: tool
      key: vscode
      comment: "forked from, shares extension ecosystem"
    - type: tool
      key: github-copilot
      comment: "alternative AI coding assistant"
---

**An AI-native code editor developed by Exacode (formerly Codeium), built as a fork
of [Visual Studio Code](vscode.md) with deep integration of autonomous coding agents and model-driven
workflows.**

Windsurf is a proprietary IDE that embeds AI capabilities at the editor level rather than offering them through a
separate plugin. Forked from the [VS Code](vscode.md) codebase, it retains compatibility with the
existing extension ecosystem, settings model, and terminal integration while adding native features for agentic
multi-file editing, inline code generation, and codebase-aware chat. Its central feature, branded "Cascade," is an
agentic system that can reason over an entire repository, plan changes across multiple files, execute terminal
commands, and incorporate tool outputs into its workflow. The editor supports multiple underlying model providers and
offers both cloud-hosted and bring-your-own-key configurations.

Windsurf launched in late 2024 as the successor to the [Codeium](codeium.md) autocomplete extension,
consolidating Exacode's product line into a single AI-native editor. It competes directly
with [Cursor](cursor.md)
in the emerging category of AI-first development environments, differentiating through its Cascade flows, which
combine real-time awareness of developer actions with proactive multi-step suggestions. The editor supports
context retrieval from documentation, indexed repositories, and attached files. Windsurf detects in a project through
the presence of its `.windsurf/` configuration directory or associated rules files.

## Further Information

- [windsurf.com](https://windsurf.com/)
- [Windsurf Documentation](https://docs.windsurf.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/Windsurf_(text_editor))
