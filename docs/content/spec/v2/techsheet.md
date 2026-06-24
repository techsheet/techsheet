---
title: Schema V2 (current)
weight: 60
aliases:
  - /schema/v2/techsheet
---

# TechSheet v2

**Title:** TechSheet v2

|                           |             |
| ------------------------- | ----------- |
| **Type**                  | `object`    |
| **Required**              | No          |
| **Additional properties** | Not allowed |

**Description:** Open standard for structured, automated reporting of technical insights about software projects. Describes technologies, ownership, and operational characteristics in a machine-readable format.

**Example:**

```yaml
$schema: https://techsheet.org/spec/v2/techsheet.json
project:
  id: ce770f52-e33b-47ba-a3c1-2198568348b9
  name: User Management API
  description: REST API for managing user accounts and authentication.
  team:
    id: a1b2c3d4-e5f6-7890-abcd-ef1234567890
    name: Platform Engineering
  urls:
  - name: Repository
    url: https://github.com/example/user-mgmt-api
languages:
- id: language.kotlin
  name: Kotlin
  url: https://techsheet.org/language/kotlin
  version: 2.1.0
- id: language.typescript
  name: TypeScript
  url: https://techsheet.org/language/typescript
  version: '5.8'
frameworks:
- id: framework.spring-boot
  name: Spring Boot
  category: Application
  version: 3.4.0
- id: framework.angular
  name: Angular
  category: Frontend
  version: '19'
services:
- id: service.postgres
  name: PostgreSQL
  category: Database
  version: '16'
tools:
- id: tool.gradle
  name: Gradle
  category: Build
  flavor: Kotlin DSL
  version: '8.7'

```

