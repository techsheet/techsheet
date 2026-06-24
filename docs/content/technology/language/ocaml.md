---
title: "OCaml"
aliases:
- "/language/ocaml"
bookToC: false
techsheet:
  key: "ocaml"
  type: "language"
  related:
  - type: "language"
    key: "haskell"
    comment: "ML family, similar type system"
  - type: "language"
    key: "fsharp"
    comment: "direct descendant, syntactic basis"
  - type: "language"
    key: "scala"
    comment: "functional-first, ML-influenced type system"
  - type: "language"
    key: "erlang"
    comment: "functional, used in similar systems domains"
---

**A statically typed, functional programming language from the ML family, designed for safety, performance, and
expressiveness.**

OCaml (Objective Caml) is a general-purpose programming language that extends the Caml dialect of ML with an object
system, a module system with functors, and support for imperative programming. Its type system features Hindley-Milner
type inference, algebraic data types, pattern matching, parametric polymorphism, and generalized algebraic data types (
GADTs), enabling strong compile-time correctness guarantees with minimal type annotations. The language compiles to
efficient native code through its optimizing compiler, and also provides a bytecode compiler and an interactive toplevel
for rapid prototyping. Unlike purely functional languages such as [Haskell](haskell.md), OCaml permits
controlled use of mutable state and side effects, making it a pragmatic choice for systems where performance and
correctness must coexist.

The language has a strong presence in formal verification, compiler construction, and financial technology. Jane Street,
one of the largest quantitative trading firms, uses OCaml as its primary development language across millions of lines
of production code. Notable projects built with OCaml include the Coq proof assistant, the MirageOS unikernel, the Flow
type checker for JavaScript, and the original implementation of the Rust compiler. [F#](fsharp.md) was
designed as a direct descendant of OCaml for the .NET platform, inheriting much of its syntax and semantics. OCaml 5,
released in 2022, introduced multicore support through domains and effect handlers, marking a significant shift from the
single-threaded runtime that characterized earlier versions.

## Further Information

- [ocaml.org](https://ocaml.org/)
- [OCaml Manual](https://v2.ocaml.org/manual/)
- [Wikipedia](https://en.wikipedia.org/wiki/OCaml)
