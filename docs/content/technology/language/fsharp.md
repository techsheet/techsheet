---
title: "F#"
aliases:
- "/language/fsharp"
bookToC: false
techsheet:
  key: "fsharp"
  type: "language"
  related:
  - type: "language"
    key: "csharp"
    comment: ".NET sibling, full interop"
  - type: "language"
    key: "ocaml"
    comment: "ancestor language, syntactic basis"
  - type: "language"
    key: "haskell"
    comment: "functional programming peer"
  - type: "language"
    key: "scala"
    comment: "functional-first on managed runtime"
---

**A strongly typed, functional-first programming language for the .NET platform, designed for concise and correct code.
**

F# is a statically typed, multi-paradigm language rooted in the ML family, with [OCaml](ocaml.md) as
its most direct ancestor. It runs on the .NET Common Language Runtime and interoperates seamlessly
with [C#](csharp.md) and the broader .NET ecosystem. The language emphasizes immutability by default,
type inference, algebraic data types (discriminated unions), pattern matching, and computation expressions, a mechanism
that generalizes async workflows, sequence generation, and query expressions into a single syntactic framework. Its type
system catches entire categories of errors at compile time while requiring minimal annotation, resulting in code that is
both concise and robust.

In practice, F# is used in finance, data science, web development, and cloud services. The Fable compiler transpiles F#
to JavaScript, enabling full-stack development, while the SAFE Stack (Saturn, Azure, Fable, Elmish) provides an
end-to-end functional web framework. Bolero brings F# to WebAssembly through Blazor. The language is also
well-established in quantitative finance and risk modeling, where its combination of correctness guarantees and
expressive power is valued. F# 8 and 9, shipped with .NET 8 and 9 respectively, introduced extended pattern matching,
nested record updates, and improved interop with task-based asynchronous patterns.

## Further Information

- [fsharp.org](https://fsharp.org/)
- [Microsoft F# Documentation](https://learn.microsoft.com/en-us/dotnet/fsharp/)
- [Wikipedia](https://en.wikipedia.org/wiki/F_Sharp_(programming_language))
