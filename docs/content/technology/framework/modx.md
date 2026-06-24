---
title: "MODX"
aliases:
- "/framework/modx"
bookToC: false
techsheet:
  key: "modx"
  type: "framework"
  category: "CMS"
  languages:
  - "php"
  related:
  - type: "language"
    key: "php"
    comment: "implementation language"
  - type: "framework"
    key: "wordpress"
    comment: "dominant PHP CMS alternative"
  - type: "framework"
    key: "drupal"
    comment: "PHP CMS alternative, enterprise-oriented"
  - type: "framework"
    key: "laravel"
    comment: "PHP application framework, common migration target"
---

**A flexible, open-source content management system built on [PHP](../language/php.md), designed around a
tag-based templating engine and creative freedom for developers.**

MODX is a PHP-based content management framework that distinguishes itself from conventional CMS platforms through its
tag-based templating system and lack of an opinionated front-end rendering layer. Rather than imposing a theme
structure, it provides Elements (Templates, Chunks, Snippets, and Plugins) that developers compose to build custom
output. The system uses a resource-tree content model with a built-in caching layer and supports granular access
controls through its security framework. MODX Revolution (2.x/3.x), the current major branch, is built on the xPDO
object-relational bridge and follows an MVC-inspired architecture, giving developers direct control over markup while
still offering a polished manager interface for content editors.

The platform occupies a niche between full-framework development and turnkey CMS solutions
like [WordPress](wordpress.md) or [Drupal](drupal.md), appealing to agencies and
developers who need CMS conveniences without template constraints. MODX supports a package management system through its
Extras repository and can serve as a headless CMS via its REST API. MODX 3, released in 2023, modernized the codebase
with PHP 8.x support, namespace adoption, and Composer-based dependency management, aligning the project with
contemporary PHP ecosystem standards.

## Further Information

- [modx.com](https://modx.com/)
- [MODX Documentation](https://docs.modx.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/MODX)
