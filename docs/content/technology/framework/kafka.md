---
title: "Apache Kafka"
aliases:
- "/framework/kafka"
bookToC: false
techsheet:
  key: "kafka"
  type: "framework"
  category: "Data"
  languages:
  - "java"
  - "kotlin"
  - "scala"
  related:
  - type: "language"
    key: "java"
    comment: "primary implementation language"
  - type: "language"
    key: "scala"
    comment: "co-implementation language, widely used in Kafka ecosystem"
  - type: "tool"
    key: "jvm"
    comment: "runtime platform"
  - type: "framework"
    key: "spring-boot"
    comment: "Spring for Apache Kafka integration"
---

**A distributed event streaming platform designed for high-throughput, fault-tolerant, real-time data pipelines and
event-driven architectures.**

Apache Kafka is an open-source distributed event store and stream processing platform, originally developed at LinkedIn
and donated to the Apache Software Foundation in 2011. It is built around an append-only commit log, where producers
publish records to named topics and consumers read them in order, enabling decoupled communication between systems.
Kafka's architecture relies on partitioned, replicated topics distributed across a cluster of brokers, delivering
horizontal scalability, strong durability guarantees, and fault tolerance through configurable replication factors.
Written in [Java](../language/java.md) and [Scala](../language/scala.md), it runs on
the [JVM](../tool/jvm.md) and exposes client libraries for
virtually every major programming language.

The platform is widely adopted for use cases ranging from log aggregation and metrics collection to event sourcing and
change data capture. Kafka Streams and ksqlDB provide native stream processing capabilities, while Kafka Connect offers
a standardized framework for integrating with external data systems such as databases, search indexes, and object
stores. The introduction of KRaft mode (Kafka Raft) has removed the longstanding dependency on Apache ZooKeeper for
metadata management, simplifying deployment and operations. Major cloud providers offer managed Kafka services,
including
Confluent Cloud, Amazon MSK, and Azure Event Hubs.

## Further Information

- [kafka.apache.org](https://kafka.apache.org/)
- [Confluent Developer](https://developer.confluent.io/)
- [Wikipedia](https://en.wikipedia.org/wiki/Apache_Kafka)
