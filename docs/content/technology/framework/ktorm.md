---
title: "Ktorm"
aliases:
- "/framework/ktorm"
bookToC: false
techsheet:
  key: "ktorm"
  type: "framework"
  category: "Data"
  languages:
  - "kotlin"
  related:
  - type: "language"
    key: "kotlin"
    comment: "primary language"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "framework"
    key: "exposed"
    comment: "Kotlin-specific ORM alternative"
  - type: "framework"
    key: "hibernate"
    comment: "JVM ORM alternative"
---

**A lightweight ORM framework for [Kotlin](../language/kotlin.md) that provides a strongly typed, pure-Kotlin DSL
for SQL database access on the [JVM](../tool/jvm.md).**

Ktorm is an open-source object-relational mapping framework designed specifically
for [Kotlin](../language/kotlin.md), emphasizing minimal
configuration and idiomatic language integration. It uses Kotlin's operator overloading and infix functions to construct
a SQL DSL where table schemas, column references, and query expressions are all represented as typed Kotlin objects,
catching schema and type errors at compile time. Unlike annotation-driven ORM frameworks, Ktorm requires no code
generation, no XML configuration, and no reflection at runtime. Entity objects are defined through interface delegation
rather than concrete class inheritance, and the framework manages change tracking and dirty-field detection
transparently through Kotlin's property delegation mechanism.

The framework supports MySQL, PostgreSQL, SQLite, SQL Server, and Oracle through pluggable dialect modules. Ktorm
provides built-in support for pagination, aggregation, union queries, and entity sequence APIs that integrate with
Kotlin's standard collection operations, allowing developers to manipulate database records with the same idioms used
for in-memory collections. It is commonly used alongside application frameworks such
as [Spring Boot](spring-boot.md)
and [Ktor](ktor.md) in Kotlin server-side projects. Compared
to [Exposed](exposed.md),
Ktorm follows a more traditional entity-mapping approach while maintaining a similar commitment to type-safe SQL
construction without string-based queries.

## Further Information

- [ktorm.org](https://www.ktorm.org/)
- [Ktorm on GitHub](https://github.com/kotlin-orm/ktorm)
- [Wikipedia](https://en.wikipedia.org/wiki/Ktorm)
