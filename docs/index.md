---
title: "Home"
hide:
  - navigation
---

# TechSheet

TechSheet is an open standard and toolchain to report technical insights about software projects in an automated,
structured, and uniform manner.

A `techsheet.yml` describes a software project through structured metadata and classified technologies in a
machine-readable format.

The standard is designed for:

* automated technology detection
* governance and compliance
* portfolio analysis
* architecture visibility
* standardization
* operational reporting
* policy enforcement

TechSheet uses a deterministic classification model. Each detected technology belongs to exactly one Technology type.

The taxonomy is intentionally compact. It prioritizes consistency, automation, and governance relevance over exhaustive
technical decomposition.

---

## Project

The project section of a techsheet contains metadata about the project, i.e. its name, description or VCS url. While 
it is optional, it's highly recommended for inventory, analysis and correlation.

## Technology

A Technology is a classified technical component detected within a software project.

TechSheet currently defines four Technology types as specific sections with dedicated structure:

* [Language](./language.md)
* [Framework](./framework.md)
* [Tool](./tool.md)
* [Service](./service.md)

Each Technology type represents a distinct operational role within the software lifecycle or runtime architecture.

## Classification Principles

### Prefer Strategic Technologies

Prioritize technologies that affect architecture, operations, governance, hiring, compliance, or vendor exposure.

Avoid exhaustive dependency inventorying.

### Avoid Redundant Detection

Prefer technologies that represent distinct architectural or operational decisions.

Avoid duplicate reporting of tightly coupled implementation details.

### Classify by Primary Role

Classification is based on the technology’s primary role within the software lifecycle or runtime architecture.