| Property                     | Pattern | Type   | Deprecated | Definition         | Title/Description |
| ---------------------------- | ------- | ------ | ---------- | ------------------ | ----------------- |
| - [$schema](#schema )        | No      | string | No         | -                  | -                 |
| - [project](#project )       | No      | object | No         | In #/$defs/project | Project           |
| - [languages](#languages )   | No      | array  | No         | -                  | -                 |
| - [frameworks](#frameworks ) | No      | array  | No         | -                  | -                 |
| - [services](#services )     | No      | array  | No         | -                  | -                 |
| - [tools](#tools )           | No      | array  | No         | -                  | -                 |

## <a name="schema"></a>Property `TechSheet v2 > $schema`

|              |          |
| ------------ | -------- |
| **Type**     | `string` |
| **Required** | No       |
| **Format**   | `uri`    |

## <a name="project"></a>Property `TechSheet v2 > project`

**Title:** Project

|                           |                 |
| ------------------------- | --------------- |
| **Type**                  | `object`        |
| **Required**              | No              |
| **Additional properties** | Not allowed     |
| **Defined in**            | #/$defs/project |

**Description:** Identifying and organizational metadata about the software system this TechSheet represents. Used for governance, ownership mapping, portfolio analysis, and cross-system correlation. Optional.

**Example:**

```yaml
id: ce770f52-e33b-47ba-a3c1-2198568348b9
name: User Management API
description: REST API for managing user accounts and authentication.
team:
  id: a1b2c3d4-e5f6-7890-abcd-ef1234567890
  name: Platform Engineering
urls:
- name: Repository
  url: https://github.com/example/user-mgmt-api

```

| Property                               | Pattern | Type   | Deprecated | Definition          | Title/Description                                                                                                                                                                                                                                                         |
| -------------------------------------- | ------- | ------ | ---------- | ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| + [id](#project_id )                   | No      | string | No         | In #/$defs/uniqueId | Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies. |
| + [name](#project_name )               | No      | string | No         | -                   | Human-readable name of the software system.                                                                                                                                                                                                                               |
| - [description](#project_description ) | No      | string | No         | -                   | A brief, human-readable description of what this software system does.                                                                                                                                                                                                    |
| - [team](#project_team )               | No      | object | No         | In #/$defs/team     | The team responsible for this project.                                                                                                                                                                                                                                    |
| - [urls](#project_urls )               | No      | array  | No         | -                   | Named URLs associated with this project, such as its repository, documentation, wiki, or issue tracker.                                                                                                                                                                   |
| - [server](#project_server )           | No      | object | No         | In #/$defs/server   | The TechSheet server this sheet is uploaded to.                                                                                                                                                                                                                           |

### <a name="project_id"></a>Property `TechSheet v2 > project > id`

|                |                  |
| -------------- | ---------------- |
| **Type**       | `string`         |
| **Required**   | Yes              |
| **Defined in** | #/$defs/uniqueId |

**Description:** Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies.

**Examples:**

```yaml
ce770f52-e33b-47ba-a3c1-2198568348b9
```

```yaml
43398457339487
```

```yaml
language.kotlin
```

```yaml
framework.spring-boot
```

```yaml
workspace.projects.cms
```

| Restrictions                      |                                                                                                                                         |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------- |
| **Min length**                    | 1                                                                                                                                       |
| **Max length**                    | 50                                                                                                                                      |
| **Must match regular expression** | ```^[a-z0-9._-]+$``` [Test](https://regex101.com/?regex=%5E%5Ba-z0-9._-%5D%2B%24&testString=%22ce770f52-e33b-47ba-a3c1-2198568348b9%22) |

### <a name="project_name"></a>Property `TechSheet v2 > project > name`

|              |          |
| ------------ | -------- |
| **Type**     | `string` |
| **Required** | Yes      |

**Description:** Human-readable name of the software system.

**Examples:**

```yaml
User Management API
```

```yaml
Corporate Website CMS
```

```yaml
Payment Processing Service
```

| Restrictions                      |                                                                                                                                    |
| --------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------- |
| **Min length**                    | 2                                                                                                                                  |
| **Max length**                    | 200                                                                                                                                |
| **Must match regular expression** | ```^[a-zA-Z0-9.,_ -]+$``` [Test](https://regex101.com/?regex=%5E%5Ba-zA-Z0-9.%2C_+-%5D%2B%24&testString=%22User+Management+API%22) |

### <a name="project_description"></a>Property `TechSheet v2 > project > description`

|              |          |
| ------------ | -------- |
| **Type**     | `string` |
| **Required** | No       |

**Description:** A brief, human-readable description of what this software system does.

**Examples:**

```yaml
REST API for managing user accounts and authentication.
```

```yaml
Internal CMS powering the company website and blog.
```

| Restrictions   |     |
| -------------- | --- |
| **Min length** | 1   |
| **Max length** | 500 |

### <a name="project_team"></a>Property `TechSheet v2 > project > team`

|                           |              |
| ------------------------- | ------------ |
| **Type**                  | `object`     |
| **Required**              | No           |
| **Additional properties** | Not allowed  |
| **Defined in**            | #/$defs/team |

**Description:** The team responsible for this project.

| Property                      | Pattern | Type   | Deprecated | Definition                 | Title/Description                                                                                                                                                                                                                                                         |
| ----------------------------- | ------- | ------ | ---------- | -------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| + [id](#project_team_id )     | No      | string | No         | Same as [id](#project_id ) | Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies. |
| + [name](#project_team_name ) | No      | string | No         | -                          | Human-readable name of the team.                                                                                                                                                                                                                                          |

#### <a name="project_team_id"></a>Property `TechSheet v2 > project > team > id`

|                        |                   |
| ---------------------- | ----------------- |
| **Type**               | `string`          |
| **Required**           | Yes               |
| **Same definition as** | [id](#project_id) |

**Description:** Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies.

#### <a name="project_team_name"></a>Property `TechSheet v2 > project > team > name`

|              |          |
| ------------ | -------- |
| **Type**     | `string` |
| **Required** | Yes      |

**Description:** Human-readable name of the team.

**Examples:**

```yaml
Platform Engineering
```

```yaml
Frontend Guild
```

```yaml
Data & Analytics
```

| Restrictions   |     |
| -------------- | --- |
| **Min length** | 1   |
| **Max length** | 200 |

### <a name="project_urls"></a>Property `TechSheet v2 > project > urls`

|              |         |
| ------------ | ------- |
| **Type**     | `array` |
| **Required** | No      |

**Description:** Named URLs associated with this project, such as its repository, documentation, wiki, or issue tracker.

| Each item of this array must be   | Description                                                                  |
| --------------------------------- | ---------------------------------------------------------------------------- |
| [projectUrl](#project_urls_items) | Any URL related to the project, i.e. VCS host, Wiki, Website, Issue-Tracker. |

#### <a name="project_urls_items"></a>TechSheet v2 > project > urls > projectUrl

|                           |                    |
| ------------------------- | ------------------ |
| **Type**                  | `object`           |
| **Required**              | No                 |
| **Additional properties** | Not allowed        |
| **Defined in**            | #/$defs/projectUrl |

**Description:** Any URL related to the project, i.e. VCS host, Wiki, Website, Issue-Tracker.

**Examples:**

```yaml
name: Repository
url: https://github.com/example/my-project

```

```yaml
name: Wiki
url: https://wiki.example.com/my-project

```

```yaml
name: Issue Tracker
url: https://jira.example.com/projects/MP

```

| Property                            | Pattern | Type   | Deprecated | Definition | Title/Description |
| ----------------------------------- | ------- | ------ | ---------- | ---------- | ----------------- |
| + [name](#project_urls_items_name ) | No      | string | No         | -          | -                 |
| + [url](#project_urls_items_url )   | No      | string | No         | -          | -                 |

##### <a name="project_urls_items_name"></a>Property `TechSheet v2 > project > urls > urls items > name`

|              |          |
| ------------ | -------- |
| **Type**     | `string` |
| **Required** | Yes      |

##### <a name="project_urls_items_url"></a>Property `TechSheet v2 > project > urls > urls items > url`

|              |          |
| ------------ | -------- |
| **Type**     | `string` |
| **Required** | Yes      |
| **Format**   | `uri`    |

### <a name="project_server"></a>Property `TechSheet v2 > project > server`

|                           |                |
| ------------------------- | -------------- |
| **Type**                  | `object`       |
| **Required**              | No             |
| **Additional properties** | Not allowed    |
| **Defined in**            | #/$defs/server |

**Description:** The TechSheet server this sheet is uploaded to.

| Property                      | Pattern | Type   | Deprecated | Definition | Title/Description |
| ----------------------------- | ------- | ------ | ---------- | ---------- | ----------------- |
| + [url](#project_server_url ) | No      | string | No         | -          | -                 |

#### <a name="project_server_url"></a>Property `TechSheet v2 > project > server > url`

|              |          |
| ------------ | -------- |
| **Type**     | `string` |
| **Required** | Yes      |
| **Format**   | `uri`    |

## <a name="languages"></a>Property `TechSheet v2 > languages`

|              |         |
| ------------ | ------- |
| **Type**     | `array` |
| **Required** | No      |

**Example:**

```yaml
[{'id': 'language.kotlin', 'name': 'Kotlin', 'url': 'https://techsheet.org/language/kotlin', 'version': '2.1.0'}, {'id': 'language.sql', 'name': 'SQL', 'url': 'https://techsheet.org/language/sql'}]
```

| Each item of this array must be | Description                                                                                    |
| ------------------------------- | ---------------------------------------------------------------------------------------------- |
| [Language](#languages_items)    | A formal language used to express code, queries, configuration, templates, or structured data. |

### <a name="languages_items"></a>TechSheet v2 > languages > Language

**Title:** Language

|                           |                  |
| ------------------------- | ---------------- |
| **Type**                  | `object`         |
| **Required**              | No               |
| **Additional properties** | Not allowed      |
| **Defined in**            | #/$defs/language |

**Description:** A formal language used to express code, queries, configuration, templates, or structured data.

| Property                               | Pattern | Type   | Deprecated | Definition                   | Title/Description                                                                                                                                                                                                                                                         |
| -------------------------------------- | ------- | ------ | ---------- | ---------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| + [id](#languages_items_id )           | No      | string | No         | Same as [id](#project_id )   | Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies. |
| + [name](#languages_items_name )       | No      | string | No         | In #/$defs/technologyName    | Human-readable name of the technology.                                                                                                                                                                                                                                    |
| - [url](#languages_items_url )         | No      | string | No         | In #/$defs/technologyUrl     | Optional URL of a specific technology. When dereferenced, it should provide a meaningful description of the technology. For detected technologies, this is always https://techsheet.org/${id}                                                                             |
| - [version](#languages_items_version ) | No      | string | No         | In #/$defs/technologyVersion | Optional version of the technology. This is likely a semver or calver and depends on detection type and availability.                                                                                                                                                     |

#### <a name="languages_items_id"></a>Property `TechSheet v2 > languages > Language > id`

|                        |                   |
| ---------------------- | ----------------- |
| **Type**               | `string`          |
| **Required**           | Yes               |
| **Same definition as** | [id](#project_id) |

**Description:** Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies.

#### <a name="languages_items_name"></a>Property `TechSheet v2 > languages > Language > name`

|                |                        |
| -------------- | ---------------------- |
| **Type**       | `string`               |
| **Required**   | Yes                    |
| **Defined in** | #/$defs/technologyName |

**Description:** Human-readable name of the technology.

**Examples:**

```yaml
Java
```

```yaml
C#
```

```yaml
Spring Boot
```

```yaml
SQL Server
```

```yaml
Apache Webserver
```

```yaml
Internal Design Framework
```

| Restrictions   |     |
| -------------- | --- |
| **Min length** | 1   |
| **Max length** | 100 |

#### <a name="languages_items_url"></a>Property `TechSheet v2 > languages > Language > url`

|                |                       |
| -------------- | --------------------- |
| **Type**       | `string`              |
| **Required**   | No                    |
| **Defined in** | #/$defs/technologyUrl |

**Description:** Optional URL of a specific technology. When dereferenced, it should provide a meaningful description of the technology. For detected technologies, this is always https://techsheet.org/${id}

**Examples:**

```yaml
https://techsheet.org/language/html
```

```yaml
https://techsheet.org/language/cpp
```

```yaml
https://techsheet.org/framework/spring-boot
```

```yaml
https://de.wikipedia.org/wiki/Brainfuck
```

```yaml
https://example.com/our-own-secret-tech
```

#### <a name="languages_items_version"></a>Property `TechSheet v2 > languages > Language > version`

|                |                           |
| -------------- | ------------------------- |
| **Type**       | `string`                  |
| **Required**   | No                        |
| **Defined in** | #/$defs/technologyVersion |

**Description:** Optional version of the technology. This is likely a semver or calver and depends on detection type and availability.

**Examples:**

```yaml
1.3.8
```

```yaml
4.0.0-SNAPSHOT
```

```yaml
19
```

```yaml
2026.3
```

## <a name="frameworks"></a>Property `TechSheet v2 > frameworks`

|              |         |
| ------------ | ------- |
| **Type**     | `array` |
| **Required** | No      |

**Example:**

```yaml
[{'id': 'framework.spring-boot', 'name': 'Spring Boot', 'category': 'Application', 'version': '3.4.0'}, {'id': 'framework.junit', 'name': 'JUnit', 'category': 'Testing', 'version': '5.11'}]
```

| Each item of this array must be | Description                                                                                                   |
| ------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| [Framework](#frameworks_items)  | A foundational technology defining application structure, development patterns, or architectural conventions. |

### <a name="frameworks_items"></a>TechSheet v2 > frameworks > Framework

**Title:** Framework

|                           |                   |
| ------------------------- | ----------------- |
| **Type**                  | `object`          |
| **Required**              | No                |
| **Additional properties** | Not allowed       |
| **Defined in**            | #/$defs/framework |

**Description:** A foundational technology defining application structure, development patterns, or architectural conventions.

| Property                                  | Pattern | Type   | Deprecated | Definition                                   | Title/Description                                                                                                                                                                                                                                                         |
| ----------------------------------------- | ------- | ------ | ---------- | -------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| + [id](#frameworks_items_id )             | No      | string | No         | Same as [id](#project_id )                   | Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies. |
| + [name](#frameworks_items_name )         | No      | string | No         | Same as [name](#languages_items_name )       | Human-readable name of the technology.                                                                                                                                                                                                                                    |
| - [url](#frameworks_items_url )           | No      | string | No         | Same as [url](#languages_items_url )         | Optional URL of a specific technology. When dereferenced, it should provide a meaningful description of the technology. For detected technologies, this is always https://techsheet.org/${id}                                                                             |
| - [version](#frameworks_items_version )   | No      | string | No         | Same as [version](#languages_items_version ) | Optional version of the technology. This is likely a semver or calver and depends on detection type and availability.                                                                                                                                                     |
| - [category](#frameworks_items_category ) | No      | string | No         | In #/$defs/technologyCategory                | Optional, human-readable category for a given technology. This can be any arbitrary string, as long as it matches the pattern.                                                                                                                                            |

#### <a name="frameworks_items_id"></a>Property `TechSheet v2 > frameworks > Framework > id`

|                        |                   |
| ---------------------- | ----------------- |
| **Type**               | `string`          |
| **Required**           | Yes               |
| **Same definition as** | [id](#project_id) |

**Description:** Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies.

#### <a name="frameworks_items_name"></a>Property `TechSheet v2 > frameworks > Framework > name`

|                        |                               |
| ---------------------- | ----------------------------- |
| **Type**               | `string`                      |
| **Required**           | Yes                           |
| **Same definition as** | [name](#languages_items_name) |

**Description:** Human-readable name of the technology.

#### <a name="frameworks_items_url"></a>Property `TechSheet v2 > frameworks > Framework > url`

|                        |                             |
| ---------------------- | --------------------------- |
| **Type**               | `string`                    |
| **Required**           | No                          |
| **Same definition as** | [url](#languages_items_url) |

**Description:** Optional URL of a specific technology. When dereferenced, it should provide a meaningful description of the technology. For detected technologies, this is always https://techsheet.org/${id}

#### <a name="frameworks_items_version"></a>Property `TechSheet v2 > frameworks > Framework > version`

|                        |                                     |
| ---------------------- | ----------------------------------- |
| **Type**               | `string`                            |
| **Required**           | No                                  |
| **Same definition as** | [version](#languages_items_version) |

**Description:** Optional version of the technology. This is likely a semver or calver and depends on detection type and availability.

#### <a name="frameworks_items_category"></a>Property `TechSheet v2 > frameworks > Framework > category`

|                |                            |
| -------------- | -------------------------- |
| **Type**       | `string`                   |
| **Required**   | No                         |
| **Defined in** | #/$defs/technologyCategory |

**Description:** Optional, human-readable category for a given technology. This can be any arbitrary string, as long as it matches the pattern.

**Examples:**

```yaml
Application
```

```yaml
CMS
```

```yaml
Security
```

```yaml
Testing
```

```yaml
Build
```

```yaml
AI
```

| Restrictions                      |                                                                                                                |
| --------------------------------- | -------------------------------------------------------------------------------------------------------------- |
| **Min length**                    | 1                                                                                                              |
| **Must match regular expression** | ```^[a-zA-Z _-]+$``` [Test](https://regex101.com/?regex=%5E%5Ba-zA-Z+_-%5D%2B%24&testString=%22Application%22) |

## <a name="services"></a>Property `TechSheet v2 > services`

|              |         |
| ------------ | ------- |
| **Type**     | `array` |
| **Required** | No      |

**Example:**

```yaml
[{'id': 'service.postgres', 'name': 'PostgreSQL', 'category': 'Database', 'version': '16'}, {'id': 'service.redis', 'name': 'Redis', 'category': 'Cache', 'version': '7.4'}]
```

| Each item of this array must be | Description                                                             |
| ------------------------------- | ----------------------------------------------------------------------- |
| [Service](#services_items)      | An external system the application depends on during runtime operation. |

### <a name="services_items"></a>TechSheet v2 > services > Service

**Title:** Service

|                           |                 |
| ------------------------- | --------------- |
| **Type**                  | `object`        |
| **Required**              | No              |
| **Additional properties** | Not allowed     |
| **Defined in**            | #/$defs/service |

**Description:** An external system the application depends on during runtime operation.

| Property                                | Pattern | Type   | Deprecated | Definition                                      | Title/Description                                                                                                                                                                                                                                                         |
| --------------------------------------- | ------- | ------ | ---------- | ----------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| + [id](#services_items_id )             | No      | string | No         | Same as [id](#project_id )                      | Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies. |
| + [name](#services_items_name )         | No      | string | No         | Same as [name](#languages_items_name )          | Human-readable name of the technology.                                                                                                                                                                                                                                    |
| - [url](#services_items_url )           | No      | string | No         | Same as [url](#languages_items_url )            | Optional URL of a specific technology. When dereferenced, it should provide a meaningful description of the technology. For detected technologies, this is always https://techsheet.org/${id}                                                                             |
| - [version](#services_items_version )   | No      | string | No         | Same as [version](#languages_items_version )    | Optional version of the technology. This is likely a semver or calver and depends on detection type and availability.                                                                                                                                                     |
| - [category](#services_items_category ) | No      | string | No         | Same as [category](#frameworks_items_category ) | Optional, human-readable category for a given technology. This can be any arbitrary string, as long as it matches the pattern.                                                                                                                                            |

#### <a name="services_items_id"></a>Property `TechSheet v2 > services > Service > id`

|                        |                   |
| ---------------------- | ----------------- |
| **Type**               | `string`          |
| **Required**           | Yes               |
| **Same definition as** | [id](#project_id) |

**Description:** Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies.

#### <a name="services_items_name"></a>Property `TechSheet v2 > services > Service > name`

|                        |                               |
| ---------------------- | ----------------------------- |
| **Type**               | `string`                      |
| **Required**           | Yes                           |
| **Same definition as** | [name](#languages_items_name) |

**Description:** Human-readable name of the technology.

#### <a name="services_items_url"></a>Property `TechSheet v2 > services > Service > url`

|                        |                             |
| ---------------------- | --------------------------- |
| **Type**               | `string`                    |
| **Required**           | No                          |
| **Same definition as** | [url](#languages_items_url) |

**Description:** Optional URL of a specific technology. When dereferenced, it should provide a meaningful description of the technology. For detected technologies, this is always https://techsheet.org/${id}

#### <a name="services_items_version"></a>Property `TechSheet v2 > services > Service > version`

|                        |                                     |
| ---------------------- | ----------------------------------- |
| **Type**               | `string`                            |
| **Required**           | No                                  |
| **Same definition as** | [version](#languages_items_version) |

**Description:** Optional version of the technology. This is likely a semver or calver and depends on detection type and availability.

#### <a name="services_items_category"></a>Property `TechSheet v2 > services > Service > category`

|                        |                                        |
| ---------------------- | -------------------------------------- |
| **Type**               | `string`                               |
| **Required**           | No                                     |
| **Same definition as** | [category](#frameworks_items_category) |

**Description:** Optional, human-readable category for a given technology. This can be any arbitrary string, as long as it matches the pattern.

## <a name="tools"></a>Property `TechSheet v2 > tools`

|              |         |
| ------------ | ------- |
| **Type**     | `array` |
| **Required** | No      |

**Example:**

```yaml
[{'id': 'tool.gradle', 'name': 'Gradle', 'category': 'Build', 'flavor': 'Kotlin DSL', 'version': '8.7'}, {'id': 'tool.docker', 'name': 'Docker', 'category': 'Container', 'version': '27.5'}]
```

| Each item of this array must be | Description                                                                                                  |
| ------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| [Tool](#tools_items)            | Software used during the engineering lifecycle to build, test, analyze, package, deploy, or operate systems. |

### <a name="tools_items"></a>TechSheet v2 > tools > Tool

**Title:** Tool

|                           |              |
| ------------------------- | ------------ |
| **Type**                  | `object`     |
| **Required**              | No           |
| **Additional properties** | Not allowed  |
| **Defined in**            | #/$defs/tool |

**Description:** Software used during the engineering lifecycle to build, test, analyze, package, deploy, or operate systems.

| Property                             | Pattern | Type   | Deprecated | Definition                                      | Title/Description                                                                                                                                                                                                                                                         |
| ------------------------------------ | ------- | ------ | ---------- | ----------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| + [id](#tools_items_id )             | No      | string | No         | Same as [id](#project_id )                      | Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies. |
| + [name](#tools_items_name )         | No      | string | No         | Same as [name](#languages_items_name )          | Human-readable name of the technology.                                                                                                                                                                                                                                    |
| - [url](#tools_items_url )           | No      | string | No         | Same as [url](#languages_items_url )            | Optional URL of a specific technology. When dereferenced, it should provide a meaningful description of the technology. For detected technologies, this is always https://techsheet.org/${id}                                                                             |
| - [version](#tools_items_version )   | No      | string | No         | Same as [version](#languages_items_version )    | Optional version of the technology. This is likely a semver or calver and depends on detection type and availability.                                                                                                                                                     |
| - [category](#tools_items_category ) | No      | string | No         | Same as [category](#frameworks_items_category ) | Optional, human-readable category for a given technology. This can be any arbitrary string, as long as it matches the pattern.                                                                                                                                            |
| - [flavor](#tools_items_flavor )     | No      | string | No         | In #/$defs/technologyFlavor                     | Optional, human-readable flavor for a given technology.                                                                                                                                                                                                                   |

#### <a name="tools_items_id"></a>Property `TechSheet v2 > tools > Tool > id`

|                        |                   |
| ---------------------- | ----------------- |
| **Type**               | `string`          |
| **Required**           | Yes               |
| **Same definition as** | [id](#project_id) |

**Description:** Globally unique identifier for a project, technology, or team. Must not collide with any other ID across all TechSheets. A v4 UUID is recommended for project and team IDs; a dotted-slug convention (e.g. 'language.kotlin') is recommended for well-known technologies.

#### <a name="tools_items_name"></a>Property `TechSheet v2 > tools > Tool > name`

|                        |                               |
| ---------------------- | ----------------------------- |
| **Type**               | `string`                      |
| **Required**           | Yes                           |
| **Same definition as** | [name](#languages_items_name) |

**Description:** Human-readable name of the technology.

#### <a name="tools_items_url"></a>Property `TechSheet v2 > tools > Tool > url`

|                        |                             |
| ---------------------- | --------------------------- |
| **Type**               | `string`                    |
| **Required**           | No                          |
| **Same definition as** | [url](#languages_items_url) |

**Description:** Optional URL of a specific technology. When dereferenced, it should provide a meaningful description of the technology. For detected technologies, this is always https://techsheet.org/${id}

#### <a name="tools_items_version"></a>Property `TechSheet v2 > tools > Tool > version`

|                        |                                     |
| ---------------------- | ----------------------------------- |
| **Type**               | `string`                            |
| **Required**           | No                                  |
| **Same definition as** | [version](#languages_items_version) |

**Description:** Optional version of the technology. This is likely a semver or calver and depends on detection type and availability.

#### <a name="tools_items_category"></a>Property `TechSheet v2 > tools > Tool > category`

|                        |                                        |
| ---------------------- | -------------------------------------- |
| **Type**               | `string`                               |
| **Required**           | No                                     |
| **Same definition as** | [category](#frameworks_items_category) |

**Description:** Optional, human-readable category for a given technology. This can be any arbitrary string, as long as it matches the pattern.

#### <a name="tools_items_flavor"></a>Property `TechSheet v2 > tools > Tool > flavor`

|                |                          |
| -------------- | ------------------------ |
| **Type**       | `string`                 |
| **Required**   | No                       |
| **Defined in** | #/$defs/technologyFlavor |

**Description:** Optional, human-readable flavor for a given technology.

**Examples:**

```yaml
Kotlin DSL
```

```yaml
5+ version
```

```yaml
XY Variant
```

| Restrictions   |     |
| -------------- | --- |
| **Min length** | 1   |
| **Max length** | 100 |

----------------------------------------------------------------------------------------------------------------------------
Generated using [json-schema-for-humans](https://github.com/coveooss/json-schema-for-humans) on 2026-05-13 at 10:41:28 +0200
