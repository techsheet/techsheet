---
title: Symfony
aliases:
  - /framework/symfony
bookToC: false
techsheet:
  key: symfony
  type: framework
  category: Application
  languages:
    - php
  related:
    - type: language
      key: php
      comment: "implementation language"
    - type: framework
      key: laravel
      comment: "PHP alternative, consumes Symfony components"
    - type: framework
      key: doctrine
      comment: "default ORM and database abstraction"
    - type: tool
      key: composer
      comment: "PHP package manager"
---

**A modular, component-based [PHP](../language/php.md) web application framework designed for building robust,
high-performance applications and reusable libraries.**

Symfony is an open-source full-stack MVC framework for [PHP](../language/php.md) that emphasizes a decoupled,
component-oriented architecture. Its core consists of over 50 standalone components covering HTTP handling, routing,
dependency injection, event dispatching, form processing, security, and serialization. Each component can be used
independently outside the framework, which has led to widespread adoption by other projects. The framework follows
established design patterns including front controller, dependency injection container, and event-driven middleware, and
adheres strictly to PHP-FIG standards (PSR-4, PSR-7, PSR-11, PSR-15). Configuration supports YAML, XML, PHP, and
annotation/attribute-based formats, giving developers flexibility in how they structure applications.

Symfony is widely used for enterprise web applications, content management platforms, and API backends. Major PHP
projects including [Laravel](laravel.md), [Drupal](drupal.md), and several PHP CMS
platforms rely on Symfony components for their foundational layers. The framework
integrates [Doctrine](doctrine.md) as its default ORM and uses Twig as its templating engine. Symfony
Flex, the modern application bootstrapping tool, streamlines dependency management and recipe-based configuration
through [Composer](../tool/composer.md). The project follows a predictable release cycle with long-term support
versions, and Symfony 7 (released 2023) continued to modernize the framework with native PHP 8.2+ features, improved
type safety, and performance optimizations across the component stack.

## Further Information

- [symfony.com](https://symfony.com/)
- [Symfony Documentation](https://symfony.com/doc/current/index.html)
- [Wikipedia](https://en.wikipedia.org/wiki/Symfony)
