---
title: Assembly
aliases:
  - /language/assembly
bookToC: false
techsheet:
  key: assembly
  type: language
  related:
    - type: language
      key: cpp
      comment: "inline assembly and primary high-level companion"
    - type: language
      key: cuda
      comment: "GPU programming with assembly-level control"
    - type: language
      key: vhdl
      comment: "hardware description at a similar abstraction level"
---

**A low-level programming language that provides a symbolic representation of a processor's machine code instruction
set.**

Assembly language maps nearly one-to-one to the native instructions of a specific CPU architecture, giving programmers
direct control over registers, memory addresses, stack manipulation, and hardware interrupts. There is no single
assembly language; each processor family (x86, ARM, RISC-V, MIPS, z/Architecture) defines its own instruction set and
corresponding mnemonic syntax. An assembler translates these mnemonics into executable machine code, with common
assemblers including NASM, MASM, GAS (GNU Assembler), and LLVM's integrated assembler. The language has no type system,
garbage collection, or runtime abstractions; the programmer manages all resources explicitly.

Assembly is used in operating system kernels, bootloaders, firmware, device drivers, real-time embedded systems, and
performance-critical inner loops where [C++](cpp.md) or C compiler output must be hand-tuned. Inline
assembly remains
supported in major C/C++ compilers (GCC, Clang, MSVC) for architecture-specific optimization. The rise of RISC-V as an
open instruction set architecture has renewed interest in assembly-level programming for hardware bring-up and
verification, while WebAssembly (Wasm) has introduced a portable, stack-based assembly-like target for browser and
server-side execution.

## Further Information

- [NASM](https://www.nasm.us/)
- [Wikipedia](https://en.wikipedia.org/wiki/Assembly_language)
