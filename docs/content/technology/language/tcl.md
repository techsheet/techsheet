---
title: Tcl
aliases:
  - /language/tcl
bookToC: false
techsheet:
  key: tcl
  type: language
  related:
    - type: language
      key: perl
      comment: "fellow dynamic scripting language of the same era"
    - type: language
      key: python
      comment: "dynamic scripting alternative, influenced by Tcl"
    - type: language
      key: lua
      comment: "embeddable scripting alternative"
    - type: language
      key: shell
      comment: "similar automation and glue scripting role"
---

**A dynamic, interpreted scripting language designed for embeddability, rapid prototyping, and gluing together software
components.**

Tcl (Tool Command Language) is a dynamically typed language in which everything is a string. Commands are structured as
words separated by whitespace, and the language's core evaluation model is remarkably simple: the first word of each
statement is a command name, and the rest are arguments. This "everything is a string" philosophy, combined with
powerful introspection and metaprogramming facilities, makes Tcl exceptionally flexible for extending applications with
a scripting layer. Tcl ships with Tk, a cross-platform GUI toolkit that was one of the first to offer portable
graphical interfaces and remains in use through bindings in other languages, most
notably [Python](python.md)'s Tkinter.

The language found widespread adoption in electronic design automation (EDA), network testing, and embedded system
configuration, where its lightweight interpreter and ease of embedding into C applications proved valuable. Tcl is the
standard scripting interface for tools like Synopsys, Cadence, and Xilinx/Vivado in the semiconductor industry. Expect,
a Tcl extension for automating interactive programs, became a staple of system administration. Modern Tcl (8.6+)
introduced an object-oriented system (TclOO), coroutines, and improved I/O channel handling, while Tcl 9.0 brought
Unicode support improvements and API modernization.

## Further Information

- [tcl-lang.org](https://www.tcl-lang.org/)
- [Tcler's Wiki](https://wiki.tcl-lang.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Tcl)
