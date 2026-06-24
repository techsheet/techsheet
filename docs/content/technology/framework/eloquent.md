---
title: Eloquent
aliases:
  - /framework/eloquent
bookToC: false
techsheet:
  key: eloquent
  type: framework
  category: Data
  languages:
    - php
  related:
    - type: language
      key: php
      comment: "implementation language"
    - type: framework
      key: laravel
      comment: "parent framework, ships Eloquent as default ORM"
    - type: framework
      key: doctrine
      comment: "alternative PHP ORM (Data Mapper pattern)"
---

**An Active Record ORM for [PHP](../language/php.md) that provides an expressive, convention-driven interface for
database interaction.**

Eloquent is the object-relational mapper included with the [Laravel](laravel.md) framework,
implementing the Active Record pattern where each database table is represented by a model class that handles both data
access and domain logic. It provides a fluent query builder, automatic timestamp management, soft deletes, eager and
lazy loading of relationships, mutators and accessors for attribute transformation, and model events for lifecycle
hooks. Unlike the Data Mapper approach used by [Doctrine](doctrine.md), Eloquent couples persistence
logic directly to the model, trading strict separation of concerns for reduced boilerplate and rapid development. Its
relationship system supports one-to-one, one-to-many, many-to-many, polymorphic, and has-many-through associations, all
defined as methods on the model class.

Eloquent is the most widely used ORM in the [PHP](../language/php.md) ecosystem by virtue of Laravel's popularity,
and it can also be used as a standalone component outside Laravel via the `illuminate/database` package. The ORM
integrates tightly with Laravel's migration system, factories for test data generation, and resource classes for API
serialization. Recent Laravel versions have introduced Eloquent features such as immutable date casting, lazy
collections for memory-efficient batch processing, prunable models for automatic cleanup of stale records, and improved
type hinting support for static analysis tools.

## Further Information

- [Laravel Eloquent Documentation](https://laravel.com/docs/eloquent)
- [illuminate/database on Packagist](https://packagist.org/packages/illuminate/database)
- [Wikipedia](https://en.wikipedia.org/wiki/Laravel#Eloquent_ORM)
