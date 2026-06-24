---
title: ReactPHP
aliases:
  - /framework/reactphp
bookToC: false
techsheet:
  key: reactphp
  type: framework
  category: Concurrency
  languages:
    - php
  related:
    - type: language
      key: php
      comment: "implementation language"
    - type: tool
      key: composer
      comment: "package manager"
    - type: framework
      key: symfony
      comment: "complementary framework, shared ecosystem"
---

**An event-driven, non-blocking I/O library for asynchronous programming in [PHP](../language/php.md).**

ReactPHP provides a low-level event loop, stream abstraction, and asynchronous networking primitives that bring
non-blocking I/O to [PHP](../language/php.md). Inspired by Node.js and the Reactor pattern, it enables
long-running PHP processes
that handle thousands of concurrent connections without threading. The library is built around a central event loop
with support for timers, signals, and stream events, and exposes a Promise-based API for composing asynchronous
operations. It is distributed as a collection of decoupled [Composer](../tool/composer.md) packages, allowing
developers to include
only the components they need.

ReactPHP is used to build HTTP servers, WebSocket servers, TCP/UDP clients, DNS resolvers, and other network services
entirely in PHP. It integrates well with the broader PHP ecosystem, including [Symfony](symfony.md)
components, and serves
as the foundation for higher-level libraries such as Ratchet (WebSockets) and AMPHP (which shares a common event loop
standard through the Revolt library). Since the introduction of PHP Fibers in PHP 8.1, ReactPHP has gained the ability
to use fiber-based coroutines for writing asynchronous code in a synchronous style, significantly improving developer
ergonomics.

## Further Information

- [reactphp.org](https://reactphp.org/)
- [GitHub](https://github.com/reactphp/reactphp)
- [Wikipedia](https://en.wikipedia.org/wiki/ReactPHP)
