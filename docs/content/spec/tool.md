---
weight: 40
---

# Tool

*Software used to build, test, analyze, package, deploy, or operate systems during the engineering lifecycle.*

## Examples

Maven, Gradle, Docker, Terraform, GitLab CI, SonarQube, Ansible

## Governance Concerns

Supply chain security, CI/CD governance, operational standardization, automation policy, access control

## Includes

* build systems such as Maven, Gradle, and Bazel
* testing tools such as pytest, JUnit, and Cypress
* CI/CD systems such as Jenkins, GitHub Actions, and GitLab CI
* infrastructure automation tooling such as Terraform and Ansible
* packaging and container tooling such as Docker and Packer
* static analysis and quality tooling such as SonarQube, ESLint, and Checkstyle

## Excludes

* programming and query languages
* application frameworks
* databases, messaging systems, and cloud platforms
* external systems required during production runtime

## Disambiguation

### vs Language

Tools operate on languages or source artifacts.

* GCC is a Tool
* C is a Language

### vs Framework

Frameworks shape applications. Tools support engineering workflows.

* Gradle is a Tool
* Django is a Framework

### vs Service

Tools support development, testing, deployment, and operational workflows. Services support production runtime
operation.

* Terraform is a Tool
* Kafka is a Service

## Classification Rule

If the technology primarily supports development, testing, deployment, packaging, or operational workflows, it is a
Tool.

---
