---
title: Slick
aliases:
  - /framework/slick
bookToC: false
techsheet:
  key: slick
  type: framework
  category: Data
  languages:
    - scala
  related:
    - type: language
      key: scala
      comment: "primary language"
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: framework
      key: play-framework
      comment: "commonly paired web framework"
    - type: framework
      key: jooq
      comment: "JVM alternative, type-safe SQL"
    - type: framework
      key: hibernate
      comment: "JVM alternative, ORM-based"
---

**A functional-relational mapping library for [Scala](../language/scala.md) that models database queries as
composable, type-safe Scala collections.**

Slick (Scala Language-Integrated Connection Kit) is a database access library that brings relational data into
the [Scala](../language/scala.md) type system by representing database tables and queries as ordinary Scala
values. Rather than mapping objects to rows in the style of traditional ORMs
like [Hibernate](hibernate.md), it treats queries as monadic operations that compose using `for`
-comprehensions, `map`, `filter`, and `flatMap`, the same abstractions Scala developers use for in-memory collections.
This approach allows the Scala compiler to verify query structure at compile time, catching type mismatches, missing
columns, and join errors before the code runs. The library generates efficient SQL for multiple database backends and
supports asynchronous, non-blocking execution through its `DBIO` action system built on Scala `Future`.

Slick is the standard database access layer in the [Scala](../language/scala.md) ecosystem and integrates closely
with the [Play Framework](play-framework.md) through the official play-slick module, forming a widely
used stack for reactive web applications on the [JVM](../tool/jvm.md). It supports PostgreSQL, MySQL, Oracle, SQL
Server, H2, SQLite, and other JDBC-compatible databases through pluggable driver profiles. Originally developed at the
EPFL Scala lab and later maintained by Lightbend, Slick transitioned to community stewardship alongside other former
Lightbend projects. Slick 3.x introduced the reactive streams-based `DBIO` monad for fully asynchronous database
operations, while ongoing development focuses on Scala 3 compatibility.

## Further Information

- [scala-slick.org](https://scala-slick.org/)
- [Slick Documentation](https://scala-slick.org/docs/)
- [Wikipedia](https://en.wikipedia.org/wiki/Slick_(database_library))
