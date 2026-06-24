Write documentation content for **$ARGUMENTS** on the TechSheet technology reference site. Look up the matching enum value in `org.techsheet.analyzer.domain` to determine the type (language, tool, framework, service) and key. Then find the corresponding page under `docs/content/technology/{type}/{key}.md` and:

1. Add a `related` list to the `techsheet:` block in the front matter. Each entry is an object with `type`, `key`, and `comment` fields. Only reference technologies that exist as enum values in the domain model. Be selective: 2-5 entries, only strong and obvious relationships (same runtime/platform, direct alternatives, or direct complements). The `comment` is a short phrase explaining the relationship.
2. Fill in the body content.

Follow this exact structure for the body:

1. A **bold tagline** (single sentence) that captures what the technology is and its primary purpose.
2. Two paragraphs of formal, information-dense description:
   - First paragraph: what it is, its type system or core mechanism, design philosophy, and distinguishing technical characteristics.
   - Second paragraph: where it is used in practice, notable frameworks/ecosystems, and any significant recent evolution.
3. A `## Further Information` section with 2-4 links: the official site, and Wikipedia. Add one more if there is a widely recognized community resource.

**Style rules:**
- Write in clear, natural, and information-dense language. No dashes as sentence starters. No bullet points in the description.
- Formal and specific tone. State facts, not opinions.
- Do not start sentences with the technology name more than once.
- Where another technology has a page on this site, link it as `[Name](/technology/{type}/{key})`. Only link technologies that exist as enum values in TechSheet (common languages, frameworks, and tools). Do not over-link.
- Output only the markdown body (no front matter). Write it directly into the file.

**Reference examples:**

Java (`docs/content/technology/language/java.md`):

Front matter `techsheet:` block with related:
```yaml
techsheet:
  key: java
  type: language
  related:
    - type: tool
      key: jvm
      comment: "runtime platform"
    - type: language
      key: kotlin
      comment: "JVM sibling, full interop"
    - type: language
      key: scala
      comment: "JVM sibling, functional alternative"
    - type: language
      key: groovy
      comment: "JVM sibling, dynamic scripting"
```

Body:
```
**A widely-used, class-based, object-oriented programming language designed for portability across platforms.**

Java is a statically typed, compiled language that runs on the [Java Virtual Machine (JVM)](/technology/tool/jvm). Its "write once, run anywhere"
philosophy and automatic memory management made it one of the most popular languages for enterprise software development.
Java features a strong type system, checked exceptions, and a mature ecosystem of libraries and frameworks.

Java is the foundation of the Android platform and dominates enterprise backend development through frameworks like
Spring and Jakarta EE. Modern Java (17+) has introduced records, sealed classes, pattern matching, virtual threads
(Project Loom), and a foreign function interface (Project Panama), significantly modernizing the language.

## Further Information

- [java.com](https://www.java.com/)
- [dev.java](https://dev.java/)
- [Wikipedia](https://en.wikipedia.org/wiki/Java_(programming_language))
```

Scala (`docs/content/technology/language/scala.md`):
```
**A general-purpose programming language that combines object-oriented and functional programming on the [JVM](/technology/tool/jvm).**

Scala (Scalable Language) is a statically typed programming language designed to concisely express common patterns in a
type-safe way. It runs on the [Java Virtual Machine](/technology/tool/jvm) and is fully interoperable with [Java](/technology/language/java). Scala's type system supports
type inference, higher-kinded types, algebraic data types, and pattern matching, making it well-suited for both
application development and library design.

Scala is widely used in data engineering (Apache Spark, Apache Kafka), backend services (Play Framework, Akka/Pekko),
and distributed systems. Scala 3 (Dotty) introduced significant language improvements including a simplified syntax,
union and intersection types, enums, and an overhauled macro system.

## Further Information

- [scala-lang.org](https://scala-lang.org/)
- [Wikipedia](https://en.wikipedia.org/wiki/Scala_(programming_language))
```
