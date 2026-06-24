---
title: "Nim"
aliases:
- "/language/nim"
bookToC: false
techsheet:
  key: "nim"
  type: "language"
  related:
  - type: "language"
    key: "python"
    comment: "syntax inspiration"
  - type: "language"
    key: "cpp"
    comment: "compilation target, same performance tier"
  - type: "language"
    key: "zig"
    comment: "modern systems-language alternative"
  - type: "language"
    key: "crystal"
    comment: "similar niche, high-level compiled language"
---

**A statically typed, compiled systems programming language that combines the performance of low-level languages with a
Python-inspired syntax.**

Nim compiles primarily through C, C++, or [JavaScript](javascript.md) backends, producing
dependency-free native binaries that achieve performance comparable to [C++](cpp.md). Its type system
features generics, algebraic data types, distinct types, and a powerful macro and template system that enables
compile-time metaprogramming. Nim uses indentation-based syntax influenced by [Python](python.md),
deterministic memory management via a choice of garbage collection strategies (including ORC, a cycle-collecting
reference counter suited to real-time and embedded applications), and uniform function call syntax that blurs the line
between methods and free functions.

The language is used for systems programming, game development, command-line tooling, and web backends. Nim's standard
library provides asynchronous I/O, a cross-platform OS interface, and HTTP primitives, while the Nimble package manager
hosts a growing ecosystem of community libraries. Since reaching 1.0 in 2019 and 2.0 in 2023, the language has
stabilized its ARC/ORC memory management model as the default, introduced strict funcs for side-effect tracking, and
improved incremental compilation, positioning itself as a practical alternative for developers seeking native
performance with high-level expressiveness.

## Further Information

- [nim-lang.org](https://nim-lang.org/)
- [Nim Forum](https://forum.nim-lang.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Nim_(programming_language))
