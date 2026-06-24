---
title: "Monolog"
aliases:
- "/framework/monolog"
bookToC: false
techsheet:
  key: "monolog"
  type: "framework"
  category: "Logging"
  languages:
  - "php"
  related:
  - type: "language"
    key: "php"
    comment: "primary language"
  - type: "framework"
    key: "symfony"
    comment: "default logging integration"
  - type: "framework"
    key: "laravel"
    comment: "default logging backend"
  - type: "tool"
    key: "composer"
    comment: "package distribution"
---

**A comprehensive logging library for [PHP](../language/php.md) that implements the PSR-3 logger interface and
supports a wide range of handlers, formatters, and processors.**

Monolog sends log records to files, sockets, databases, inboxes, and various web services by routing each record through
a configurable stack of handlers. Its architecture follows a channel-based design where each logger instance represents
a named channel, and handlers are evaluated in order until one processes the record or the stack is exhausted. Handlers
implement a bubble mechanism that controls whether a record continues to the next handler after being processed.
Formatters transform log records into the target format (JSON, line-based, HTML, and others), while processors enrich
records with contextual data such as memory usage, request information, or unique identifiers. The library implements
the PSR-3 (PHP-FIG) LoggerInterface, making it interchangeable with any PSR-3-compliant consumer.

Monolog is the de facto standard logging library in the PHP ecosystem. [Symfony](symfony.md) bundles
it as its default logging component through the MonologBundle, and [Laravel](laravel.md) uses it as
the foundation of its logging system, exposing it via a facade with driver-based configuration. The library ships with
over 50 built-in handlers covering common destinations including Elasticsearch, Slack, Telegram, Syslog, and rotating
files. Monolog 3.x requires PHP 8.1 or later and leverages typed properties, enumerations, and fibers introduced in
modern PHP versions.

## Further Information

- [github.com/Seldaek/monolog](https://github.com/Seldaek/monolog)
- [Packagist](https://packagist.org/packages/monolog/monolog)
- [Wikipedia](https://en.wikipedia.org/wiki/Monolog_(software))
