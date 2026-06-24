---
title: "TYPO3"
aliases:
- "/framework/typo3"
bookToC: false
techsheet:
  key: "typo3"
  type: "framework"
  category: "CMS"
  languages:
  - "php"
  related:
  - type: "language"
    key: "php"
    comment: "runtime language"
  - type: "framework"
    key: "symfony"
    comment: "underlying component framework"
  - type: "framework"
    key: "drupal"
    comment: "PHP CMS alternative, enterprise focus"
  - type: "framework"
    key: "wordpress"
    comment: "PHP CMS alternative, broader adoption"
  - type: "tool"
    key: "composer"
    comment: "PHP dependency management"
---

**An enterprise-grade, open-source content management system built on [PHP](../language/php.md)
and [Symfony](symfony.md) components.**

TYPO3 is a web content management system that emphasizes structured content, multi-site management, and fine-grained
access control. Its architecture is based on a layered extension system backed
by [Symfony](symfony.md) components including
dependency injection, routing, and the console. The core provides a backend editing interface with configurable content
types defined through TCA (Table Configuration Array), a TypoScript-based rendering engine for frontend output, and
Extbase/Fluid as an MVC framework for custom extensions. The system supports comprehensive localization, workspaces for
editorial workflows, and a granular permission model suitable for organizations with complex content governance
requirements.

Originally released in 1998, TYPO3 is particularly prevalent in German-speaking countries and across European
enterprises, government institutions, and universities. The project follows a long-term support release cycle, with
major versions receiving several years of maintenance. TYPO3 v12 and v13 have modernized the codebase substantially by
adopting [PHP](../language/php.md) 8.x features, improving the backend UI with a move toward web components,
and strengthening [Composer](../tool/composer.md)-based installation as the standard deployment method. The
extension ecosystem is managed through the TYPO3 Extension Repository (TER) and increasingly through Packagist.

## Further Information

- [typo3.org](https://typo3.org/)
- [docs.typo3.org](https://docs.typo3.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/TYPO3)
