---
title: "Haskell"
aliases:
- "/language/haskell"
bookToC: false
techsheet:
  key: "haskell"
  type: "language"
  related:
  - type: "language"
    key: "ocaml"
    comment: "ML family, similar type system"
  - type: "language"
    key: "scala"
    comment: "functional alternative on JVM, Haskell-inspired type features"
  - type: "language"
    key: "fsharp"
    comment: "ML-family functional language on .NET"
  - type: "language"
    key: "erlang"
    comment: "functional, concurrent, used in similar domains"
---

**A purely functional, statically typed programming language known for its expressive type system and emphasis on
correctness.**

Haskell is a general-purpose, lazy-evaluated programming language rooted in the tradition of the ML family and lambda
calculus. Its type system features type inference (Hindley-Milner), algebraic data types, pattern matching, type
classes,
higher-kinded types, and monadic I/O, providing strong guarantees about program behavior at compile time. Purity and
referential transparency are core design principles: all side effects are explicitly tracked through the type system,
making it possible to reason about code with mathematical precision. The Glasgow Haskell Compiler (GHC) serves as the
primary implementation and includes advanced features such as generalized algebraic data types (GADTs), type families,
and software transactional memory.

The language is used extensively in academia for programming language research and in industry for domains where
correctness is critical, including financial systems, compilers, and formal verification tools. Notable projects built
with Haskell include the Pandoc document converter, the XMonad window manager, and the Cardano blockchain platform.
Frameworks such as Servant and Yesod provide typed web development, while libraries like Conduit and Pipes address
streaming data processing. Haskell has profoundly influenced the design of other languages,
with [Scala](scala.md),
[F#](fsharp.md), and Rust all adopting concepts such as type classes, algebraic data types, and
monadic
error handling that originated in or were popularized by the Haskell ecosystem.

## Further Information

- [haskell.org](https://www.haskell.org/)
- [Haskell Wiki](https://wiki.haskell.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Haskell_(programming_language))
