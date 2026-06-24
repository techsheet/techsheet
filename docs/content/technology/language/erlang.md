---
title: "Erlang"
aliases:
- "/language/erlang"
bookToC: false
techsheet:
  key: "erlang"
  type: "language"
  related:
  - type: "language"
    key: "elixir"
    comment: "BEAM sibling, modern alternative"
  - type: "language"
    key: "haskell"
    comment: "functional programming peer"
---

**A functional, concurrent programming language designed for building massively scalable, fault-tolerant distributed
systems.**

Erlang is a dynamically typed, functional programming language that runs on the BEAM virtual machine. Originally
developed at Ericsson in 1986 for telecommunications infrastructure, it was designed from the ground up for concurrency,
distribution, and fault tolerance. The language uses lightweight processes (not OS threads) that communicate exclusively
through asynchronous message passing, enabling millions of concurrent processes on a single machine. Its "let it crash"
philosophy, combined with supervisor trees and hot code swapping, allows systems to achieve very high availability
without planned downtime.

The language remains foundational in telecommunications, messaging, and real-time systems. Notable production
deployments include WhatsApp's messaging backend, RabbitMQ, and parts of the Ericsson network infrastructure. The OTP (
Open Telecom Platform) framework, bundled with Erlang, provides battle-tested abstractions for building concurrent and
distributed applications, including gen_server, gen_statem, and supervisors. [Elixir](elixir.md), a
more recent language running on the same BEAM virtual machine, has broadened the ecosystem significantly and brought
renewed interest to the platform.

## Further Information

- [erlang.org](https://www.erlang.org/)
- [Erlang/OTP on GitHub](https://github.com/erlang/otp)
- [Wikipedia](https://en.wikipedia.org/wiki/Erlang_(programming_language))
