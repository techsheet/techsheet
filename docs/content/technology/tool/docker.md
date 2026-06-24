---
title: "Docker"
aliases:
- "/tool/docker"
bookToC: false
techsheet:
  key: "docker"
  type: "tool"
  category: "Container"
  related:
  - type: "tool"
    key: "docker-compose"
    comment: "companion multi-container orchestration"
  - type: "framework"
    key: "testcontainers"
    comment: "integration testing via disposable containers"
  - type: "tool"
    key: "github-actions"
    comment: "common CI/CD integration target"
---

**An open-source platform for building, shipping, and running applications in isolated, lightweight containers.**

Docker provides OS-level virtualization through containers, which package an application together with its dependencies,
libraries, and configuration into a single portable unit. Unlike traditional virtual machines, containers share the host
operating system's kernel and start in milliseconds, making them far more resource-efficient. The core abstractions are
images (immutable, layered filesystem snapshots defined by a Dockerfile), containers (running instances of images), and
registries (distribution hubs such as Docker Hub). A union filesystem and copy-on-write strategy keep images compact,
while Linux namespaces and cgroups provide process isolation and resource limits.

Containerization with Docker has become the standard deployment model for microservices, cloud-native applications, and
CI/CD pipelines. Most orchestration platforms, including Kubernetes and Amazon ECS, use the OCI container image format
that Docker popularized. [Docker Compose](docker-compose.md) extends the workflow to multi-container
applications defined in a single YAML file. The ecosystem also includes Docker Desktop for local development,
Docker Scout for supply-chain security analysis, and Docker Build Cloud for remote image builds. Frameworks such as
[Testcontainers](../framework/testcontainers.md) leverage Docker to spin up ephemeral service dependencies during
integration tests.

## Further Information

- [docker.com](https://www.docker.com/)
- [Docker Documentation](https://docs.docker.com/)
- [Wikipedia](https://en.wikipedia.org/wiki/Docker_(software))
