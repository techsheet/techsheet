---
title: "SQL"
aliases:
- "/language/sql"
bookToC: false
techsheet:
  key: "sql"
  type: "language"
  related:
  - type: "language"
    key: "plsql"
    comment: "procedural extension"
  - type: "service"
    key: "postgres"
    comment: "major open-source SQL database"
  - type: "framework"
    key: "hibernate"
    comment: "ORM generating SQL from object mappings"
  - type: "framework"
    key: "jooq"
    comment: "typesafe SQL query builder"
---

**A domain-specific language for managing, querying, and manipulating data in relational database management systems.**

SQL (Structured Query Language) is a declarative language standardized by ISO/IEC 9075 for defining, querying, and
modifying structured data in relational databases. Its core operations are expressed through a small set of statements
(SELECT, INSERT, UPDATE, DELETE) combined with a rich algebra of joins, subqueries, set operations, and aggregate
functions. The language separates into sub-languages by purpose: DDL (Data Definition Language) for schema management,
DML (Data Manipulation Language) for row-level operations, and DCL (Data Control Language) for access permissions. SQL's
declarative nature means queries describe the desired result rather than the procedure to compute it, leaving execution
planning to the database engine's query optimizer.

Nearly every relational database implements a dialect of SQL, including [PostgreSQL](../service/postgres.md),
Oracle Database, MySQL, Microsoft SQL Server, and SQLite. Procedural extensions such
as [PL/SQL](plsql.md)
(Oracle) and PL/pgSQL (PostgreSQL) add control-flow constructs for stored procedures and triggers. The SQL standard has
evolved through multiple revisions, with SQL:2023 being the latest, adding features like property graph queries (
SQL/PGQ)
and enhanced JSON support. SQL remains the dominant interface for transactional workloads (OLTP), analytical processing
(OLAP), and data warehousing, and its influence extends into stream processing systems and dataframe libraries that
adopt
SQL-like syntax.

## Further Information

- [ISO SQL Standard](https://www.iso.org/standard/76583.html)
- [Wikipedia](https://en.wikipedia.org/wiki/SQL)
- [use-the-index-luke.com](https://use-the-index-luke.com/)
