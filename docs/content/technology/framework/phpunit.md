---
title: "PHPUnit"
aliases:
- "/framework/phpunit"
bookToC: false
techsheet:
  key: "phpunit"
  type: "framework"
  category: "Testing"
  languages:
  - "php"
  related:
  - type: "language"
    key: "php"
    comment: "target language"
  - type: "tool"
    key: "composer"
    comment: "package manager for installation"
  - type: "framework"
    key: "symfony"
    comment: "major PHP framework, shares testing conventions"
  - type: "framework"
    key: "laravel"
    comment: "major PHP framework, built-in PHPUnit integration"
---

**The dominant unit testing framework for [PHP](../language/php.md), modeled after the xUnit architecture.**

PHPUnit is a programmer-oriented testing framework that brings the xUnit pattern, originally established by SUnit and
popularized by JUnit, to the [PHP](../language/php.md) ecosystem. It provides a rich assertion library, test
doubles (mocks, stubs, and spies), data providers for parameterized tests, code coverage analysis via integration with
Xdebug or PCOV, and a configurable XML-based test runner. PHPUnit enforces a convention-over-configuration approach
where test classes extend a base `TestCase` class and test methods are identified by a `test` prefix or `@test`
annotation.

Every major [PHP](../language/php.md) framework relies on PHPUnit as its default testing
layer. [Laravel](laravel.md) ships with PHPUnit preconfigured and extends it through its own
`TestCase` base classes for HTTP, console, and browser testing. [Symfony](symfony.md) provides a
PHPUnit bridge that adds deprecation tracking and framework-aware assertions. [Composer](../tool/composer.md)
serves as the standard installation method via `composer require --dev phpunit/phpunit`. PHPUnit 10, released in 2023,
introduced a revised event system replacing the legacy hook architecture, removed previously deprecated functionality,
and streamlined the configuration schema, representing the framework's most significant modernization in over a decade.

## Further Information

- [phpunit.de](https://phpunit.de/)
- [GitHub Repository](https://github.com/sebastianbergmann/phpunit)
- [Wikipedia](https://en.wikipedia.org/wiki/PHPUnit)
