---
title: Grav
aliases:
  - /framework/grav
bookToC: false
techsheet:
  key: grav
  type: framework
  category: CMS
  languages:
    - php
  related:
    - type: language
      key: php
      comment: "implementation language"
    - type: framework
      key: symfony
      comment: "uses Symfony components"
    - type: framework
      key: wordpress
      comment: "dominant PHP CMS alternative, database-driven"
    - type: framework
      key: drupal
      comment: "major PHP CMS alternative"
---

**A flat-file content management system built on [PHP](../language/php.md) that requires no database and stores
all content in Markdown files.**

Grav is an open-source CMS that eliminates the traditional database layer by storing content, configuration, and
metadata entirely in the filesystem as Markdown and YAML files. It is built on top
of [Symfony](symfony.md) components and uses
Twig as its templating engine. Grav features a modular architecture with a plugin system, dependency management through
its built-in GPM (Grav Package Manager), image processing with smart caching, and taxonomy-based content organization.
The flat-file approach provides inherent advantages for version control, portability, and deployment simplicity, since
an entire site can be managed through Git without database migration concerns.

The system targets developers and technical content creators who want a lightweight, fast CMS without the overhead of
database-backed systems like [WordPress](wordpress.md) or [Drupal](drupal.md).
Grav includes a built-in admin panel plugin for
browser-based management, supports multi-language content, and provides flexible routing and page composition through
its modular page architecture. The project has maintained an active plugin and theme ecosystem, positioning itself as a
developer-friendly middle ground between static site generators and full database-driven content management systems.

## Further Information

- [getgrav.org](https://getgrav.org/)
- [Grav Documentation](https://learn.getgrav.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Grav_(CMS))
