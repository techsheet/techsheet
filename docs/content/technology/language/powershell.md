---
title: "PowerShell"
aliases:
- "/language/powershell"
bookToC: false
techsheet:
  key: "powershell"
  type: "language"
  related:
  - type: "language"
    key: "csharp"
    comment: "shared .NET runtime, deep type integration"
  - type: "language"
    key: "shell"
    comment: "Unix counterpart for scripting and automation"
  - type: "language"
    key: "batch"
    comment: "Windows predecessor"
  - type: "language"
    key: "python"
    comment: "alternative scripting and automation language"
---

**A cross-platform, task-based command-line shell and scripting language built on the .NET runtime.**

PowerShell is a dynamically typed shell and scripting language that operates on structured objects rather than plain
text
streams. Originally developed by Microsoft as a Windows-only system administration tool, it was redesigned as an
open-source, cross-platform project (PowerShell 7+) built on .NET. Its pipeline passes full .NET objects between
commands (called cmdlets), enabling direct access to properties and methods without text parsing. The language supports
classes, modules, advanced parameter binding, and a discoverable verb-noun naming convention for commands. Deep
integration with [C#](csharp.md) and the .NET ecosystem allows scripts to load and use any .NET
assembly directly.

PowerShell is the primary automation and configuration management tool for Windows Server, Active Directory, Azure, and
Microsoft 365 administration. It serves as the foundation for infrastructure-as-code through Desired State Configuration
(DSC) and integrates with configuration management systems like Ansible. The cross-platform rewrite (PowerShell Core,
later simply PowerShell 7) extended its reach to Linux and macOS, positioning it as an alternative to
[Shell](shell.md) scripting for heterogeneous environments. The PowerShell Gallery provides a public
module repository, and the language continues to evolve with improvements to error handling, pipeline parallelism, and
native command integration.

## Further Information

- [microsoft.com/powershell](https://microsoft.com/powershell)
- [PowerShell Documentation](https://learn.microsoft.com/en-us/powershell/)
- [Wikipedia](https://en.wikipedia.org/wiki/PowerShell)
