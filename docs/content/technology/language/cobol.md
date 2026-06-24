---
title: "COBOL"
aliases:
- "/language/cobol"
bookToC: false
techsheet:
  key: "cobol"
  type: "language"
  related:
  - type: "language"
    key: "sql"
    comment: "embedded SQL for database access"
  - type: "language"
    key: "abap"
    comment: "SAP enterprise language influenced by COBOL"
  - type: "language"
    key: "fortran"
    comment: "contemporary from the same era"
---

**A business-oriented programming language designed for processing large volumes of structured data in enterprise and
government systems.**

COBOL (Common Business-Oriented Language) is a compiled, procedural language with an English-like verbose syntax
organized into four divisions: Identification, Environment, Data, and Procedure. Its type system centers on fixed-point
decimal arithmetic with programmer-defined precision through PICTURE clauses, making it inherently suited for financial
calculations that require exact decimal representation without floating-point rounding. The Data Division separates data
layout from processing logic, with record structures that map directly to file and database schemas. COBOL supports
embedded [SQL](sql.md) for database access and COPY/REPLACE directives for source-level code reuse,
and has been standardized
by ANSI/ISO since 1968, with the most recent revision being COBOL 2023.

First specified in 1959 under the direction of the CODASYL committee (with significant contributions from Grace
Hopper's earlier work on FLOW-MATIC), COBOL remains one of the most widely deployed languages by volume of running
code. It underpins core transaction processing in banking, insurance, government agencies, and airline reservation
systems, primarily on IBM z/OS mainframes using CICS and IMS. Modern COBOL compilers from IBM, Micro Focus (now
Rocket Software), and GnuCOBOL support object-oriented extensions, Unicode, XML/JSON handling, and interoperability with
[Java](java.md) and web services, enabling incremental modernization of legacy systems without full
rewrites.

## Further Information

- [GnuCOBOL](https://gnucobol.sourceforge.io/)
- [IBM COBOL](https://www.ibm.com/products/cobol-compiler-zos)
- [Wikipedia](https://en.wikipedia.org/wiki/COBOL)
