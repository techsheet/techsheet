---
title: Playwright
aliases:
  - /framework/playwright
bookToC: false
techsheet:
  key: playwright
  type: framework
  category: Testing
  languages:
    - javascript
    - typescript
    - python
    - java
    - csharp
  related:
    - type: tool
      key: nodejs
      comment: "runtime platform for primary bindings"
    - type: language
      key: typescript
      comment: "primary implementation language"
    - type: language
      key: python
      comment: "supported language binding"
---

**A cross-browser end-to-end testing framework designed for reliable automation of modern web applications.**

Playwright is an open-source browser automation library developed by Microsoft that supports Chromium, Firefox, and
WebKit through a single API. It provides auto-waiting mechanisms, network interception, and multi-page/multi-tab
scenarios out of the box, eliminating many of the flakiness issues common in browser-based testing. The framework
operates by communicating with browsers over the Chrome DevTools Protocol (for Chromium) and equivalent proprietary
protocols for Firefox and WebKit, enabling deep control over browser behavior including geolocation, permissions,
and mobile emulation.

The primary bindings target [TypeScript](../language/typescript.md)
and [JavaScript](../language/javascript.md) running on
[Node.js](../tool/nodejs.md), though official libraries also exist for [Python](../language/python.md),
[Java](../language/java.md), and [C#](../language/csharp.md). Playwright ships with a built-in test runner
(Playwright Test), a code generator for recording user interactions, and a trace viewer for post-mortem debugging of
test failures. Since its initial release in 2020, it has become one of the most widely adopted end-to-end testing
frameworks, with features such as component testing, API testing, and visual comparisons added in subsequent releases.

## Further Information

- [playwright.dev](https://playwright.dev/)
- [GitHub](https://github.com/microsoft/playwright)
- [Wikipedia](https://en.wikipedia.org/wiki/Playwright_(software))
