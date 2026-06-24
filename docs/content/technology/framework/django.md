---
title: Django
aliases:
  - /framework/django
bookToC: false
techsheet:
  key: django
  type: framework
  category: Application
  languages:
    - python
  related:
    - type: language
      key: python
      comment: "implementation language"
    - type: framework
      key: flask
      comment: "Python web alternative, micro-framework"
    - type: framework
      key: fastapi
      comment: "Python web alternative, async-first"
---

**A high-level [Python](../language/python.md) web framework that encourages rapid development and clean,
pragmatic design.**

Django is a batteries-included web framework built on the model-view-template (MVT) architectural pattern. It provides
an integrated ORM with migration support, an automatic admin interface, a template engine, form handling,
authentication,
and URL routing out of the box. The framework follows the "don't repeat yourself" (DRY) principle and emphasizes
convention over configuration, allowing developers to build complex database-driven web applications with minimal
boilerplate. Its ORM supports multiple database backends including PostgreSQL, MySQL, SQLite, and Oracle.

Django powers high-traffic sites such as Instagram, Pinterest, and Mozilla, and is one of the most widely adopted
frameworks in the [Python](../language/python.md) ecosystem. The Django REST Framework extends it into a leading
platform for building RESTful APIs. Recent versions (4.x and 5.x) have introduced native async view support, simplified
form rendering, database-computed default values, and facet filters in the admin. The framework maintains a strong
emphasis on security, providing built-in protection against SQL injection, cross-site scripting, cross-site request
forgery, and clickjacking.

## Further Information

- [djangoproject.com](https://www.djangoproject.com/)
- [Django Documentation](https://docs.djangoproject.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/Django_(web_framework))
