---
title: "Composer"
aliases:
- "/tool/composer"
bookToC: false
techsheet:
  key: "composer"
  type: "tool"
  category: "Build"
  related:
  - type: "language"
    key: "php"
    comment: "target language"
  - type: "tool"
    key: "npm"
    comment: "analogous package manager for JavaScript"
  - type: "framework"
    key: "laravel"
    comment: "major PHP framework, relies on Composer"
  - type: "framework"
    key: "symfony"
    comment: "major PHP framework, tightly integrated"
---

**The standard dependency manager for [PHP](../language/php.md), providing per-project package installation and
autoloading.**

Composer is a command-line tool that manages libraries and their dependencies on a per-project basis, inspired by
Node.js's [npm](npm.md) and Ruby's Bundler. It resolves dependency trees from a `composer.json` manifest,
downloads packages from the Packagist repository (or custom sources), and generates a PSR-4 compliant autoloader.
Composer uses semantic versioning constraints to determine compatible package versions and produces a `composer.lock`
file that pins exact versions, ensuring reproducible installations across environments.

The tool is essential to modern PHP development and serves as the backbone for frameworks such
as [Laravel](../framework/laravel.md), [Symfony](../framework/symfony.md),
and [CakePHP](../framework/cakephp.md). Virtually every contemporary PHP project relies on Composer for dependency
management, and its autoloading mechanism has become the de facto standard, replacing earlier manual or PEAR-based
approaches. Composer 2, released in 2020, introduced significant performance improvements through parallel downloads,
architectural changes to reduce memory usage, and a stricter runtime platform check.

## Further Information

- [getcomposer.org](https://getcomposer.org/)
- [Packagist](https://packagist.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Composer_(software))
