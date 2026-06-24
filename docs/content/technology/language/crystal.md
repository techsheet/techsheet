---
title: Crystal
aliases:
  - /language/crystal
bookToC: false
techsheet:
  key: crystal
  type: language
  related:
    - type: language
      key: nim
      comment: "modern compiled language with similar goals"
    - type: language
      key: elixir
      comment: "concurrent, developer-friendly alternative"
---

**A statically typed, compiled programming language with Ruby-inspired syntax that targets native code through LLVM for
high performance with developer-friendly ergonomics.**

Crystal is a statically typed language that uses global type inference to eliminate the need for explicit type
annotations in most code, producing programs that read like a dynamic language but compile to efficient native binaries.
It compiles via LLVM and uses a Boehm garbage collector for automatic memory management. The language features union
types, macros evaluated at compile time, C bindings through a `lib` declaration syntax, and green threads (fibers) with
channel-based communication for lightweight concurrency. Null safety is enforced at the type level, with `nil` tracked
as a distinct type in unions, preventing null reference errors at compile time rather than runtime.

Crystal is used for web backends, CLI tools, and network services where Ruby-like expressiveness is desired with
compiled-language performance. The primary web framework is Lucky (now renamed to Carbon), alongside Kemal for
lightweight HTTP services and Amber as a Rails-style framework. The language's standard library provides built-in HTTP
server and client, JSON/YAML serialization, and WebSocket support. Crystal reached version 1.0 in 2021, stabilizing its
language specification, and subsequent releases have improved Windows support, interpreter mode for faster development
feedback, and incremental compilation.

## Further Information

- [crystal-lang.org](https://crystal-lang.org/)
- [Crystal on GitHub](https://github.com/crystal-lang/crystal)
- [Wikipedia](https://en.wikipedia.org/wiki/Crystal_(programming_language))
