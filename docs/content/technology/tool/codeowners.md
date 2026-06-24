---
title: CODEOWNERS
aliases:
  - /tool/codeowners
bookToC: false
techsheet:
  key: codeowners
  type: tool
  category: CI
  related:
    - type: tool
      key: git
      comment: "underlying version control system"
    - type: tool
      key: github-actions
      comment: "GitHub CI, same platform"
    - type: tool
      key: gitlab-ci
      comment: "GitLab CI, also supports CODEOWNERS"
---

**A repository configuration file that defines ownership rules for file paths, enabling automatic review assignment and
access control in [Git](git.md)-based platforms.**

CODEOWNERS is a convention-based configuration mechanism supported by GitHub, GitLab, and Bitbucket that maps file path
patterns to responsible individuals or teams. The file uses a syntax similar to `.gitignore`, where glob patterns are
followed by one or more owner identifiers (usernames, email addresses, or team handles). When a pull request or merge
request modifies files matching a pattern, the platform automatically requests reviews from the designated owners,
enforcing a structured code review workflow without manual intervention.

The feature is typically used to protect critical paths in a repository such as CI configurations, security-sensitive
modules, API contracts, or infrastructure-as-code definitions. GitHub supports placement of the file at the repository
root, in the `.github/` directory, or in the `docs/` directory, while GitLab requires it in the root or a configurable
location and extends the concept with per-section approval rules and optional versus required ownership. Organizations
commonly combine CODEOWNERS with branch protection rules to enforce that changes to specific areas require sign-off from
domain experts before merging.

## Further Information

- [GitHub CODEOWNERS Documentation](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-code-owners)
- [GitLab Code Owners Documentation](https://docs.gitlab.com/ee/user/project/codeowners/)
- [Wikipedia](https://en.wikipedia.org/wiki/Codeowner)
