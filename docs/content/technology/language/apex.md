---
title: Apex
aliases:
  - /language/apex
bookToC: false
techsheet:
  key: apex
  type: language
  related:
    - type: language
      key: java
      comment: "syntax and type system modeled after Java"
    - type: language
      key: sql
      comment: "SOQL/SOSL database query integration"
    - type: language
      key: abap
      comment: "analogous vendor-locked enterprise language (SAP)"
---

**A proprietary, strongly typed programming language developed by Salesforce for building business logic on its
multi-tenant cloud platform.**

Apex is a statically typed, object-oriented language with [Java](java.md)-like syntax, designed to
execute in a controlled
multi-tenant environment where governor limits enforce strict resource boundaries on CPU time, heap size, and query
counts. It provides native integration with Salesforce Object Query Language (SOQL) and Salesforce Object Search
Language (SOSL) for database operations, and uses triggers, batch classes, and queueable jobs as its primary execution
models. The language supports inheritance, interfaces, generics, and annotations, but does not permit direct filesystem
or network socket access, reflecting its platform-confined design.

Apex runs exclusively on the Salesforce Platform (formerly Force.com) and is the standard language for implementing
custom business rules, workflow automation, REST and SOAP web services, and Lightning component controllers within
Salesforce orgs. Salesforce has extended the ecosystem with Apex-based frameworks like Enterprise Patterns (fflib) and
introduced platform features such as Apex Flex Queue, platform events, and transaction finalizers. Recent platform
updates have added null-coalescing operators, switch expressions, and improved support for asynchronous processing,
incrementally modernizing the language within its managed runtime.

## Further Information

- [developer.salesforce.com](https://developer.salesforce.com/docs/atlas.en-us.apexcode.meta/apexcode/)
- [Trailhead: Apex Basics](https://trailhead.salesforce.com/content/learn/modules/apex_database)
- [Wikipedia](https://en.wikipedia.org/wiki/Apex_(programming_language))
