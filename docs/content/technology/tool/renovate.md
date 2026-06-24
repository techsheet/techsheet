---
title: Renovate
aliases:
  - /tool/renovate
bookToC: false
techsheet:
  key: renovate
  type: tool
  category: Security
  related:
    - type: tool
      key: github-actions
      comment: "common CI platform for running Renovate"
    - type: tool
      key: npm
      comment: "primary managed package ecosystem"
    - type: tool
      key: docker
      comment: "manages Docker image dependency updates"
    - type: tool
      key: git
      comment: "operates via Git branches and pull requests"
---

**An automated dependency update tool that keeps software projects current by opening pull requests for outdated
packages and container images.**

Renovate is an open-source dependency management bot that scans project manifests, lockfiles, and configuration files to
detect outdated dependencies and automatically propose updates via pull requests. It supports over 100 package managers
and datasources, including [npm](npm.md), Maven, pip, Cargo, Go modules, [Docker](docker.md)
images, Helm charts, and Terraform providers. The tool uses a JSON5-based configuration system (`renovate.json`) that
supports fine-grained control over update grouping, scheduling, automerge policies, and version pinning strategies. Its
core mechanism involves matching manager-specific file patterns, extracting dependency declarations, querying upstream
registries for new versions, and generating update branches with precise diff-minimal changes.

Renovate can be self-hosted as a Node.js application or consumed as the Mend Renovate GitHub App and GitLab integration,
making it accessible across major [Git](git.md) hosting platforms. It is widely adopted in organizations
that practice continuous dependency hygiene, as it reduces the risk window for known vulnerabilities and prevents
dependency drift. The project originated at Mend.io (formerly WhiteSource) and has grown into one of the most actively
maintained dependency automation tools, with features like vulnerability-based prioritization, replacement and migration
rules for deprecated packages, and post-upgrade testing via [GitHub Actions](github-actions.md)
or [GitLab CI](gitlab-ci.md) pipelines.

## Further Information

- [docs.renovatebot.com](https://docs.renovatebot.com/)
- [GitHub Repository](https://github.com/renovatebot/renovate)
- [Wikipedia](https://en.wikipedia.org/wiki/Mend_(company))
