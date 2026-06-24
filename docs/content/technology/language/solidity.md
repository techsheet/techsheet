---
title: Solidity
aliases:
  - /language/solidity
bookToC: false
techsheet:
  key: solidity
  type: language
  related:
    - type: language
      key: javascript
      comment: "primary syntactic influence"
    - type: language
      key: typescript
      comment: "dominant language for dApp frontends and tooling"
---

**A contract-oriented, statically typed programming language designed for implementing smart contracts on the Ethereum
Virtual Machine (EVM).**

Solidity is a curly-bracket language whose syntax draws heavily from [JavaScript](javascript.md), C++,
and Python. It
features a static type system with value types, reference types, and complex user-defined types such as structs and
enums. The language is built around the concept of contracts, analogous to classes in object-oriented languages, which
encapsulate state variables, functions, and modifiers that execute on the EVM. Notable design characteristics include
built-in primitives for handling Ether transfers, cryptographic operations, and cross-contract calls, as well as a
storage model that maps directly to the blockchain's persistent key-value store.

Solidity is the dominant language for smart contract development on Ethereum and all EVM-compatible blockchains,
including Polygon, Arbitrum, Optimism, BNB Chain, and Avalanche. The ecosystem centers on toolchains like Hardhat and
Foundry, with [TypeScript](typescript.md) and [JavaScript](javascript.md) used
extensively for testing, deployment scripts, and
decentralized application (dApp) frontends. Since its initial release in 2015, the language has evolved substantially,
with recent versions introducing user-defined value types, custom errors, transient storage, and improved ABI encoding,
while progressively tightening default safety guarantees such as checked arithmetic overflow since version 0.8.

## Further Information

- [soliditylang.org](https://soliditylang.org/)
- [Solidity Documentation](https://docs.soliditylang.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Solidity)
