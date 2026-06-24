---
title: "Ebean"
aliases:
- "/framework/ebean"
bookToC: false
techsheet:
  key: "ebean"
  type: "framework"
  category: "Data"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "framework"
    key: "hibernate"
    comment: "direct alternative, JPA-based ORM"
  - type: "framework"
    key: "jooq"
    comment: "alternative, SQL-centric data access"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "language"
    key: "java"
    comment: "primary language"
---

**A lightweight ORM for [Java](../language/java.md) and [Kotlin](../language/kotlin.md) that emphasizes
simplicity, automatic query tuning, and sessionless persistence.**

Ebean is an open-source object-relational mapping framework that runs on the [JVM](../tool/jvm.md) and provides a
sessionless architecture, meaning there is no attached/detached entity state or explicit session management as found in
JPA-based ORMs like [Hibernate](hibernate.md). It uses bytecode enhancement at build time to enable
lazy loading and dirty checking without proxies. Ebean supports both a query bean approach (type-safe, code-generated
query objects) and a conventional finder-style API, along with built-in features such as automatic query tuning via
AutoTune, L2 caching, change logging, and schema migration generation directly from the entity model.

The framework is used primarily in server-side [Java](../language/java.md)
and [Kotlin](../language/kotlin.md) applications where developers prefer a simpler persistence model over the full
JPA specification. Ebean integrates with application frameworks such as Spring Boot and the Play Framework, and it also
serves as the default ORM in the Avaje ecosystem. Recent versions have added support for Kotlin data classes,
multi-tenancy, ElasticSearch integration, and database-platform-specific features for PostgreSQL, MySQL, MariaDB, SQL
Server, and Oracle.

## Further Information

- [ebean.io](https://ebean.io/)
- [Ebean GitHub](https://github.com/ebean-orm/ebean)
- [Wikipedia](https://en.wikipedia.org/wiki/Ebean)
