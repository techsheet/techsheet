---
title: Zig
aliases:
  - /language/zig
bookToC: false
techsheet:
  key: zig
  type: language
  related:
    - type: language
      key: cpp
      comment: "systems programming alternative with C ABI interop"
    - type: language
      key: nim
      comment: "modern compiled systems language"
    - type: language
      key: assembly
      comment: "low-level target; Zig supports inline assembly"
---

**A general-purpose, statically typed systems programming language focused on explicit behavior, comptime evaluation,
and direct interoperability with C and [C++](cpp.md) code.**

Zig is a compiled language designed as a practical alternative to C and [C++](cpp.md) for
systems-level programming. It features a strong static type system with no hidden control flow, no hidden allocators,
and no implicit behavior. One of its most distinctive features is comptime, a compile-time code execution mechanism that
replaces both generics and macros with ordinary Zig code evaluated at compile time. The language provides manual memory
management with optional safety checks, error unions as a first-class error handling mechanism, and guaranteed
interoperability with any C ABI-compatible code without requiring bindings or FFI wrappers. Zig ships with its own
optimizing compiler backend and can also emit code through LLVM, enabling cross-compilation to over 30 target
architectures from a single toolchain.

The language has gained significant traction in game development, embedded systems, and infrastructure tooling. Notably,
the Bun JavaScript runtime is written in Zig, demonstrating its viability for large-scale, performance-critical
software. The Zig build system, written in Zig itself, replaces traditional build tools like Make and CMake, providing a
unified approach to compilation, linking, and dependency management. As of Zig 0.13+, the language continues to evolve
toward a 1.0 release, with an active community and growing adoption in projects where predictable performance and
minimal runtime overhead are essential.

## Further Information

- [ziglang.org](https://ziglang.org/)
- [Zig Language Reference](https://ziglang.org/documentation/master/)
- [Wikipedia](https://en.wikipedia.org/wiki/Zig_(programming_language))
