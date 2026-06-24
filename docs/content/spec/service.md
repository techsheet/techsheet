---
weight: 50
---

# Service

*An external system the application depends on during runtime operation.*

## Examples

PostgreSQL, Redis, Kafka, AWS S3, Cloudflare, Stripe, SAP HANA

## Governance Concerns

Vendor risk, operational resilience, compliance, data residency, availability, cost, lock-in

## Includes

* databases such as PostgreSQL, Oracle Database, and MongoDB
* caches and state stores such as Redis and Memcached
* messaging and streaming systems such as Kafka, RabbitMQ, and NATS
* cloud infrastructure and storage platforms such as AWS S3, Azure Blob Storage, and Google BigQuery
* identity, payment, and communication platforms such as Keycloak, Stripe, Twilio, and Auth0
* runtime infrastructure platforms such as Kubernetes, Consul, and Cloudflare

## Excludes

* build and deployment tooling
* client SDKs and integration libraries
* programming languages and frameworks
* local developer utilities

## Disambiguation

### vs Language

Languages define system logic and syntax. Services provide external runtime capabilities.

* SQL is a Language
* PostgreSQL is a Service

### vs Framework

Frameworks run within applications. Services exist outside the application boundary.

* Spring is a Framework
* Redis is a Service

### vs Tool

Tools support engineering workflows. Services support production runtime operation.

* Jenkins is a Tool
* Kafka is a Service

## Classification Rule

If the running application depends on the technology during production operation, it is a Service.

---
