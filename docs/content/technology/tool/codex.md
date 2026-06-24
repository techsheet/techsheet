---
title: "OpenAI Codex"
aliases:
- "/tool/codex"
bookToC: false
techsheet:
  key: "codex"
  type: "tool"
  category: "AI"
  related:
  - type: "tool"
    key: "claude"
    comment: "alternative CLI-based AI coding agent"
  - type: "tool"
    key: "github-copilot"
    comment: "OpenAI-powered alternative, IDE-focused"
  - type: "tool"
    key: "cursor"
    comment: "alternative AI-powered IDE"
  - type: "tool"
    key: "aider"
    comment: "alternative open-source CLI coding agent"
---

**An open-source CLI coding agent by OpenAI that executes software engineering tasks autonomously in a sandboxed
environment.**

OpenAI Codex is a terminal-based AI coding agent that reads a codebase, proposes changes, and applies them through
natural language instructions. It operates by running each task inside a cloud-sandboxed environment with network access
disabled by default, ensuring that file modifications and command execution remain isolated until the user approves
the results. The agent leverages OpenAI's reasoning models (codex-1 and o3) for multi-step planning, code generation,
and iterative debugging, and exposes configuration through a `.codex` directory at the project root.

The tool integrates with [Git](git.md) workflows, producing diffs that can be reviewed and committed
directly. Codex supports both fully autonomous and interactive operating modes, with configurable approval policies for
file writes and shell commands. As a CLI-first tool, it complements rather than replaces IDE-based assistants such as
[GitHub Copilot](github-copilot.md), and competes directly with agents
like [Claude](claude.md)
Code and [Aider](aider.md) in the terminal-based AI coding space.

## Further Information

- [OpenAI Codex on GitHub](https://github.com/openai/codex)
- [OpenAI Codex Documentation](https://platform.openai.com/docs/guides/codex)
- [Wikipedia](https://en.wikipedia.org/wiki/OpenAI_Codex)
