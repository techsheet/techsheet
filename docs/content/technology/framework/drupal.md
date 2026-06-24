---
title: Drupal
aliases:
  - /framework/drupal
bookToC: false
techsheet:
  key: drupal
  type: framework
  category: CMS
  languages:
    - php
  related:
    - type: language
      key: php
      comment: "primary language"
    - type: framework
      key: symfony
      comment: "underlying component framework"
    - type: framework
      key: wordpress
      comment: "leading CMS alternative"
    - type: tool
      key: composer
      comment: "dependency management"
---

**An open-source content management framework written in [PHP](../language/php.md), designed for building
structured, highly customizable websites and web applications.**

Drupal is a modular CMS and web application framework that emphasizes extensibility through a hook-based plugin
architecture and a structured content model built around entities, fields, and taxonomies. Since version 8, the platform
has been rebuilt on [Symfony](symfony.md) components, adopting modern PHP practices
including [Composer](../tool/composer.md)-based dependency management, PSR-compliant autoloading, and a service
container with dependency injection. The rendering layer uses the Twig templating engine, and the configuration system
stores site structure as exportable YAML, enabling version-controlled deployments and reproducible environments.

The framework is widely deployed for government portals, higher education sites, large media publishers, and enterprise
intranets where complex content modeling and fine-grained access control are requirements. Drupal's contributed module
ecosystem provides thousands of extensions covering multilingual content, editorial workflows, RESTful APIs (JSON:API
and GraphQL), and decoupled front-end architectures. Drupal 10 and the upcoming Drupal 11 continue to modernize the
platform by requiring PHP 8.1+, adopting Symfony 6/7 components, and introducing recipes and project templates to
simplify site assembly.

## Further Information

- [drupal.org](https://www.drupal.org/)
- [Drupal API Documentation](https://api.drupal.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Drupal)
