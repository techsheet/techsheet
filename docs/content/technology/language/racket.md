---
title: "Racket"
aliases:
- "/language/racket"
bookToC: false
techsheet:
  key: "racket"
  type: "language"
  related:
  - type: "language"
    key: "clojure"
    comment: "Lisp-family sibling"
  - type: "language"
    key: "haskell"
    comment: "functional programming peer"
  - type: "language"
    key: "ocaml"
    comment: "PLT research peer"
---

**A general-purpose, multi-paradigm programming language in the Lisp/Scheme family, designed for programming language
research and education.**

Racket descends from Scheme (R5RS) but has evolved into a distinct language with its own identity and standard library.
It features a powerful hygienic macro system that enables programmers to create new syntactic forms and embed
domain-specific languages within Racket itself. The language supports multiple paradigms including functional,
imperative, and object-oriented programming, with a gradual type system (Typed Racket) available as an optional language
extension. Racket's defining technical characteristic is its "language-oriented programming" approach, where the `#lang`
directive at the top of each file selects a language, allowing different modules in the same project to use entirely
different syntax and semantics.

The primary implementation, formerly known as PLT Scheme, includes DrRacket, an integrated development environment
widely used in computer science education. Racket is the language behind the "How to Design Programs" curriculum and has
been adopted by numerous universities for introductory programming courses. It also has a significant presence in
programming language theory research, where its macro system and module system serve as a testbed for new language
features. The Racket ecosystem includes a package manager, web server framework, and GUI toolkit. In 2023, the Racket
team released Rhombus, a new surface syntax built on top of Racket's macro infrastructure, offering a non-S-expression
alternative while retaining full macro extensibility.

## Further Information

- [racket-lang.org](https://racket-lang.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Racket_(programming_language))
- [docs.racket-lang.org](https://docs.racket-lang.org/)
