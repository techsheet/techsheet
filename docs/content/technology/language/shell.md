---
title: "Shell"
aliases:
- "/language/shell"
bookToC: false
techsheet:
  key: "shell"
  type: "language"
  related:
  - type: "language"
    key: "powershell"
    comment: "Windows-native shell alternative"
  - type: "language"
    key: "python"
    comment: "common replacement for complex scripts"
  - type: "language"
    key: "perl"
    comment: "classic Unix scripting complement"
  - type: "language"
    key: "awk"
    comment: "text processing companion in pipelines"
---

**A family of command-line interpreters and scripting languages that serve as the primary interface for Unix and
Unix-like operating systems.**

Shell scripting refers to programs written for Unix shell interpreters, most commonly Bash (Bourne Again Shell), sh
(Bourne Shell), Zsh, and Dash. These languages are dynamically typed and interpreted, built around string manipulation,
process control, and file I/O as first-class operations. Shell scripts compose programs through pipes, redirections, and
subshells, following the Unix philosophy of combining small, single-purpose tools into larger workflows. Control flow,
variable expansion, and globbing are handled by the interpreter itself, while most actual computation is delegated to
external commands.

Shell scripts are ubiquitous in system administration, CI/CD pipelines, container entrypoints, build automation, and
infrastructure provisioning. Bash is the default interactive shell on most Linux distributions and macOS (prior to
Catalina), and POSIX sh remains the portable baseline for cross-platform scripts. The rise of containerized deployments
and infrastructure-as-code has reinforced shell scripting as a critical glue language, though complex automation tasks
increasingly migrate to [Python](python.md) or purpose-built tools. Zsh has gained adoption as the
default shell on macOS since Catalina and through community frameworks like Oh My Zsh.

## Further Information

- [GNU Bash Manual](https://www.gnu.org/software/bash/manual/)
- [POSIX Shell Command Language](https://pubs.opengroup.org/onlinepubs/9699919799/utilities/V3_chap02.html)
- [Wikipedia](https://en.wikipedia.org/wiki/Shell_script)
