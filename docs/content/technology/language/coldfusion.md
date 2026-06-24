---
title: "ColdFusion"
aliases:
- "/language/coldfusion"
bookToC: false
techsheet:
  key: "coldfusion"
  type: "language"
  related:
  - type: "tool"
    key: "jvm"
    comment: "compiles to JVM bytecode since ColdFusion MX"
  - type: "language"
    key: "java"
    comment: "full Java class interoperability"
  - type: "language"
    key: "html"
    comment: "tag-based syntax embedded in HTML"
  - type: "language"
    key: "php"
    comment: "similar server-side web scripting role"
---

**A tag-based and scripting language for rapid web application development, running on the [JVM](../tool/jvm.md)
as part of the Adobe ColdFusion platform.**

ColdFusion Markup Language (CFML) combines an [HTML](html.md)-like tag syntax (`<cfquery>`,
`<cfoutput>`, `<cfloop>`) with a
companion scripting syntax (CFScript) for server-side web development. It is dynamically typed with automatic type
coercion, and provides built-in tags and functions for database queries, PDF generation, email, file operations, and
REST/SOAP web services without requiring external libraries. Since ColdFusion MX (2002), the platform compiles CFML to
[Java](java.md) bytecode and runs on the [JVM](../tool/jvm.md), giving it access to any Java
class or library. Variables are scoped
by context (request, session, application, server), and the language supports components (CFCs) with inheritance and
interfaces for object-oriented development.

Originally created by Allaire in 1995 and now maintained by Adobe, ColdFusion was one of the earliest platforms for
building dynamic web applications and popularized the model of mixing server-side logic with HTML templates. It remains
in use in government, education, and enterprise intranet applications. Lucee, an open-source CFML engine forked from
Railo, provides an alternative runtime with extensions for caching, search, and modern deployment. Adobe ColdFusion
(2023 release) added features for microservice development, performance monitoring, and improved security controls,
while the community-driven CommandBox CLI and ColdBox MVC framework form the primary modern development toolchain.

## Further Information

- [Adobe ColdFusion](https://www.adobe.com/products/coldfusion-family.html)
- [Lucee](https://www.lucee.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/ColdFusion_Markup_Language)
