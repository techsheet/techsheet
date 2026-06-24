---
title: "FastAPI"
aliases:
- "/framework/fastapi"
bookToC: false
techsheet:
  key: "fastapi"
  type: "framework"
  category: "Application"
  languages:
  - "python"
  related:
  - type: "language"
    key: "python"
    comment: "runtime language"
  - type: "framework"
    key: "flask"
    comment: "lightweight alternative, similar micro-framework approach"
  - type: "framework"
    key: "django"
    comment: "full-stack alternative for Python web applications"
---

**A modern, high-performance [Python](../language/python.md) web framework for building APIs, based on standard
type hints and asynchronous request handling.**

FastAPI is an ASGI-based web framework that leverages [Python](../language/python.md) type annotations to provide
automatic request validation, serialization, and OpenAPI documentation generation. It builds on Starlette for the web
layer and Pydantic for data validation, combining both into a developer experience that emphasizes correctness and
minimal boilerplate. The framework supports asynchronous endpoint handlers natively through Python's `async`/`await`
syntax, enabling high concurrency for I/O-bound workloads without requiring external event loop management. Its
dependency injection system allows composable, testable request processing pipelines.

The framework has seen rapid adoption for microservices, machine learning model serving, and RESTful API backends,
particularly in organizations already invested in the Python ecosystem. FastAPI's automatic interactive API
documentation (Swagger UI and ReDoc) and its compatibility with the broader ASGI middleware ecosystem make it a
practical choice for teams that need both development speed and runtime performance. Since its initial release in 2018,
it has become one of the most widely used Python web frameworks, with performance benchmarks consistently placing it
among the fastest pure-Python options available.

## Further Information

- [fastapi.tiangolo.com](https://fastapi.tiangolo.com/)
- [FastAPI GitHub Repository](https://github.com/fastapi/fastapi)
- [Wikipedia](https://en.wikipedia.org/wiki/FastAPI)
