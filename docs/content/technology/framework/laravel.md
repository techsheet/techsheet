---
title: Laravel
aliases:
  - /framework/laravel
bookToC: false
techsheet:
  key: laravel
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
      comment: "PHP alternative, shares components"
    - type: framework
      key: eloquent
      comment: "built-in ORM"
    - type: framework
      key: lumen
      comment: "lightweight Laravel micro-framework"
    - type: tool
      key: composer
      comment: "PHP package manager"
---

**A full-stack [PHP](../language/php.md) web application framework built on expressive syntax and
convention-over-configuration principles.**

Laravel is an open-source MVC framework for [PHP](../language/php.md) that provides an integrated set of tools for
routing, authentication,
database access, templating, queueing, and event broadcasting. It builds on top
of [Symfony](symfony.md) components for its HTTP
kernel and console layer, while adding its own abstractions such as [Eloquent](eloquent.md) ORM,
Blade templating, and Artisan
CLI. The framework emphasizes developer ergonomics through facades, service providers, and a dependency injection
container
that together allow rapid prototyping without sacrificing testability or structure.

The framework has become one of the most widely adopted PHP frameworks for building web applications, APIs, and
SaaS products. Its ecosystem includes official packages for billing (Cashier), WebSocket broadcasting (Echo),
full-text search (Scout), and application scaffolding (Breeze, Jetstream). Recent versions have introduced first-party
support for serverless deployment via Laravel Vapor, Livewire for reactive server-rendered UIs, and Reverb as a
built-in WebSocket server. [Lumen](lumen.md) serves as a micro-framework variant optimized for
stateless APIs and microservices.

## Further Information

- [laravel.com](https://laravel.com/)
- [Laravel Documentation](https://laravel.com/docs)
- [Wikipedia](https://en.wikipedia.org/wiki/Laravel)
