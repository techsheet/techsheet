---
title: "Batch"
aliases:
- "/language/batch"
bookToC: false
techsheet:
  key: "batch"
  type: "language"
  related:
  - type: "language"
    key: "powershell"
    comment: "modern Windows scripting successor"
  - type: "language"
    key: "shell"
    comment: "Unix counterpart for command-line scripting"
---

**A scripting language for the Windows command-line interpreter (cmd.exe) used to automate tasks through sequential
command execution.**

Batch (also called batch file scripting or CMD scripting) is an interpreted scripting language processed by the Windows
Command Processor (cmd.exe). Scripts are stored as `.bat` or `.cmd` files and consist of sequences of built-in commands,
external program invocations, and control flow constructs including `IF`, `FOR`, `GOTO`, and `CALL`. All variables are
environment strings manipulated through delayed or immediate expansion, with no formal type system, data structures, or
arithmetic beyond `SET /A` integer expressions. Error handling relies on the `ERRORLEVEL` variable and conditional
execution operators (`&&`, `||`), reflecting the language's origins in MS-DOS 1.0 (1981) and its incremental evolution
through Windows NT's enhanced command processor.

Batch scripts remain prevalent in Windows system administration, build pipelines, CI/CD job definitions, and legacy
enterprise automation where replacing them with [PowerShell](powershell.md) is not justified by scope.
They are commonly used for
environment setup (setting paths, launching services), scheduled tasks via Windows Task Scheduler, and installer
bootstrapping. While [PowerShell](powershell.md) has superseded Batch for complex automation with its
object pipeline and .NET
integration, cmd.exe and Batch scripts continue to ship with every Windows installation and remain the default shell
for many Windows build tools and CI runners.

## Further Information

- [Microsoft Command-Line Reference](https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/windows-commands)
- [Wikipedia](https://en.wikipedia.org/wiki/Batch_file)
