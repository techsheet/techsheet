---
title: "Craft CMS"
aliases:
- "/framework/craft-cms"
bookToC: false
techsheet:
  key: "craft-cms"
  type: "framework"
  category: "CMS"
  languages:
  - "php"
  related:
  - type: "language"
    key: "php"
    comment: "implementation language"
  - type: "framework"
    key: "yii2"
    comment: "underlying application framework"
  - type: "tool"
    key: "composer"
    comment: "package manager for plugins and updates"
  - type: "framework"
    key: "wordpress"
    comment: "dominant CMS alternative"
---

**A commercial, developer-oriented content management system built on [PHP](../language/php.md) and
the [Yii2](yii2.md) framework.**

Craft CMS is a proprietary CMS designed around a flexible content modeling system that allows developers to define
arbitrary content types, fields, and relationships without rigid assumptions about page structure. It is built on top
of the [Yii2](yii2.md) application framework, uses Twig as its templating engine, and manages
dependencies through [Composer](../tool/composer.md). The architecture separates content authoring from
presentation, providing a clean control panel for editors alongside full developer control over front-end rendering.
Craft supports both traditional server-rendered output and headless operation through a built-in GraphQL API, making it
suitable for decoupled and multi-channel delivery architectures.

The system is positioned as a premium alternative to open-source platforms
like [WordPress](wordpress.md)
and [Drupal](drupal.md), targeting agencies and teams that require precise content modeling and
a polished editorial experience. Craft 4 moved to [PHP](../language/php.md) 8.0+ as its minimum requirement and
adopted a queue-based job system for background processing. Craft 5, released in 2024, introduced a revamped
entry type system, improved the content modeling workflow, and extended the first-party GraphQL and headless
capabilities. The plugin ecosystem is managed through the official Craft Plugin Store and distributed via Composer.

## Further Information

- [craftcms.com](https://craftcms.com/)
- [Craft CMS Documentation](https://craftcms.com/docs/)
- [Wikipedia](https://en.wikipedia.org/wiki/Craft_CMS)
