---
title: "Git"
aliases:
- "/tool/git"
bookToC: false
techsheet:
  key: "git"
  type: "tool"
  category: "VCS"
  related:
  - type: "tool"
    key: "github-actions"
    comment: "CI platform built on Git hosting"
  - type: "tool"
    key: "gitlab-ci"
    comment: "CI platform built on Git hosting"
  - type: "tool"
    key: "docker"
    comment: "common CI/CD companion"
---

**A distributed version control system designed for speed, data integrity, and support for non-linear workflows.**

Git is a free, open-source version control system originally created by Linus Torvalds in 2005 for the development of
the Linux kernel. Its core architecture is based on a directed acyclic graph of content-addressed objects (blobs, trees,
commits, and tags), which enables efficient branching, merging, and complete local history without requiring a central
server. Every working copy is a full repository with complete history and version-tracking capabilities, making most
operations local and fast. The content-addressable storage model guarantees data integrity through SHA-1 (and
increasingly SHA-256) hashing of all objects.

Git has become the dominant version control system in software development, used by the vast majority of open-source and
commercial projects. Hosting platforms such as GitHub, GitLab, and Bitbucket have built extensive collaboration features
around Git, including pull requests, code review, and integrated CI/CD through tools
like [GitHub Actions](github-actions.md) and [GitLab CI](gitlab-ci.md). The branching model
supports workflows ranging from simple trunk-based development to complex release strategies like Git Flow, and its
staging area (index) provides fine-grained control over commits.

## Further Information

- [git-scm.com](https://git-scm.com/)
- [Git Documentation](https://git-scm.com/doc)
- [Wikipedia](https://en.wikipedia.org/wiki/Git)
