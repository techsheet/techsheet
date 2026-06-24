---
title: Contao
aliases:
  - /framework/contao
bookToC: false
techsheet:
  key: contao
  type: framework
  category: CMS
  languages:
    - php
  related:
    - type: language
      key: php
      comment: "runtime language"
    - type: framework
      key: symfony
      comment: "underlying application framework"
    - type: framework
      key: typo3
      comment: "alternative PHP CMS, also German-origin"
    - type: framework
      key: doctrine
      comment: "ORM layer, integrated via Symfony"
---

**An open-source content management system built on [Symfony](symfony.md) and designed for
standards-compliant, accessible web content.**

Contao is a [PHP](../language/php.md)-based CMS that emphasizes clean HTML output, accessibility compliance, and a
structured approach to content management. Originally released in 2006 under the name TYPOlight, the project was renamed
to Contao in 2010 to establish its own identity. Since version 4, Contao is built entirely on
the [Symfony](symfony.md) framework, leveraging its HTTP kernel, routing, dependency injection
container, and the [Doctrine](doctrine.md) ORM for database access. The system provides a backend
interface with fine-grained access control, a template engine, a built-in theme manager, and native multi-language
support.

Contao is particularly popular in the German-speaking market, where it competes
with [TYPO3](typo3.md) and [WordPress](wordpress.md) for mid-sized corporate and
institutional websites. The CMS follows a managed-edition deployment model using [Composer](../tool/composer.md),
aligning with modern PHP packaging practices. Contao 5, released in 2023, requires PHP 8.1+ and Symfony 6.4+, and
introduced Twig-based templates replacing the legacy PHP templating, along with improved content composition through
content elements and fragment controllers.

## Further Information

- [contao.org](https://contao.org/)
- [Contao Documentation](https://docs.contao.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Contao)
