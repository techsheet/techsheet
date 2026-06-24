---
title: MyBatis
aliases:
  - /framework/mybatis
bookToC: false
techsheet:
  key: mybatis
  type: framework
  category: Data
  languages:
    - java
    - kotlin
  related:
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: framework
      key: hibernate
      comment: "JVM alternative, full ORM"
    - type: framework
      key: spring-data
      comment: "common integration layer"
    - type: framework
      key: jooq
      comment: "JVM alternative, typesafe SQL"
---

**A SQL mapping framework for [Java](../language/java.md) and [Kotlin](../language/kotlin.md) that gives
developers explicit control over SQL while eliminating JDBC boilerplate.**

MyBatis is a persistence framework that maps SQL statements to [Java](../language/java.md)
or [Kotlin](../language/kotlin.md) methods through XML descriptors or annotations, occupying a middle ground
between raw JDBC and full object-relational mapping. Unlike [Hibernate](hibernate.md) and other JPA
implementations, it does not attempt to map objects to tables transparently; instead, developers write their own SQL and
define how result sets map to domain objects. This SQL-centric approach provides fine-grained control over query
optimization, supports stored procedures and advanced SQL features natively, and avoids the impedance mismatch problems
that can arise with automatic ORM mapping. The framework's core abstractions are the `SqlSessionFactory`, `SqlSession`,
and mapper interfaces, which together provide transaction management, caching, and dynamic SQL generation through a
built-in templating system.

Originally released as iBATIS by Clinton Begin in 2002 and later incubated at the Apache Software Foundation, the
project was renamed to MyBatis when it moved to Google Code (and subsequently GitHub) in 2010. It is particularly
prevalent in East Asian enterprise development and in projects where complex, hand-tuned SQL is preferred over generated
queries. The MyBatis-Spring module integrates seamlessly with the Spring Framework
and [Spring Boot](spring-boot.md), while MyBatis-Plus extends the core with code generation,
pagination, and CRUD automation. The MyBatis Generator (MBG) tool can reverse-engineer database schemas into mapper
files, model classes, and interface definitions, accelerating initial development on existing databases.

## Further Information

- [mybatis.org](https://mybatis.org/mybatis-3/)
- [MyBatis on GitHub](https://github.com/mybatis/mybatis-3)
- [Wikipedia](https://en.wikipedia.org/wiki/MyBatis)
