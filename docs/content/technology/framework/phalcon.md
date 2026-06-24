---
title: "Phalcon"
aliases:
- "/framework/phalcon"
bookToC: false
techsheet:
  key: "phalcon"
  type: "framework"
  category: "Application"
  languages:
  - "php"
  related:
  - type: "language"
    key: "php"
    comment: "implementation language"
  - type: "framework"
    key: "laravel"
    comment: "PHP framework alternative"
  - type: "framework"
    key: "symfony"
    comment: "PHP framework alternative"
  - type: "framework"
    key: "codeigniter"
    comment: "PHP framework alternative, similar lightweight focus"
---

**A high-performance [PHP](../language/php.md) web framework delivered as a C extension for minimal overhead and
maximum throughput.**

Phalcon is a full-stack MVC framework for [PHP](../language/php.md) that is unique among web frameworks in its
delivery mechanism: rather than
being installed via Composer as PHP source code, it is compiled and loaded as a C extension (a shared object or DLL)
into the PHP runtime. This architecture eliminates the file I/O and interpretation overhead that conventional PHP
frameworks incur on every request, resulting in significantly lower memory consumption and faster execution. Phalcon
provides a comprehensive feature set including an ORM (Phalcon ORM), a template engine (Volt), routing, caching,
dependency injection, and an event-driven architecture, all accessible through PHP classes backed by compiled C code.

The framework targets developers building performance-critical PHP applications who prefer a batteries-included approach
without the runtime cost of a traditional framework. Phalcon is well-suited for RESTful APIs and high-traffic web
applications. Version 5, released in 2022, was rewritten using Zephir, a domain-specific language that compiles to C
extensions, making the codebase more accessible to contributors than raw C. Compared to alternatives such as
[Laravel](laravel.md) or [Symfony](symfony.md), Phalcon trades ecosystem breadth
and
community size for raw execution speed, occupying a distinct niche in the PHP framework landscape.

## Further Information

- [phalcon.io](https://phalcon.io/)
- [Phalcon Documentation](https://docs.phalcon.io/)
- [Wikipedia](https://en.wikipedia.org/wiki/Phalcon_(framework))
