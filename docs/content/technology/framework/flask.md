---
title: "Flask"
aliases:
- "/framework/flask"
bookToC: false
techsheet:
  key: "flask"
  type: "framework"
  category: "Application"
  languages:
  - "python"
  related:
  - type: "language"
    key: "python"
    comment: "implementation language"
  - type: "framework"
    key: "django"
    comment: "full-stack Python alternative"
  - type: "framework"
    key: "fastapi"
    comment: "modern async Python alternative"
---

**A lightweight [Python](../language/python.md) web framework designed for simplicity and extensibility, often
called a microframework.**

Flask is a WSGI (Web Server Gateway Interface) web application framework built on the Werkzeug toolkit and the Jinja2
template engine. Its core philosophy is to provide a minimal but extensible foundation, allowing developers to choose
their own database layer, form validation library, and authentication mechanism rather than imposing a fixed stack.
Flask uses a decorator-based routing system, supports blueprints for modular application structure, and provides a
built-in development server with an interactive debugger. The framework follows an explicit-over-implicit design
approach, keeping the application factory pattern and configuration management straightforward.

Flask powers a wide range of web applications, from small REST APIs and prototypes to production services at companies
like Netflix, Reddit, and Lyft. Its extension ecosystem (Flask-SQLAlchemy, Flask-RESTful, Flask-Login, Flask-Migrate)
covers most common web development needs while preserving the freedom to swap components. Flask 2.0 and later added
native support for async views, improved type hints, and short-form route decorators. For projects requiring ASGI and
native async support from the ground up, the same author created Quart as an async-compatible evolution of the Flask
API.

## Further Information

- [flask.palletsprojects.com](https://flask.palletsprojects.com/)
- [PyPI: Flask](https://pypi.org/project/Flask/)
- [Wikipedia](https://en.wikipedia.org/wiki/Flask_(web_framework))
