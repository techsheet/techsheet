---
title: VHDL
aliases:
  - /language/vhdl
bookToC: false
techsheet:
  key: vhdl
  type: language
  related:
    - type: language
      key: assembly
      comment: "hardware-level programming"
    - type: language
      key: cuda
      comment: "hardware-level parallel computing"
    - type: language
      key: tcl
      comment: "common scripting language in EDA toolchains"
---

**A hardware description language used to model, simulate, and synthesize digital electronic systems.**

VHDL (VHSIC Hardware Description Language) is a strongly typed, concurrent language originally developed under a U.S.
Department of Defense program in the 1980s and standardized as IEEE 1076. Unlike conventional programming languages,
VHDL describes hardware behavior and structure through signal assignments, processes, and component instantiation rather
than sequential instruction execution. Its type system enforces strict checking at elaboration time, supporting
enumerated types, records, arrays, physical types with units, and user-defined subtypes. Concurrent signal assignment
and process statements model the inherent parallelism of digital circuits, while generate statements allow parameterized
structural descriptions.

VHDL is used extensively in FPGA development, ASIC design, and digital systems verification across aerospace, defense,
telecommunications, and automotive industries. Major EDA toolchains including AMD Xilinx Vivado, Intel Quartus Prime,
and Siemens ModelSim/Questa provide full VHDL support, often using [Tcl](tcl.md) as their scripting
interface. The VHDL-2008 revision introduced enhanced generics, simplified sensitivity lists, and improved type system
features, while VHDL-2019 (IEEE 1076-2019) added interfaces, conditional analysis, and improved API interoperability.
VHDL remains the dominant HDL in European and defense-oriented design flows, complementing Verilog and SystemVerilog
which see wider adoption in commercial semiconductor design in North America and Asia.

## Further Information

- [IEEE 1076 VHDL Standard](https://standards.ieee.org/standard/1076-2019.html)
- [VHDL-Online](https://www.vhdl-online.de/)
- [Wikipedia](https://en.wikipedia.org/wiki/VHDL)
