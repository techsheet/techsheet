---
title: "Spring Data"
aliases:
- "/framework/spring-data"
bookToC: false
techsheet:
  key: "spring-data"
  type: "framework"
  category: "Data"
  languages:
  - "java"
  - "kotlin"
  related:
  - type: "framework"
    key: "spring-boot"
    comment: "typical application host"
  - type: "framework"
    key: "hibernate"
    comment: "default JPA provider"
  - type: "framework"
    key: "jooq"
    comment: "JVM data access alternative"
  - type: "language"
    key: "java"
    comment: "primary language"
---

**A unified data access framework that simplifies repository implementations across relational and NoSQL datastores in
the Spring ecosystem.**

Spring Data is part of the broader Spring Framework family and provides a consistent, annotation-driven programming
model
for data access in [Java](../language/java.md) and [Kotlin](../language/kotlin.md). Its central abstraction
is the repository interface, where developers
declare query methods by convention and Spring Data generates the implementation at runtime. The framework supports
derived queries from method names, custom JPQL or native queries via annotations, and query-by-example patterns, all
while integrating seamlessly with Spring's transaction management and dependency injection infrastructure.

The project is organized as a family of modules, each targeting a specific datastore: Spring Data JPA (backed by
[Hibernate](hibernate.md) or other JPA providers), Spring Data MongoDB, Spring Data Redis, Spring
Data
Cassandra, Spring Data Elasticsearch, and others. Reactive variants are available for datastores that support
non-blocking drivers, integrating with [Spring WebFlux](spring-webflux.md) and Project Reactor.
[Spring Boot](spring-boot.md) auto-configures Spring Data repositories, making it the default data
access strategy for most Spring-based applications. Recent versions have added support for query derivation
improvements, enhanced Kotlin coroutine integration, and AOT (ahead-of-time) compilation for GraalVM native images.

## Further Information

- [spring.io/projects/spring-data](https://spring.io/projects/spring-data)
- [Spring Data Reference Documentation](https://docs.spring.io/spring-data/commons/reference/)
- [Wikipedia](https://en.wikipedia.org/wiki/Spring_Data)
