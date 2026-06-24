---
title: Kiro
aliases:
  - /tool/kiro
bookToC: false
techsheet:
  key: kiro
  type: tool
  category: AI
  related:
    - type: tool
      key: amazon-q
      comment: "sibling AWS AI tool, shares Bedrock backend"
    - type: tool
      key: cursor
      comment: "direct alternative, AI-native IDE"
    - type: tool
      key: windsurf
      comment: "direct alternative, AI-native IDE"
    - type: tool
      key: vscode
      comment: "built on Code OSS, shares extension ecosystem"
---

**A spec-driven AI IDE from Amazon Web Services that generates code from structured specifications rather than ad-hoc
prompts.**

Kiro is an AI-integrated development environment built on the Code OSS foundation (the open-source core
of [Visual Studio Code](vscode.md)), developed by AWS and released as a preview in mid-2025. Its
distinguishing design principle is "spec-driven development," in which the developer authors or refines a
natural-language specification that is decomposed into structured requirements, a design document, and discrete
implementation tasks before any code is generated. This approach contrasts with the prompt-and-complete model of tools
like [Cursor](cursor.md) and [Windsurf](windsurf.md), aiming to produce more predictable,
requirement-aligned output on complex multi-file changes. Kiro supports autonomous "steering" agents called hooks that
trigger automatically on file saves or other events to run tests, update documentation, or enforce project conventions
without manual prompting.

The IDE inherits the full [VS Code](vscode.md) extension ecosystem through its Open VSX compatibility and
supports both free and paid tiers, with the paid plan backed by Anthropic's Claude Sonnet model via AWS Bedrock. Kiro is
closely related to [Amazon Q Developer](amazon-q.md) but occupies a distinct product niche: where Amazon Q
focuses on inline code completion and AWS-integrated operational assistance, Kiro targets the full project lifecycle
from requirements gathering through implementation. The IDE detects in a project through the presence of its `.kiro/`
configuration directory, which contains spec files and steering hook definitions.

## Further Information

- [kiro.dev](https://kiro.dev/)
- [AWS announcement blog post](https://aws.amazon.com/blogs/aws/kiro-ai-ide/)
- [Wikipedia](https://en.wikipedia.org/wiki/Kiro_(software))
