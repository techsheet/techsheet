---
title: "Clojure"
aliases:
- "/language/clojure"
bookToC: false
techsheet:
  key: "clojure"
  type: "language"
  related:
  - type: "tool"
    key: "jvm"
    comment: "primary runtime platform"
  - type: "language"
    key: "java"
    comment: "full JVM interoperability"
  - type: "language"
    key: "javascript"
    comment: "ClojureScript compilation target"
  - type: "language"
    key: "scala"
    comment: "functional JVM sibling"
---

**A dynamic, functional Lisp dialect hosted on the [JVM](../tool/jvm.md), designed around immutable data
structures and a pragmatic approach to concurrency.**

Clojure is a dynamically typed, compiled language that emphasizes immutability, persistent data structures, and
functions as the primary unit of abstraction. As a Lisp, it uses S-expressions and homoiconicity to support powerful
macro-driven metaprogramming, while departing from traditional Lisps by favoring vectors and hash maps over cons cells.
Its concurrency model provides software transactional memory (STM), atoms, agents, and core.async channels as built-in
primitives, allowing shared-state programs without manual locking. Clojure compiles to [JVM](../tool/jvm.md)
bytecode and has full
interoperability with [Java](java.md) libraries, while ClojureScript
targets [JavaScript](javascript.md) runtimes through Google Closure
Compiler integration.

Clojure is used in backend services, data processing, and financial systems where its immutable-by-default semantics and
REPL-driven development workflow are valued. Notable libraries and frameworks include Ring and Compojure for HTTP
services, Pedestal, Datomic (an immutable database by the same creator), and Babashka for scripting. The language has
maintained a stable core since its 1.0 release in 2009 under the stewardship of Rich Hickey and Cognitect (now part of
Nubank), with recent versions adding transducers, spec (a runtime contract system), and improved error reporting.

## Further Information

- [clojure.org](https://clojure.org/)
- [ClojureScript](https://clojurescript.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Clojure)
