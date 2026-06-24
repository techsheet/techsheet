---
title: "PostgreSQL"
aliases:
- "/service/postgres"
bookToC: false
techsheet:
  key: "postgres"
  type: "service"
  category: "Database"
  related:
  - type: "language"
    key: "sql"
    comment: "primary query language"
---

**An advanced open-source object-relational database system known for its reliability, feature richness, and standards compliance.**

PostgreSQL is a general-purpose relational database management system that extends [SQL](../language/sql.md) with
an object-relational model supporting custom types, table inheritance, and sophisticated indexing. Originally developed
at UC Berkeley as a successor to the Ingres project, it has been continuously developed by an open-source community
since 1996. The system provides full ACID compliance, multiversion concurrency control (MVCC), point-in-time recovery,
and a powerful query planner. Its extensibility is a defining characteristic: users can define custom data types,
operators, index methods, and procedural languages (PL/pgSQL, PL/Python, PL/Perl) without modifying the core.

The database is widely deployed across web applications, geospatial systems (via the PostGIS extension), data
warehousing, and financial services. It supports advanced features including JSON and JSONB columns for semi-structured
data, full-text search, logical and streaming replication, partitioning, and parallel query execution. Major cloud
providers offer managed PostgreSQL services (Amazon RDS, Google Cloud SQL, Azure Database for PostgreSQL), and
PostgreSQL-compatible systems such as Amazon Aurora and CockroachDB extend its ecosystem further. Recent versions have
introduced improvements to logical replication, query performance, and MERGE support following the SQL:2003 standard.

## Further Information

- [postgresql.org](https://www.postgresql.org/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Wikipedia](https://en.wikipedia.org/wiki/PostgreSQL)
