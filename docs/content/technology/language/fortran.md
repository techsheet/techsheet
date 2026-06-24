---
title: "Fortran"
aliases:
- "/language/fortran"
bookToC: false
techsheet:
  key: "fortran"
  type: "language"
  related:
  - type: "language"
    key: "cpp"
    comment: "HPC companion language"
  - type: "language"
    key: "julia"
    comment: "modern numerical computing alternative"
  - type: "language"
    key: "python"
    comment: "widely used scientific computing alternative"
  - type: "language"
    key: "cuda"
    comment: "GPU acceleration in HPC workloads"
---

**The first widely adopted high-level programming language, designed for efficient numerical computation and scientific
applications.**

Fortran (Formula Translation) was developed at IBM in the 1950s and introduced the concept of compiling human-readable
mathematical notation into machine code. It is a statically typed, compiled language with strong native support for
array operations, complex number arithmetic, and multi-dimensional data structures. The language emphasizes predictable
performance and straightforward mapping to hardware, which allows compilers to produce highly optimized code for
numerical workloads. Modern Fortran (2003 and later) supports object-oriented programming, modules, allocatable arrays,
coarrays for parallel computation, and interoperability with [C++](cpp.md) through standardized C
bindings.

Fortran remains the dominant language in high-performance computing (HPC), climate modeling, computational fluid
dynamics, quantum chemistry, and large-scale physics simulations. Major scientific libraries such as LAPACK, BLAS, and
many weather forecasting systems are written in Fortran. The Fortran 2018 standard expanded parallel programming
capabilities through coarrays and the `do concurrent` construct, while Fortran 2023 further refined generic programming
and enumeration types. Although [Python](python.md) and [Julia](julia.md) have
gained traction for newer scientific projects, Fortran's unmatched legacy codebase and compiler maturity ensure its
continued relevance in computationally intensive domains.

## Further Information

- [fortran-lang.org](https://fortran-lang.org/)
- [Fortran Wiki](https://fortranwiki.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Fortran)
