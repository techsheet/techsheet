---
title: "WordPress"
aliases:
- "/framework/wordpress"
bookToC: false
techsheet:
  key: "wordpress"
  type: "framework"
  category: "CMS"
  languages:
  - "php"
  related:
  - type: "language"
    key: "php"
    comment: "primary language"
  - type: "framework"
    key: "drupal"
    comment: "major CMS alternative"
  - type: "framework"
    key: "joomla"
    comment: "PHP-based CMS alternative"
  - type: "tool"
    key: "composer"
    comment: "dependency management"
---

**An open-source content management system written in [PHP](../language/php.md), powering a significant share of
the web through its extensible plugin and theme architecture.**

WordPress began as a blogging platform in 2003 and evolved into a general-purpose CMS that, by usage share, runs more
websites than any other single platform. Its core architecture follows a hook-and-filter event system that allows
plugins and themes to modify virtually every aspect of request handling and output rendering without altering core
files. The platform stores content in a MySQL-compatible relational database and uses a template hierarchy to resolve
page rendering, with theme files composed of [PHP](../language/php.md) templates and template tags. Since version
5.0, the block editor (Gutenberg) has introduced a React-based content editing experience, and the REST API provides a
full JSON interface to content, enabling decoupled and headless deployment patterns.

The ecosystem includes over 60,000 plugins in the official directory, covering e-commerce (WooCommerce), multilingual
content (WPML, Polylang), SEO, caching, security hardening, and custom post type management. WordPress is deployed
across personal blogs, corporate sites, news publishers, and e-commerce stores. Recent development has focused on
full-site editing, server-side block rendering, performance improvements through speculative loading and lazy-loaded
assets, and a gradual transition toward modern PHP practices including namespace adoption
and [Composer](../tool/composer.md)-based dependency management. The WordPress Playground project enables running
full instances entirely in the browser via WebAssembly.

## Further Information

- [wordpress.org](https://wordpress.org/)
- [Developer Resources](https://developer.wordpress.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/WordPress)
