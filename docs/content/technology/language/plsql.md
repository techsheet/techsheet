---
title: PL/SQL
aliases:
  - /language/plsql
bookToC: false
techsheet:
  key: plsql
  type: language
  related:
    - type: language
      key: sql
      comment: "base language, extended by PL/SQL"
    - type: language
      key: java
      comment: "alternative for Oracle stored procedures"
    - type: service
      key: postgres
      comment: "PL/pgSQL dialect inspired by PL/SQL"
---

**Oracle's procedural extension of [SQL](sql.md), designed for writing stored procedures, functions,
and triggers within Oracle Database.**

PL/SQL (Procedural Language/Structured Query Language) is a block-structured, statically typed programming language
tightly integrated with Oracle Database. It extends [SQL](sql.md) with procedural constructs such as
variables, conditions, loops, exception handling, and cursors, allowing developers to write complex data processing
logic that executes directly within the database engine. The language supports packages for modular code organization,
bulk operations for high-performance data manipulation, and native compilation to machine code for
compute-intensive workloads.

Oracle Database remains the primary and essentially exclusive runtime for PL/SQL, where it is used extensively for
business logic in enterprise applications, ETL processes, and database administration tasks. The language has influenced
other database procedural extensions, most notably [PostgreSQL](../service/postgres.md)'s PL/pgSQL. Oracle
continues to evolve PL/SQL alongside the database, with recent versions adding SQL macro support, extended iterators,
qualified expressions, and improved JSON handling capabilities.

## Further Information

- [Oracle PL/SQL Documentation](https://docs.oracle.com/en/database/oracle/oracle-database/23/lnpls/)
- [Wikipedia](https://en.wikipedia.org/wiki/PL/SQL)
- [Oracle Live SQL](https://livesql.oracle.com/)
