---
title: TestNG
aliases:
  - /framework/testng
bookToC: false
techsheet:
  key: testng
  type: framework
  category: Testing
  languages:
    - java
  related:
    - type: language
      key: java
      comment: "primary language"
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: framework
      key: junit
      comment: "direct alternative for JVM testing"
    - type: framework
      key: mockito
      comment: "commonly paired mocking framework"
---

**A flexible testing framework for [Java](../language/java.md) inspired by JUnit and NUnit, designed to cover all
categories of tests from unit to integration and end-to-end.**

TestNG (Test Next Generation) is an annotation-driven testing framework that runs on the [JVM](../tool/jvm.md) and
was created by Cedric Beust in 2004 to address perceived limitations in [JUnit](junit.md). Its core
design centers on an XML-based configuration model (`testng.xml`) that provides fine-grained control over test suite
composition, group-based execution, and inter-test dependencies. The framework supports features such as `@DataProvider`
for data-driven testing, `@Factory` for dynamic test instance creation, dependent methods via `@Test(dependsOnMethods)`,
parallel execution at the method, class, or suite level, and flexible test lifecycle management through `@BeforeSuite`,
`@BeforeTest`, `@BeforeClass`, and `@BeforeMethod` annotations.

TestNG is widely used in enterprise Java projects, particularly for integration and end-to-end testing scenarios where
test ordering and grouping are important. It integrates with all major build tools
including [Maven](../tool/maven.md) and [Gradle](../tool/gradle.md), and is commonly combined
with [Mockito](mockito.md) for mocking and Selenium for browser automation. The framework generates
detailed HTML and XML reports by default and supports custom reporters through its listener and reporter interfaces.
While [JUnit 5](junit.md) has closed many of the feature gaps that originally motivated TestNG's
creation, TestNG retains a significant user base in large-scale test automation suites that rely on its suite-level
configuration, built-in dependency management, and native support for parameterized test factories.

## Further Information

- [testng.org](https://testng.org/)
- [TestNG Documentation](https://testng.org/testng-documentation.html)
- [Wikipedia](https://en.wikipedia.org/wiki/TestNG)
