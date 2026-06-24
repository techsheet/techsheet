---
title: "Zend Framework"
aliases:
- "/framework/zend-framework"
bookToC: false
techsheet:
  key: "zend-framework"
  type: "framework"
  category: "Application"
  languages:
  - "php"
  related:
  - type: "language"
    key: "php"
    comment: "implementation language"
  - type: "framework"
    key: "symfony"
    comment: "PHP alternative, architectural peer"
  - type: "framework"
    key: "laravel"
    comment: "PHP alternative, dominant successor in adoption"
  - type: "tool"
    key: "composer"
    comment: "PHP package manager"
---

**An enterprise-grade, component-based [PHP](../language/php.md) web application framework emphasizing design
patterns, coding standards, and modular architecture.**

Zend Framework is an open-source, object-oriented MVC framework for [PHP](../language/php.md) that was originally
developed by Zend Technologies, the company behind the PHP engine. It provides a collection of loosely coupled
components covering HTTP handling, MVC architecture, authentication, form processing, input filtering, database
abstraction (Zend\Db), mail, caching, internationalization, and service consumption. The framework strictly follows
PHP-FIG standards and encourages use of established design patterns such as front controller, service locator, and data
mapper. Its component architecture allows individual packages to be used standalone or composed into a full-stack
application, similar in philosophy to [Symfony](symfony.md).

Zend Framework was one of the earliest enterprise PHP frameworks and gained significant adoption in corporate
environments, government agencies, and large-scale web applications throughout the late 2000s and 2010s. In 2019, the
project was transitioned to the Linux Foundation under the name Laminas Project, with all `Zend\` namespaces migrated to
`Laminas\`. The Laminas continuation maintains API compatibility and continues active development with support for
modern PHP features, PSR standards, and [Composer](../tool/composer.md)-based installation. Apigility, the
API-focused distribution of Zend Framework, was similarly rebranded as Laminas API Tools.

## Further Information

- [getlaminas.org](https://getlaminas.org/)
- [Laminas Documentation](https://docs.laminas.dev/)
- [Wikipedia](https://en.wikipedia.org/wiki/Laminas)
