---
title: "Docker Compose"
aliases:
- "/tool/docker-compose"
bookToC: false
techsheet:
  key: "docker-compose"
  type: "tool"
  category: "Container"
  related:
  - type: "tool"
    key: "docker"
    comment: "underlying container runtime"
  - type: "tool"
    key: "gitlab-ci"
    comment: "CI integration for service dependencies"
  - type: "tool"
    key: "github-actions"
    comment: "CI integration for service dependencies"
---

**A container orchestration tool for defining and running multi-container [Docker](docker.md) applications
using declarative YAML configuration.**

Docker Compose provides a declarative approach to configuring multi-container applications through a single
`docker-compose.yml` (or `compose.yaml`) file. It manages the complete lifecycle of interconnected services, including
networking, volume mounts, environment variables, health checks, and dependency ordering. The configuration model treats
each service as an isolated [Docker](docker.md) container while enabling them to communicate over
automatically provisioned internal networks. Compose follows a project-based isolation model, where each project (
typically one configuration file) creates its own namespace for containers, networks, and volumes.

Originally a standalone Python tool (`docker-compose`), Docker Compose was rewritten in Go and integrated into the
Docker CLI as `docker compose` (Compose V2), becoming a built-in plugin rather than a separate binary. It is used
extensively in local development environments to replicate production-like multi-service setups, in CI/CD pipelines for
integration testing with real service dependencies, and for single-host deployments. The Compose Specification, now an
open standard, defines the file format independently of any specific container runtime, and support for features such as
profiles, watch mode for live reloading, and GPU resource reservations has broadened its applicability beyond simple
development workflows.

## Further Information

- [docs.docker.com/compose](https://docs.docker.com/compose/)
- [Compose Specification](https://compose-spec.io/)
- [Wikipedia](https://en.wikipedia.org/wiki/Docker_(software)#Docker_Compose)
