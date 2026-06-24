---
title: "Groovy"
aliases:
- "/language/groovy"
bookToC: false
techsheet:
  key: "groovy"
  type: "language"
  related:
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "language"
    key: "java"
    comment: "JVM sibling, full interop"
  - type: "tool"
    key: "gradle"
    comment: "primary build DSL language"
  - type: "framework"
    key: "spock"
    comment: "Groovy-native testing framework"
---

**A dynamic, optionally typed programming language for the [JVM](../tool/jvm.md) that emphasizes concise syntax
and seamless [Java](java.md) interoperability.**

Groovy is an object-oriented language that compiles to [JVM](../tool/jvm.md) bytecode and interoperates directly
with
[Java](java.md) code and libraries. It supports both static and dynamic typing, closures, operator
overloading, native
syntax for lists and maps, and built-in support for markup languages such as XML and HTML through its builder pattern.
The language follows a philosophy of low ceremony and high productivity, offering features like GStrings (interpolated
strings), AST transformations for compile-time metaprogramming, and a Meta-Object Protocol (MOP) that enables
runtime method dispatch and dynamic method resolution.

The language serves as the foundation for the [Gradle](../tool/gradle.md) build system's DSL and is the
primary language for the [Spock](../framework/spock.md) testing framework. It is widely used for scripting
in CI/CD pipelines (Jenkins Pipeline), build automation, and test automation in JVM-based projects. Groovy also
underpins the Grails web application framework. Since version 3.0, Groovy has added support for lambda syntax
alignment with Java, improved static compilation performance, and compatibility with newer JDK releases, while
version 4.0 moved to the Apache Software Foundation under the `org.apache.groovy` module namespace.

## Further Information

- [groovy-lang.org](https://groovy-lang.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Apache_Groovy)
- [Groovy Documentation](https://groovy-lang.org/documentation.html)
