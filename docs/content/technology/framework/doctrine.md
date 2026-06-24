---
title: Doctrine
aliases:
  - /framework/doctrine
bookToC: false
techsheet:
  key: doctrine
  type: framework
  category: Data
  languages:
    - php
  related:
    - type: language
      key: php
      comment: "implementation language"
    - type: framework
      key: symfony
      comment: "default ORM integration"
    - type: framework
      key: eloquent
      comment: "alternative PHP ORM (Active Record)"
    - type: framework
      key: hibernate
      comment: "Java counterpart, primary design influence"
---

**A set of [PHP](../language/php.md) libraries focused on database storage and object mapping, best known for its
Data Mapper ORM.**

Doctrine is a collection of data persistence libraries for [PHP](../language/php.md), centered around an
Object-Relational Mapper (ORM) and a Database Abstraction Layer (DBAL). Unlike Active Record implementations such
as [Eloquent](eloquent.md), Doctrine follows the Data Mapper pattern, which decouples domain objects
from the persistence layer entirely. Its architecture draws heavily from [Hibernate](hibernate.md) in
the Java ecosystem, featuring an entity manager, a unit of work for tracking object state, and Doctrine Query Language (
DQL), a SQL-like language that operates on object models rather than database tables. The DBAL component provides a
vendor-independent abstraction over PDO with schema introspection, migrations support, and query building.

Doctrine is the default ORM for the [Symfony](symfony.md) framework and is widely adopted across the
PHP ecosystem in enterprise and large-scale applications. Beyond the ORM and DBAL, the project includes standalone
components such as Doctrine Migrations for versioned schema changes and Doctrine Common for shared utilities like
annotations and caching. Doctrine ORM 3.0, a long-anticipated major release, removes the legacy annotation system in
favor of PHP 8 attributes, drops support for older PHP versions, and streamlines the API surface with a focus on type
safety and reduced complexity.

## Further Information

- [doctrine-project.org](https://www.doctrine-project.org/)
- [Doctrine ORM Documentation](https://www.doctrine-project.org/projects/orm.html)
- [Wikipedia](https://en.wikipedia.org/wiki/Doctrine_(PHP))
