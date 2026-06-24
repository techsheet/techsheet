---
title: Claude
aliases:
  - /tool/claude
bookToC: false
techsheet:
  key: claude
  type: tool
  category: AI
  related:
    - type: tool
      key: github-copilot
      comment: "alternative AI coding assistant"
    - type: tool
      key: cursor
      comment: "alternative AI-powered IDE"
    - type: tool
      key: aider
      comment: "alternative CLI-based AI coding tool"
    - type: tool
      key: vscode
      comment: "primary IDE integration"
---

**An AI assistant and coding agent built by Anthropic, capable of extended autonomous software engineering tasks through
natural language interaction.**

Claude is a family of large language models developed by Anthropic, offered as both a conversational assistant and a
tool-integrated coding agent. The Claude Code CLI operates as a terminal-based agentic interface that can read and write
files, execute shell commands, search codebases, and interact with external services through the Model Context Protocol
(MCP). Its architecture emphasizes extended thinking for multi-step reasoning, tool use for grounded code generation,
and
configurable system prompts that allow project-specific customization through CLAUDE.md files.

Claude Code integrates with [Visual Studio Code](vscode.md) and JetBrains IDEs as an extension, and
supports headless execution for CI/CD pipelines and automated workflows. The underlying models (Haiku, Sonnet, Opus)
span a capability and cost spectrum, with Sonnet positioned as the primary coding model. Anthropic's focus on
Constitutional AI training and safety alignment distinguishes the model family from alternatives. Claude Code detects
in a project through the presence of configuration files such as CLAUDE.md, .claude/settings.json, or .mcp.json.

## Further Information

- [claude.ai](https://claude.ai/)
- [Claude Code Documentation](https://docs.anthropic.com/en/docs/claude-code)
- [Wikipedia](https://en.wikipedia.org/wiki/Claude_(language_model))
