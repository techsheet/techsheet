---
title: GitHub Actions
aliases:
  - /tool/github-actions
bookToC: false
techsheet:
  key: github-actions
  type: tool
  category: CI
  related:
    - type: tool
      key: gitlab-ci
      comment: "direct CI/CD alternative"
    - type: tool
      key: docker
      comment: "common container runtime in workflows"
    - type: tool
      key: git
      comment: "underlying version control system"
    - type: tool
      key: renovate
      comment: "dependency automation often run as an action"
---

**A CI/CD platform integrated into GitHub that automates software build, test, and deployment workflows directly from a
repository.**

GitHub Actions is an event-driven automation system built into the GitHub platform. Workflows are defined as YAML files
in a repository's `.github/workflows/` directory and are triggered by events such as pushes, pull requests, issue
comments, scheduled cron expressions, or external webhook calls. Each workflow consists of one or more jobs that run on
GitHub-hosted or self-hosted runners, with jobs further divided into steps that execute shell commands or reusable
actions. The marketplace provides thousands of community-maintained actions for common tasks, and composite actions and
reusable workflows allow teams to encapsulate and share CI/CD logic across repositories. A matrix strategy enables
parallel testing across multiple operating systems, language versions, or configuration variants in a single job
definition.

The platform supports Linux, macOS, and Windows runners out of the box and offers larger runners with GPU and ARM
architectures for specialized workloads. Secrets management, environment protection rules, and OpenID Connect (OIDC)
token federation provide secure integration with cloud providers and deployment targets.
[Docker](docker.md) containers can serve as job containers or service containers within workflows,
enabling
reproducible build environments and integration testing against databases or message brokers. GitHub Actions has become
one of the most widely adopted CI/CD systems in open-source and commercial software development, largely due to its
zero-configuration availability on every GitHub repository and its generous free tier for public projects.

## Further Information

- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [GitHub Actions Marketplace](https://github.com/marketplace?type=actions)
- [Wikipedia](https://en.wikipedia.org/wiki/GitHub_Actions)
