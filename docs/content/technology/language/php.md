---
title: PHP
aliases:
  - /language/php
bookToC: false
techsheet:
  key: php
  type: language
  related:
    - type: tool
      key: composer
      comment: "standard package manager"
    - type: framework
      key: laravel
      comment: "dominant application framework"
    - type: framework
      key: symfony
      comment: "enterprise application framework"
    - type: framework
      key: wordpress
      comment: "most widely deployed PHP CMS"
    - type: language
      key: javascript
      comment: "common web companion"
---

**A widely-used, general-purpose scripting language originally designed for server-side web development.**

PHP (PHP: Hypertext Preprocessor) is a dynamically typed, interpreted language with C-style syntax and built-in support
for HTML templating. It follows an imperative and object-oriented paradigm, with support for classes, interfaces,
traits,
enumerations (since 8.1), and first-class closures. The language embeds directly into HTML, and its execution model
centers on a shared-nothing, request-per-process architecture that simplifies deployment and horizontal scaling. The
standard library ships extensive built-in functions for string handling, regular expressions, database access, and
HTTP operations, giving it a notably low barrier to entry for web development.

The language powers a substantial share of the web, serving as the foundation for content management systems like
[WordPress](../framework/wordpress.md), Drupal, and Joomla, as well as full-stack frameworks such as
[Laravel](../framework/laravel.md) and [Symfony](../framework/symfony.md). Dependency management is handled
through [Composer](../tool/composer.md), which established a modern packaging ecosystem around Packagist. Modern
PHP (8.0+) has undergone significant evolution, introducing a JIT compiler, union and intersection types, named
arguments, fibers for cooperative multitasking, readonly properties, and match expressions, narrowing the gap with
statically typed languages in terms of type safety and expressiveness.

## Further Information

- [php.net](https://www.php.net/)
- [PHP: The Right Way](https://phptherightway.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/PHP)
