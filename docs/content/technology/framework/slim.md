---
title: Slim
aliases:
  - /framework/slim
bookToC: false
techsheet:
  key: slim
  type: framework
  category: Application
  languages:
    - php
  related:
    - type: language
      key: php
      comment: "implementation language"
    - type: framework
      key: symfony
      comment: "provides underlying HTTP and routing components"
    - type: framework
      key: laravel
      comment: "full-stack PHP alternative"
    - type: framework
      key: lumen
      comment: "competing PHP micro-framework"
---

**A lightweight [PHP](../language/php.md) micro-framework for building APIs and small web applications with
minimal overhead.**

Slim is a PSR-7 and PSR-15 compliant micro-framework that provides a thin layer of routing, middleware, and HTTP
message handling on top of [PHP](../language/php.md). Its design philosophy centers on staying small and
unopinionated, delegating
concerns like templating, ORM, and authentication to third-party libraries rather than bundling them. Slim uses a
dependency injection container for service management and supports a middleware pipeline architecture, where each
middleware can inspect and modify the request and response objects before and after the application logic runs. Under
the hood, it relies on well-tested [Symfony](symfony.md) components (such as HttpFoundation) and
Guzzle's PSR-7
implementation for HTTP message processing.

The framework is commonly used for RESTful API development and as a lightweight backend for single-page applications
where a full-stack framework like [Laravel](laravel.md) would introduce unnecessary complexity. Slim
4, the current
major version, introduced a decoupled architecture that requires explicit installation of a PSR-7 implementation, a
DI container, and a PSR-15 middleware dispatcher, giving developers full control over the application's dependency
stack. It competes directly with [Lumen](lumen.md) in the PHP micro-framework space, though Slim's
more minimal
footprint and lack of framework lock-in appeal to developers who prefer composing applications from independent
packages.

## Further Information

- [slimframework.com](https://www.slimframework.com/)
- [Slim GitHub Repository](https://github.com/slimphp/Slim)
- [Wikipedia](https://en.wikipedia.org/wiki/Slim_Framework)
