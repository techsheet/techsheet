---
title: Qt
aliases:
  - /framework/qt
bookToC: false
techsheet:
  key: qt
  type: framework
  category: Application
  languages:
    - cpp
    - python
  related:
    - type: language
      key: cpp
      comment: "primary implementation language"
    - type: language
      key: python
      comment: "widely used via PyQt and PySide bindings"
---

**A comprehensive cross-platform application framework for building graphical user interfaces and system-level software
in [C++](../language/cpp.md).**

Qt is a widget toolkit and application framework that provides a unified API for developing desktop, mobile, and
embedded applications across Windows, macOS, Linux, Android, and iOS. Its core is written
in [C++](../language/cpp.md) and extends the language with a meta-object system that enables signals and slots (a
type-safe callback mechanism), introspection, and property bindings without requiring language modifications. Qt
includes modules for GUI rendering, networking, database access, multimedia, WebEngine integration, 3D graphics, and
concurrent programming. The framework uses its own build system integration (qmake and CMake) and a meta-object
compiler (moc) that preprocesses annotated C++ headers to generate the reflection code that powers its object model.

Beyond its C++ core, Qt provides QML, a declarative language for designing fluid user interfaces that can be scripted
with JavaScript and backed by C++ logic. [Python](../language/python.md) bindings are available through PyQt (
Riverbank Computing) and PySide (the official Qt for Python project), making the framework accessible to a broad
developer base. Qt is used extensively in automotive infotainment systems (via Qt for MCUs and Qt Automotive Suite),
industrial automation, medical devices, and consumer desktop applications such as KDE Plasma, VirtualBox, and the
Autodesk Maya interface. The framework is dual-licensed under the LGPL and a commercial license, and Qt 6 (released
2020) modernized the platform with a reworked graphics abstraction layer (RHI), improved CMake support, and stronger
integration with C++17 and C++20 features.

## Further Information

- [qt.io](https://www.qt.io/)
- [Qt Documentation](https://doc.qt.io/)
- [Wikipedia](https://en.wikipedia.org/wiki/Qt_(software))
