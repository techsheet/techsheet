---
title: "GitLab CI"
aliases:
- "/tool/gitlab-ci"
bookToC: false
techsheet:
  key: "gitlab-ci"
  type: "tool"
  category: "CI"
  related:
  - type: "tool"
    key: "github-actions"
    comment: "direct alternative, GitHub-based CI/CD"
  - type: "tool"
    key: "docker"
    comment: "runner execution environment"
  - type: "tool"
    key: "git"
    comment: "underlying version control system"
---

**A built-in continuous integration and delivery platform for GitLab that defines pipelines as code using YAML
configuration.**

GitLab CI/CD is the automation component of the GitLab DevOps platform, configured through a `.gitlab-ci.yml` file at
the repository root. Pipelines consist of stages executed sequentially, each containing jobs that run in parallel within
their stage. The system uses GitLab Runners as execution agents, which can operate in shared, group, or project-specific
modes and support multiple executors including [Docker](docker.md), Kubernetes, and shell. Core features
include directed acyclic graph (DAG) scheduling for cross-stage job dependencies, merge request pipelines, multi-project
pipelines, and a built-in container registry.

GitLab CI/CD is used across enterprises and open-source projects that host on GitLab, both self-managed and on
GitLab.com. Its tight integration with the GitLab platform provides unified access to code review, issue tracking,
security scanning (SAST, DAST, dependency scanning), and deployment environments without requiring third-party plugins.
The Auto DevOps feature can automatically detect project types and generate CI/CD configurations, and the platform has
expanded to include compliance pipelines, pipeline components for reusable configuration, and GitLab Duo AI-assisted
pipeline generation.

## Further Information

- [docs.gitlab.com/ci](https://docs.gitlab.com/ci/)
- [Wikipedia](https://en.wikipedia.org/wiki/GitLab)
- [GitLab CI/CD Pipeline Configuration Reference](https://docs.gitlab.com/ci/yaml/)
