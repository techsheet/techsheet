---
title: "Exposed"
aliases:
- "/framework/exposed"
bookToC: false
techsheet:
  key: "exposed"
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
    key: "hibernate"
    comment: "JVM ORM alternative"
  - type: "framework"
    key: "jooq"
    comment: "type-safe SQL alternative"
  - type: "framework"
    key: "ktorm"
    comment: "Kotlin-specific ORM alternative"
---

**A lightweight SQL library for [Kotlin](../language/kotlin.md) that provides both a type-safe DSL and a DAO layer
for relational database access on the [JVM](../tool/jvm.md).**

Exposed is an open-source SQL framework developed by JetBrains, offering two complementary approaches to database
interaction: a type-safe DSL that closely mirrors SQL syntax and a lightweight Data Access Object (DAO) layer that
provides an object-relational mapping. The DSL API translates Kotlin expressions directly into SQL statements, using
the compiler's type system to catch schema mismatches, incorrect column references, and type errors at compile time.
Table definitions are expressed as Kotlin objects, and queries compose through extension functions rather than string
concatenation, eliminating an entire class of SQL injection vulnerabilities by design.

The framework supports PostgreSQL, MySQL, MariaDB, SQLite, Oracle, SQL Server, and H2, with database-specific dialect
handling built into its SQL generation layer. Exposed integrates naturally
with [Kotlin coroutines](kotlinx-coroutines.md)
for asynchronous database access and is commonly paired with application frameworks such
as [Ktor](ktor.md)
and [Spring Boot](spring-boot.md). Originally an internal JetBrains tool, it became a standalone
open-source project and has seen broad adoption in the Kotlin server-side ecosystem as a lighter alternative to
[Hibernate](hibernate.md) for projects that prefer staying close to SQL while retaining full
type safety.

## Further Information

- [JetBrains/Exposed on GitHub](https://github.com/JetBrains/Exposed)
- [Exposed Documentation](https://jetbrains.github.io/Exposed/)
- [Wikipedia](https://en.wikipedia.org/wiki/Exposed_(Kotlin_framework))
