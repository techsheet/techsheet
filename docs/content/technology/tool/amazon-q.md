---
title: "Amazon Q"
aliases:
- "/tool/amazon-q"
bookToC: false
techsheet:
  key: "amazon-q"
  type: "tool"
  category: "AI"
  related:
  - type: "tool"
    key: "github-copilot"
    comment: "direct competitor, AI coding assistant"
  - type: "tool"
    key: "claude"
    comment: "direct competitor, AI coding assistant"
  - type: "tool"
    key: "cursor"
    comment: "AI-powered IDE alternative"
---

**An AI-powered software development assistant from Amazon Web Services that provides code generation, transformation,
and operational support across the development lifecycle.**

Amazon Q is a generative AI assistant built on AWS's Bedrock foundation model infrastructure. It operates in two primary
modes: Amazon Q Developer, which targets software engineers with inline code suggestions, chat-based code generation,
and autonomous code transformation agents, and Amazon Q Business, which connects to enterprise data sources for
knowledge retrieval. The Developer variant integrates with major IDEs
including [Visual Studio Code](vscode.md) and [IntelliJ IDEA](intellij-idea.md), and
supports a broad range of languages such
as [Python](../language/python.md), [Java](../language/java.md), [TypeScript](../language/typescript.md),
and [C#](../language/csharp.md). Its code transformation feature can automate large-scale migrations, such as
upgrading Java applications across major versions.

The tool is tightly integrated with the AWS ecosystem, offering features specific to AWS services including
infrastructure-as-code generation, security scanning, and operational troubleshooting within the AWS Management Console.
Amazon Q Developer Agent can plan and implement multi-file changes autonomously, while the security scanning component
identifies vulnerabilities and suggests remediation. Originally launched in 2023 as a successor to AWS CodeWhisperer,
Amazon Q consolidated several AWS AI capabilities under a single product and has since expanded to include CLI
integration and support for [Git](git.md)-based workflows.

## Further Information

- [aws.amazon.com/q](https://aws.amazon.com/q/)
- [docs.aws.amazon.com/amazonq](https://docs.aws.amazon.com/amazonq/)
- [Wikipedia](https://en.wikipedia.org/wiki/Amazon_Q)
