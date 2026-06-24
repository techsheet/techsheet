---
title: Lua
aliases:
  - /language/lua
bookToC: false
techsheet:
  key: lua
  type: language
  related:
    - type: language
      key: cpp
      comment: "primary host language for embedding"
    - type: language
      key: python
      comment: "alternative embeddable scripting language"
    - type: language
      key: javascript
      comment: "alternative lightweight scripting language"
---

**A lightweight, high-level scripting language designed for embedding in applications.**

Lua is a dynamically typed, garbage-collected language implemented in ANSI C, known for its small footprint, fast
execution, and straightforward C API. Its core data structure is the table, a flexible associative array that serves as
the basis for arrays, records, objects, and modules. Lua supports first-class functions, lexical scoping, closures, and
coroutines, providing expressive power despite a deliberately minimal feature set. The language is designed to be
extended rather than comprehensive, making it one of the most widely embedded scripting languages in production
software.

Lua is the dominant scripting language in the video game industry, used as the embedded extension language in engines
such as CryEngine, Corona SDK, and Defold, as well as in games like World of Warcraft and Roblox. Beyond gaming, it
serves as the configuration and plugin language for tools including Neovim, Nginx (via OpenResty), Redis, and
Wireshark. The LuaJIT just-in-time compiler provides near-native performance for compute-intensive scripting workloads.
Lua 5.4, the current major version, introduced a generational garbage collector and native integer support.

## Further Information

- [lua.org](https://www.lua.org/)
- [LuaJIT](https://luajit.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Lua_(programming_language))
