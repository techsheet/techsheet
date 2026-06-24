---
title: "Elixir"
aliases:
- "/language/elixir"
bookToC: false
techsheet:
  key: "elixir"
  type: "language"
  related:
  - type: "language"
    key: "erlang"
    comment: "runs on the BEAM VM, full interop"
  - type: "language"
    key: "clojure"
    comment: "modern functional language on an established VM"
---

**A dynamic, functional programming language built on the Erlang VM, designed for scalable and fault-tolerant
distributed systems.**

Elixir is a dynamically typed, compiled language that runs on the BEAM virtual machine, the same runtime that
powers [Erlang](erlang.md). It provides full interoperability with Erlang modules while introducing a
more approachable syntax influenced by Ruby, along with productive tooling and metaprogramming through hygienic macros.
The language is built around lightweight processes, message passing, and supervision trees, inheriting the BEAM's proven
concurrency model that can manage millions of concurrent processes with soft real-time guarantees. Pattern matching,
protocols, and the pipe operator are central to its design, encouraging composable and readable data transformation
pipelines.

The Phoenix framework is the dominant web framework in the Elixir ecosystem, known for its real-time capabilities
through Phoenix Channels and LiveView, which enables server-rendered interactive UIs over WebSockets. Elixir is widely
adopted for real-time communication platforms, IoT systems (via the Nerves framework), and event-driven architectures.
The built-in Mix build tool and Hex package manager provide a cohesive development experience. Since its initial release
in 2012, the language has steadily matured, with recent versions adding set-theoretic types for gradual type checking
and improved developer tooling.

## Further Information

- [elixir-lang.org](https://elixir-lang.org/)
- [Elixir Forum](https://elixirforum.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/Elixir_(programming_language))
