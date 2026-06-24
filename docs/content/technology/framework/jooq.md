---
title: jOOQ
aliases:
  - /framework/jooq
bookToC: false
techsheet:
  key: jooq
  type: framework
  category: Data
  languages:
    - java
    - kotlin
  related:
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: language
      key: java
      comment: "primary language"
    - type: language
      key: kotlin
      comment: "supported language"
    - type: framework
      key: hibernate
      comment: "alternative ORM-based persistence"
    - type: framework
      key: mybatis
      comment: "alternative SQL-centric persistence"
---

**A type-safe SQL library for [Java](../language/java.md) and [Kotlin](../language/kotlin.md) that generates
code from database schemas and models SQL as a first-class internal DSL.**

jOOQ (Java Object Oriented Querying) takes a code-generation approach to database access,
producing [Java](../language/java.md) classes directly from an existing database schema. These generated classes
form the basis of a fluent, type-safe DSL that mirrors SQL syntax closely, allowing developers to construct queries that
are validated at compile time against the actual database structure. Unlike traditional ORM frameworks such
as [Hibernate](hibernate.md), jOOQ embraces SQL rather than abstracting it away, providing full
access to vendor-specific SQL features, window functions, common table expressions, and other advanced constructs that
ORMs typically cannot express.

jOOQ runs on the [JVM](../tool/jvm.md) and supports all major relational databases, including PostgreSQL, MySQL,
Oracle, SQL Server, and many others. It integrates with Spring Boot, supports both blocking and reactive execution
models, and offers commercial editions for proprietary databases alongside its open-source core (Apache 2.0 for
open-source databases). Since its initial release in 2009, jOOQ has become a widely adopted choice for projects where
SQL control and type safety are prioritized over object-relational mapping abstractions.

## Further Information

- [jooq.org](https://www.jooq.org/)
- [jOOQ Documentation](https://www.jooq.org/learn/)
- [Wikipedia](https://en.wikipedia.org/wiki/JOOQ)
