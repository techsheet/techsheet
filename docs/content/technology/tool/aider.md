---
title: Aider
aliases:
  - /tool/aider
bookToC: false
techsheet:
  key: aider
  type: tool
  category: AI
  related:
    - type: tool
      key: git
      comment: "auto-commits changes via git"
    - type: language
      key: python
      comment: "implementation language"
    - type: tool
      key: claude
      comment: "supported LLM backend"
    - type: tool
      key: codex
      comment: "terminal-based AI coding alternative"
---

**An open-source, terminal-based AI pair programming tool that edits code in existing repositories using large language
models.**

Aider is a command-line tool written in [Python](../language/python.md) that connects to large language models to
collaboratively edit code in local [Git](git.md) repositories. Its distinguishing mechanism is tight
integration with Git: every AI-generated change is automatically committed with a descriptive message, providing a clean
audit trail and easy rollback. Aider operates through a chat interface in the terminal, where developers add files to
the conversation context and describe desired changes in natural language. It supports a broad range of LLM backends,
including OpenAI GPT, Anthropic [Claude](claude.md), and open-weight models served locally, allowing users
to choose their preferred provider.

The tool implements multiple "edit formats" that control how the LLM produces code changes, including whole-file
rewrites, search-and-replace blocks, and unified diffs, with automatic selection based on the model's capabilities.
Aider includes a repository map feature that uses tree-sitter to build a structural overview of the codebase, enabling
the LLM to understand cross-file dependencies without requiring the entire repository in its context window. Since its
initial release in 2023, Aider has become one of the most widely adopted open-source AI coding assistants, regularly
benchmarked on the SWE-bench evaluation suite for automated software engineering.

## Further Information

- [aider.chat](https://aider.chat/)
- [GitHub](https://github.com/Aider-AI/aider)
- [Wikipedia](https://en.wikipedia.org/wiki/Aider_(software))
