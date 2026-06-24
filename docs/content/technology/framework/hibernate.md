---
title: "Hibernate"
aliases:
- "/framework/hibernate"
bookToC: false
techsheet:
  key: "hibernate"
  type: "framework"
  category: "Data"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "framework"
    key: "spring-data"
    comment: "common integration layer"
  - type: "framework"
    key: "jakarta-ee"
    comment: "specification provider (JPA)"
  - type: "framework"
    key: "jooq"
    comment: "JVM alternative, SQL-centric"
  - type: "framework"
    key: "mybatis"
    comment: "JVM alternative, SQL mapping"
---

**An object-relational mapping (ORM) framework for [Java](../language/java.md)
and [Kotlin](../language/kotlin.md) that maps domain objects to relational database tables.**

Hibernate is the most widely adopted ORM implementation on the [JVM](../tool/jvm.md) and serves as the reference
implementation
of the Jakarta Persistence API (JPA), formerly the Java Persistence API. It provides transparent persistence through
mapping annotations or XML descriptors, a powerful query language (HQL/JPQL), criteria queries, and automatic schema
generation. Its architecture centers on the `SessionFactory` and `Session` abstractions, which manage entity lifecycle,
dirty checking, lazy loading, and first- and second-level caching to minimize database round-trips.

Most [Java](../language/java.md) enterprise applications use Hibernate either directly or
through [Spring Data](spring-data.md) JPA,
[Jakarta EE](jakarta-ee.md) containers, [Quarkus](quarkus.md),
or [Micronaut](micronaut.md). Hibernate Reactive extends the
framework with non-blocking database access based on Vert.x, while Hibernate Search integrates full-text search via
Apache Lucene or Elasticsearch. Hibernate 6 introduced a rewritten query parser, improved type safety, and alignment
with Jakarta Persistence 3.1, completing the transition from the `javax.persistence` to the `jakarta.persistence`
namespace.

## Further Information

- [hibernate.org](https://hibernate.org/)
- [Hibernate ORM Documentation](https://hibernate.org/orm/documentation/)
- [Wikipedia](https://en.wikipedia.org/wiki/Hibernate_(framework))
