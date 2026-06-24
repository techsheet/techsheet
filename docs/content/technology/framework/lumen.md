---
title: Lumen
aliases:
  - /framework/lumen
bookToC: false
techsheet:
  key: lumen
  type: framework
  category: Application
  languages:
    - php
  related:
    - type: framework
      key: laravel
      comment: "parent framework, full-stack counterpart"
    - type: language
      key: php
      comment: "implementation language"
    - type: framework
      key: eloquent
      comment: "ORM available as optional component"
    - type: tool
      key: composer
      comment: "PHP package manager"
---

**A lightweight micro-framework for [PHP](../language/php.md), derived
from [Laravel](laravel.md) and optimized for building fast APIs and microservices.**

Lumen is an open-source micro-framework created by Taylor Otwell as a stripped-down variant
of [Laravel](laravel.md), designed for
applications where the full Laravel feature set is unnecessary. It retains Laravel's core routing, dependency injection
container, and middleware pipeline while removing heavier components such as session handling, cookie management, and
Blade templating by default. The framework supports [Eloquent](eloquent.md) ORM and most Illuminate
components as opt-in additions, allowing developers to selectively restore Laravel features when needed. This selective
architecture results in significantly reduced bootstrap overhead, making it one of the faster PHP frameworks for
request handling.

Lumen is primarily used for stateless RESTful APIs, microservices, and backend services where low latency and high
throughput are priorities. It shares Laravel's [Composer](../tool/composer.md)-based package ecosystem and can be
upgraded to a full Laravel application by migrating the project structure, which makes it a practical starting point for
services that may grow in scope. While Lumen saw widespread adoption during the microservices trend of the mid-2010s,
the Laravel team has since recommended using Laravel itself for most new projects, noting that performance improvements
in recent Laravel versions have narrowed the gap. Lumen remains in maintenance and continues to receive updates aligned
with Laravel releases.

## Further Information

- [lumen.laravel.com](https://lumen.laravel.com/)
- [Lumen Documentation](https://lumen.laravel.com/docs)
- [Wikipedia](https://en.wikipedia.org/wiki/Lumen_(software))
