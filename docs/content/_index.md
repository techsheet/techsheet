---
layout: landing
---

<div class="landing-hero">
<h1>TechSheet</h1>
<p class="landing-tagline">
An <strong>open standard</strong> and toolchain to report <strong>technical insights</strong> about 
<strong>software projects</strong> in an automated, structured, uniform manner.
</p>
<p>
{{< button href="#for-developers" >}}For Developers{{< /button >}}&nbsp;&nbsp;
{{< button href="#for-architects" >}}For Architects{{< /button >}}&nbsp;&nbsp;
{{< button href="#for-leaders" >}}For Leaders{{< /button >}}
</p>
</div>

{{% columns ratio="3:2" %}}
- ## Know Your Stack, Across Every Project

  TechSheet aims to standardize and streamline **technology reporting** and **governance**. It provides a validated and 
  **machine-readable** data format for describing technologies used in software projects, replacing
  manually maintained spreadsheets and wiki pages with one structured file per project.

  ### Open Specification

  TechSheet is first and foremost an open standard, defined by a **[formal specification](spec/_index.md)** and 
  validated by an explicit **[Schema](spec/v2/techsheet.md)**. Reports can be generated and consumed by any tool. The
  taxonomy is intentionally narrow, focusing on **strategic technology decisions** rather than exhaustive dependency 
  lists, and therefore provides a clear, consistent picture across projects.

  ### Automated Detection

  The [Analyzer](analyzer/_index.md) scans your repository and generates reports automatically. It detects 
  **[47+ languages](/technology/language/)**, **[84+ frameworks](/technology/framework/)**, and 
  **[34+ tools](/technology/tool/)**, including versions where available. Technologies not covered by a detector
  can always be added manually.

  ### Streamlined Analytics

  The [Server](server/_index.md) collects reports from across your organization, providing a **centralized view** of
  technology usage, version drift, and **team ownership**. Spot trends, identify standardization gaps, and make
  **data-driven decisions** about your technology portfolio without manual data gathering.

- ```yaml
  project:
    name: User Management API
    team:
      name: Platform Engineering
  languages:
    - id: language.kotlin
      name: Kotlin
      version: 2.1.0
    - id: language.typescript
      name: TypeScript
      version: "5.8"
  frameworks:
    - id: framework.spring-boot
      name: Spring Boot
      version: 3.4.0
  services:
    - id: service.postgres
      name: PostgreSQL
      version: "16"
  tools:
    - id: tool.gradle
      name: Gradle
      version: "8.7"
  ```
{{% /columns %}}

{{% columns class="landing-cta-columns" %}}
- ## Analyzer

  The **[CLI](analyzer/_index.md#cli)** and **[build tool plugins](analyzer/_index.md#build-tools)**
  automate **technology detection** and reporting, keeping reports accurate and up to date **without manual effort**.

  {{< button href="analyzer/_index.md" >}}Learn more{{< /button >}}

- ## Server

  The **[Server](server/_index.md)** can be used to store, compare and visualize TechSheet data for any
  team or organization size, providing accurate and up-to-date **technology insights** across the **entire portfolio**.

  {{< button href="server/_index.md" >}}Learn more{{< /button >}}

- ## Integrations

  TechSheet integrates well with various third party products like architecture tools, data vizaulizers, wikis and
  others.

  {{< button href="integrations/_index.md" >}}Learn more{{< /button >}}
{{% /columns %}}

---

## For Developers

{{% columns ratio="3:2" %}}
- Run `techsheet analyze` on your repo or CI pipeline to generate a TechSheet report. While `techsheet.yml` is the 
  standard, various data and reporting formate like JSON, HTML and Markdown are supported.

  The [Schema](spec/v2/techsheet.md) gives you validation and editor auto-completion out of the box. For automation, simply run the 
  analyzer in your CI pipeline.

  Curious? Simply run it on any project using the docker image:

  ```bash
  docker run --rm -v "$PWD:/workspace" ghcr.io/techsheet/analyzer
  ```

  Not a docker person? See [installation options](analyzer/_index.md#installation), we have various build tool integrations and precompiled binaries 
  for all major platforms.

- {{< image src="../assets/images/analyzer-cli-report.png" alt="Screenshot of an Analyzer CLI Report" title="Analyzer CLI Report" loading="lazy" >}}
{{% /columns %}}

---

## For Architects
Compare technology usage across projects in a consistent format. Spot version drift, find standardization
gaps, and feed the data into tech radars or architecture reviews.

---

## For Leaders
See which teams use what, where upgrade or compliance gaps exist, and how the technology portfolio evolves
over time -- without asking every team to fill in a spreadsheet.
