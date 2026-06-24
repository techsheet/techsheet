---
title: "Plandex"
aliases:
- "/tool/plandex"
bookToC: false
techsheet:
  key: "plandex"
  type: "tool"
  category: "AI"
  related:
  - type: "tool"
    key: "aider"
    comment: "terminal-based AI coding alternative"
  - type: "tool"
    key: "claude"
    comment: "supported LLM backend"
  - type: "tool"
    key: "codex"
    comment: "terminal-based AI coding alternative"
  - type: "tool"
    key: "git"
    comment: "version control for plan branches"
---

**An open-source, terminal-based AI coding engine designed to manage complex, multi-file software development tasks
through structured planning and LLM-driven execution.**

Plandex is a command-line AI coding tool that breaks large development tasks into discrete steps, executing them
sequentially using large language models while maintaining changes in a sandboxed environment. Its core mechanism is a
plan-based workflow: rather than applying edits directly to the working tree, it accumulates proposed changes in an
internal versioned sandbox that uses [Git](git.md)-style branching and change tracking. Users review the
full set of accumulated changes before applying them to their codebase, providing a controlled approval step that
distinguishes it from tools that commit changes immediately. Plandex supports multiple LLM backends, including
Anthropic [Claude](claude.md) and OpenAI models, and can stream results from long-running multi-step
plans.

The tool is built to handle tasks that span many files and require coordinated changes across a project, such as feature
implementation, large-scale refactoring, and codebase migrations. Plans persist across sessions and can be resumed,
branched, and rewound, giving developers a structured history of AI-generated changes. Plandex operates entirely in the
terminal and stores its state in a local server process, making it suitable for integration into existing command-line
workflows. Since its public release in 2024, it has gained adoption among developers seeking an alternative to
IDE-integrated AI assistants for managing complex, multi-step coding tasks from the terminal.

## Further Information

- [plandex.ai](https://plandex.ai/)
- [GitHub](https://github.com/plandex-ai/plandex)
- [Wikipedia](https://en.wikipedia.org/wiki/Plandex)
