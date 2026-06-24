---
title: Specification
weight: 20
bookCollapseSection: true
---

# Specification

A TechSheet, represented by a `techsheet.yml` file normally, forms a container for all project and technology
information. Is is **scoped to one project** or sub-project and contains technical information about it.

Information is divided into sections, where each section is optional (can be omitted). Valid `techsheet.yml` files must
contain at least one section with non-empty content.

## Example

```yaml
project:
  id: "c7d2be65-447a-4c29-9840-566fa561587b"
  name: "Test Project"
languages:
  - id: "language.java"
    name: "Java"
    url: "https://techsheet.org/language/java"
    version: "21"
  - id: "language.javascript"
    name: "JavaScript"
    url: "https://techsheet.org/language/javascript"
frameworks:
  - id: "framework.spring-boot"
    name: "Spring Boot"
    category: "Application"
    url: "https://techsheet.org/framework/spring-boot"
    version: "4.0.5"
services: [ ]
tools:
  - id: "tool.git"
    name: "Git"
    category: "VCS"
    url: "https://techsheet.org/tool/git"
```

## Sections

While the [Project](project.md) section contains project metadata, technologies are defined as specific sections with
dedicated structure. Each Technology type represents a distinct operational role within the software lifecycle or
runtime
architecture:

- [Languages](language.md) the project is based on
- [Frameworks](framework.md) the project uses
- [Services](service.md) the project relies on at runtime
- [Tools](tool.md) the project is built or operated with

## Classification Principles

TechSheet technology classification is based on the following principles:

1. **Prefer Strategic Technologies**<br>
   Prioritize technologies that affect architecture, operations, governance, hiring, compliance, or vendor exposure.
   Avoid exhaustive dependency inventorying.
2. **Avoid Redundant Detection**<br>
   Prefer technologies that represent distinct architectural or operational decisions.
   Avoid duplicate reporting of tightly coupled implementation details.
3. **Classify by Primary Role**<br>
   Classification is based on the technology’s primary role within the software lifecycle or runtime architecture.

## Schema

The TechSheet JSON Schema defines the structure and validation rules for `techsheet.yml` and `techsheet.json` files.
Use it for editor auto-completion, CI validation, or building your own tooling around TechSheet.

### Current Version

**[TechSheet v2](v2/techsheet.md)** is the current schema version. It replaces the flat dependency list
of v1 with structured technology sections (languages, frameworks, services, tools) and adds project metadata.

```yaml
$schema: https://techsheet.org/spec/v2/techsheet.json
```

### Previous Versions

- [TechSheet v1 (legacy)](v1/techsheet.md) -- the original `common-deps` schema, focused on build-tool
  plugins and raw dependency lists. Still accepted but no longer recommended for new projects.
