---
title: "Python"
aliases:
- "/language/python"
bookToC: false
techsheet:
  key: "python"
  type: "language"
  related:
  - type: "framework"
    key: "django"
    comment: "flagship web framework"
  - type: "framework"
    key: "fastapi"
    comment: "modern async web framework"
  - type: "framework"
    key: "flask"
    comment: "lightweight web microframework"
  - type: "language"
    key: "r"
    comment: "alternative for statistical computing"
---

**A high-level, dynamically typed, general-purpose programming language emphasizing code readability and developer
productivity.**

Python uses significant indentation and a clean, expressive syntax designed to be readable and straightforward. Its type
system is dynamic and strongly typed, with optional type hints (PEP 484) that enable static analysis through tools like
mypy. The language supports multiple paradigms including procedural, object-oriented, and functional programming, with
first-class functions, list comprehensions, generators, and a comprehensive standard library often described as "
batteries included." CPython, the reference implementation, uses a global interpreter lock (GIL), though the
free-threaded build introduced in Python 3.13 removes this constraint for true multi-threaded parallelism.

The language dominates machine learning and data science through libraries such as NumPy, pandas, scikit-learn,
TensorFlow, and PyTorch. In web
development, [Django](../framework/django.md), [Flask](../framework/flask.md),
and [FastAPI](../framework/fastapi.md) are the principal frameworks. Python is also widely used for scripting,
automation, DevOps tooling, and scientific computing. The ecosystem is managed primarily through pip and PyPI, with
virtual environments providing project-level dependency isolation. Recent releases have focused on performance
improvements (the Faster CPython project), structural pattern matching (3.10), and exception groups (3.11).

## Further Information

- [python.org](https://www.python.org/)
- [Python Package Index (PyPI)](https://pypi.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Python_(programming_language))
