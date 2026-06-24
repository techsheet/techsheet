---
title: "C++"
aliases:
- "/language/cpp"
bookToC: false
techsheet:
  key: "cpp"
  type: "language"
  related:
  - type: "language"
    key: "assembly"
    comment: "inline assembly and low-level companion"
  - type: "language"
    key: "cuda"
    comment: "C++ host language for GPU kernels"
  - type: "language"
    key: "csharp"
    comment: "higher-level alternative with similar syntax lineage"
---

**A general-purpose systems programming language that combines high-level abstractions with low-level hardware control
and zero-cost abstraction as a core design principle.**

C++ is a statically typed, compiled language that supports procedural, object-oriented, and generic programming
paradigms within a single type system. It provides deterministic object lifetime through RAII (Resource Acquisition Is
Initialization), manual memory management alongside smart pointers, and a template metaprogramming system that enables
compile-time computation and type-safe generic code. The language compiles directly to native machine code without a
runtime or garbage collector, giving programmers explicit control over memory layout, cache behavior, and
[assembly](assembly.md)-level optimization. Major compilers include GCC, Clang/LLVM, and MSVC, each
implementing the ISO C++
standard (most recently C++23).

C++ is the dominant language for game engines (Unreal Engine, Unity's native layer), operating system components
(Windows, Chrome, portions of Linux), database engines (MySQL, MongoDB, ClickHouse), compilers, and high-frequency
trading systems. It serves as the host language for [CUDA](cuda.md) GPU programming and is widely used
in embedded systems,
robotics (ROS), and scientific computing. Modern C++ (C++11 through C++23) has introduced move semantics, lambda
expressions, concepts, ranges, coroutines, modules, and `std::expected`, substantially reducing the need for manual
resource management and improving type safety while maintaining backward compatibility with decades of existing code.

## Further Information

- [isocpp.org](https://isocpp.org/)
- [cppreference.com](https://en.cppreference.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/C%2B%2B)
