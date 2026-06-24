---
title: ASP.NET Core
aliases:
  - /framework/asp-net-core
bookToC: false
techsheet:
  key: asp-net-core
  type: framework
  category: Application
  languages:
    - csharp
  related:
    - type: language
      key: csharp
      comment: "primary language"
    - type: language
      key: fsharp
      comment: "alternative .NET language"
    - type: framework
      key: spring-boot
      comment: "JVM equivalent, enterprise web framework"
---

**A cross-platform, high-performance web framework for building modern cloud-based applications with .NET.**

ASP.NET Core is an open-source framework developed by Microsoft for building web applications, APIs, and microservices
using [C#](../language/csharp.md) or [F#](../language/fsharp.md) on the .NET runtime. It employs a
middleware
pipeline architecture where each request passes through a configurable chain of components, enabling fine-grained
control
over request processing. The framework supports dependency injection as a first-class concept, model binding, content
negotiation, and both controller-based and minimal API styles. Its Kestrel web server delivers high throughput,
routinely
ranking among the fastest in independent benchmarks like TechEmpower.

The framework serves as the standard choice for web development in the .NET ecosystem, used extensively for enterprise
APIs, real-time applications via SignalR, server-rendered pages with Razor, and interactive frontends with Blazor.
ASP.NET Core runs on Windows, Linux, and macOS, a significant departure from the Windows-only legacy ASP.NET. Since its
initial release in 2016, the framework has converged with the broader .NET platform under unified versioning (.NET 5+),
and recent versions have introduced native AOT compilation support, improved HTTP/3 handling, and rate limiting
middleware.

## Further Information

- [dotnet.microsoft.com/apps/aspnet](https://dotnet.microsoft.com/apps/aspnet)
- [learn.microsoft.com/aspnet/core](https://learn.microsoft.com/en-us/aspnet/core/)
- [Wikipedia](https://en.wikipedia.org/wiki/ASP.NET_Core)
