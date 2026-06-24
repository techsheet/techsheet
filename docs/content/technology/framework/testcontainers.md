---
title: "Testcontainers"
aliases:
- "/framework/testcontainers"
bookToC: false
techsheet:
  key: "testcontainers"
  type: "framework"
  category: "Testing"
  languages:
  - "java"
  - "kotlin"
  - "python"
  related:
  - type: "tool"
    key: "docker"
    comment: "required container runtime"
  - type: "framework"
    key: "junit"
    comment: "primary test framework integration"
  - type: "language"
    key: "java"
    comment: "original implementation language"
  - type: "framework"
    key: "wiremock"
    comment: "complementary HTTP service testing"
---

**An integration testing library that uses disposable [Docker](../tool/docker.md) containers to provide
lightweight, throwaway instances of databases, message brokers, and other infrastructure dependencies.**

Testcontainers is a testing framework that programmatically manages [Docker](../tool/docker.md) containers during
test execution, allowing integration tests to run against real service instances rather than mocks or in-memory
substitutes. The library provides a rich set of pre-configured modules for common infrastructure components such as
PostgreSQL, MySQL, MongoDB, Kafka, Redis, Elasticsearch, and many others, while also supporting arbitrary container
images through its generic container API. Testcontainers handles container lifecycle management automatically, starting
containers before tests and cleaning them up afterward, ensuring test isolation without manual setup.

The library originated in the [Java](../language/java.md) ecosystem and integrates natively
with [JUnit](junit.md) through dedicated extensions, but has expanded to
support [Kotlin](../language/kotlin.md), [Python](../language/python.md), Go, .NET, Rust, and other
languages through independent but API-compatible implementations. Testcontainers Cloud, introduced as a commercial
offering, moves container execution to remote environments, removing the need for a local Docker daemon. The project
became part of Docker's official ecosystem in 2023 when AtomicJar, the company behind Testcontainers, was acquired by
Docker Inc., further solidifying its position as a standard approach to integration testing in containerized development
workflows.

## Further Information

- [testcontainers.com](https://testcontainers.com/)
- [GitHub](https://github.com/testcontainers)
- [Wikipedia](https://en.wikipedia.org/wiki/Testcontainers)
