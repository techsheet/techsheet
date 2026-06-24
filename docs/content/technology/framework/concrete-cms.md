---
title: "Concrete CMS"
aliases:
- "/framework/concrete-cms"
bookToC: false
techsheet:
  key: "concrete-cms"
  type: "framework"
  category: "CMS"
  languages:
  - "php"
  related:
  - type: "language"
    key: "php"
    comment: "implementation language"
  - type: "framework"
    key: "symfony"
    comment: "underlying component framework"
  - type: "framework"
    key: "doctrine"
    comment: "ORM layer used internally"
  - type: "framework"
    key: "wordpress"
    comment: "dominant PHP CMS alternative"
  - type: "framework"
    key: "drupal"
    comment: "enterprise PHP CMS alternative"
---

**An open-source content management system built on [PHP](../language/php.md), designed for in-context editing and
ease of use by non-technical content authors.**

Concrete CMS (formerly concrete5) is a [PHP](../language/php.md)-based content management system that emphasizes
in-page, inline editing as its core interaction model. Built on [Symfony](symfony.md) components and
using [Doctrine](doctrine.md) as its ORM, the system provides a block-based content architecture
where pages are composed of stackable, reorderable content blocks within defined layout areas. The platform features a
permissions system with page-level and block-level access control, built-in versioning with approval workflows, and a
marketplace for add-ons and themes. Its architecture follows an MVC pattern with a package system for extensibility.

Originally released in 2003 under the name concrete5, the project rebranded to Concrete CMS in 2021. It is used
primarily for marketing websites, intranets, and government portals where non-developer content teams require an
intuitive editing experience without leaving the rendered page. Version 9 introduced a modernized codebase with
[Symfony](symfony.md) 6 support, an updated asset pipeline, and improved developer APIs. The project
is governed by the Concrete CMS Foundation and maintains an official marketplace for community-contributed packages.

## Further Information

- [concretecms.org](https://www.concretecms.org/)
- [Concrete CMS Documentation](https://documentation.concretecms.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Concrete_CMS)
