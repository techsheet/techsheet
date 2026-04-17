<div align="center">

# TechSheet.org

**TechSheet is your automated technology detector and inventory: Replace tech-governance chores with a simple CI job.**

[![Release][release-badge]][release-url]
[![CI][ci-badge]][ci-url]
[![License][license-badge]][license-url]
[![Container][docker-badge]][docker-url]
[![Kotlin Multiplatform][kmp-badge]][kmp-url]

</div>

---

TechSheet scans a repository and identifies what it actually uses. It detects languages, frameworks, services, and
tools, including versions when possible. Run it in CI to generate an up-to-date report on every build. Collect reports 
across your organization to build a real inventory of your stack. It stays current without manual upkeep, so you can 
drop the spreadsheets and stop pretending the Confluence page is accurate. TechSheet is available as a precompiled 
binary for Linux, macOS, and Windows, a distroless Docker image, or a simple CI snippet you can drop into an existing 
pipeline.

The goal is simple: Make stack visibility and cross-team governance automatic, reliable, and no longer a chore.

## Usage

### CI Job

The simplest option is to integrate report generation into a CI job like this:

```yaml
# .gitlab-ci.yml
techsheet:
  image: ghcr.io/techsheet/analyzer:latest
  stage: docs
  script:
    - techsheet analyze --json --html
  artifacts:
    paths:
      - techsheet.json
      - techsheet.html
    when: always
```

## Run it locally

The TechSheet CLI is available as a precompiled binary for virtually any platform. Just [install](#install) it and run:

```shell
techsheet analyze
```

You can even use the markdown reporter and commit the resulting `TECHSHEET.md` directly to your repo, i.e. as a
pre-commit hook.

```shell
techsheet analyze --mardown
git add TECHSHEET.md
git commit -m "Updated TechSheet"
```

## Install

The CLi can be installed using various methods. The simplest are using Docker or precompiled binaries:

### Docker

```bash
docker run --rm -v "$PWD:/workspace" ghcr.io/techsheet/analyzer
```

Images are published to GHCR for every release.

### Native binary

```bash
# macOS (Apple Silicon)
curl -fsSL -o techsheet https://github.com/techsheet/techsheet/releases/latest/download/techsheet-macos-arm64
chmod +x techsheet

# Linux x64
curl -fsSL -o techsheet https://github.com/techsheet/techsheet/releases/latest/download/techsheet-linux-x64
chmod +x techsheet
```

For Windows, download `techsheet-windows-x64.exe` from the [releases page][release-url].

### JVM jar

```bash
curl -fsSL -o techsheet.jar https://github.com/techsheet/techsheet/releases/latest/download/techsheet.jar
java -jar techsheet.jar analyze .
```

## Available reporters

// TODO: explain available reporters: console, html, markdown, yaml, json.

## What gets detected

TechSheet ships detectors for 30+ languages, frameworks, services, and tools, with new ones added on a regular basis.
Run `techsheet detectors` to list what's in your binary.

<details>
<summary><strong>Full detector matrix</strong></summary>

### Languages

| Language   | Detector                                                                                         | Test project(s)                                       |
|------------|--------------------------------------------------------------------------------------------------|-------------------------------------------------------|
| C#         | [CSharpDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/CSharpDetector.kt)         | `asp-net-core-app`                                    |
| C++        | [CppDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/CppDetector.kt)               | `qt-cmake-app`                                        |
| Go         | _planned_                                                                                        | —                                                     |
| Java       | [JavaDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/JavaDetector.kt)             | `java-spring-boot-maven`                              |
| JavaScript | [JavaScriptDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/JavaScriptDetector.kt) | `play-scala-seed`<br>`node-express`                   |
| Kotlin     | [KotlinDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/KotlinDetector.kt)         | `kotlin-spring-boot-gradle`                           |
| PHP        | _planned_                                                                                        | —                                                     |
| Python     | [PythonDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/PythonDetector.kt)         | `python_django`<br>`python_fastapi`<br>`python_flask` |
| Rust       | _planned_                                                                                        | —                                                     |
| Scala      | [ScalaDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/ScalaDetector.kt)           | `play-scala-seed`                                     |
| TypeScript | [TypeScriptDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/TypeScriptDetector.kt) | `angular`<br>`playwright`<br>`next-js`                |

### Frameworks

| Framework       | Category    | Detector                                                                                         | Test project(s)                                                                        |
|-----------------|-------------|--------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| Angular         | Application | [AngularDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/AngularDetector.kt)       | `angular`                                                                              |
| ASP.NET Core    | Application | [AspNetCoreDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/AspNetCoreDetector.kt) | `asp-net-core-app`                                                                     |
| Django          | Application | [DjangoDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/DjangoDetector.kt)         | `python_django`                                                                        |
| Express         | Application | [ExpressDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/ExpressDetector.kt)       | `node-express`                                                                         |
| FastAPI         | Application | [FastApiDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/FastApiDetector.kt)       | `python_fastapi`                                                                       |
| Flask           | Application | [FlaskDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/FlaskDetector.kt)           | `python_flask`                                                                         |
| Laravel         | Application | _planned_                                                                                        | —                                                                                      |
| NestJS          | Application | _planned_                                                                                        | —                                                                                      |
| Next.js         | Application | [NextDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/NextDetector.kt)             | `next-js`                                                                              |
| Nuxt.js         | Application | _planned_                                                                                        | —                                                                                      |
| Play Framework  | Application | [PlayDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/PlayDetector.kt)             | `play-scala-seed`                                                                      |
| Qt              | Application | [QtDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/QtDetector.kt)                 | `qt-cmake-app`                                                                         |
| React           | Application | [ReactDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/ReactDetector.kt)           | `next-js`                                                                              |
| Ruby on Rails   | Application | _planned_                                                                                        | —                                                                                      |
| Spring Boot     | Application | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `groovy-spring-boot-gradle`<br>`kotlin-spring-boot-gradle`<br>`java-spring-boot-maven` |
| Spring MVC      | Application | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `kotlin-spring-boot-gradle`                                                            |
| Spring WebFlux  | Application | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `groovy-spring-boot-gradle`                                                            |
| Svelte          | Application | [SvelteDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SvelteDetector.kt)         | —                                                                                      |
| Symfony         | Application | _planned_                                                                                        | —                                                                                      |
| Vue.js          | Application | [VueDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/VueDetector.kt)               | —                                                                                      |
| WordPress       | Application | _planned_                                                                                        | —                                                                                      |
| Spring Data     | Data        | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `java-spring-boot-maven`                                                               |
| Spring Security | Security    | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `java-spring-boot-maven`                                                               |
| JUnit           | Testing     | [JUnitDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/JUnitDetector.kt)           | `groovy-spring-boot-gradle`<br>`kotlin-spring-boot-gradle`                             |
| Playwright      | Testing     | [PlaywrightDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/PlaywrightDetector.kt) | `playwright`                                                                           |
| Tailwind CSS    | UI          | [TailwindDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/TailwindDetector.kt)     | `next-js`                                                                              |

### Services

| Service      | Category | Detector  | Test project(s) |
|--------------|----------|-----------|-----------------|
| MongoDB      | Database | _planned_ | —               |
| MySQL        | Database | _planned_ | —               |
| PostgreSQL   | Database | _planned_ | —               |
| Redis        | Database | _planned_ | —               |
| Kafka        | Queue    | _planned_ | —               |
| RabbitMQ     | Queue    | _planned_ | —               |
| Apache HTTPD | Server   | _planned_ | —               |
| NginX        | Server   | _planned_ | —               |
| Tomcat       | Server   | _planned_ | —               |

### Tools

| Tool               | Category  | Detector                                                                                               | Test project(s)                                          |
|--------------------|-----------|--------------------------------------------------------------------------------------------------------|----------------------------------------------------------|
| Gradle (Groovy)    | Build     | [GradleDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GradleDetector.kt)               | `groovy-spring-boot-gradle`                              |
| Gradle (Kotlin)    | Build     | [GradleDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GradleDetector.kt)               | `kotlin-spring-boot-gradle`                              |
| Maven              | Build     | [MavenDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/MavenDetector.kt)                 | `java-spring-boot-maven`                                 |
| npm                | Build     | [NpmDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/NpmDetector.kt)                     | `angular`<br>`playwright`<br>`next-js`<br>`node-express` |
| pnpm               | Build     | _planned_                                                                                              | —                                                        |
| sbt                | Build     | [SbtDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SbtDetector.kt)                     | `play-scala-seed`                                        |
| Webpack            | Build     | _planned_                                                                                              | —                                                        |
| Yarn               | Build     | [YarnDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/YarnDetector.kt)                   | `playwright`                                             |
| CODEOWNERS         | CI        | [CodeOwnersDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/CodeOwnersDetector.kt)       | `ci-tools`                                               |
| GitHub Actions     | CI        | [GitHubActionsDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GitHubActionsDetector.kt) | `playwright`                                             |
| GitLab CI          | CI        | [GitLabCiDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GitLabCiDetector.kt)           | `ci-tools`                                               |
| Jenkins            | CI        | _planned_                                                                                              | —                                                        |
| Docker             | Container | [DockerDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/DockerDetector.kt)               | `ci-tools`                                               |
| Docker Compose     | Container | [DockerComposeDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/DockerComposeDetector.kt) | `ci-tools`                                               |
| Kubernetes         | Container | _planned_                                                                                              | —                                                        |
| EditorConfig       | Format    | [EditorConfigDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/EditorConfigDetector.kt)   | `angular`<br>`ci-tools`                                  |
| ESLint             | Format    | [EslintDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/EslintDetector.kt)               | `next-js`                                                |
| Prettier           | Format    | [PrettierDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/PrettierDetector.kt)           | —                                                        |
| IntelliJ IDEA      | IDE       | [IntelliJIdeaDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/IntelliJIdeaDetector.kt)   | `groovy-spring-boot-gradle`                              |
| Visual Studio Code | IDE       | [VsCodeDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/VsCodeDetector.kt)               | `angular`                                                |
| Node.js            | Runtime   | [NodeDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/NodeDetector.kt)                   | `node-express`                                           |
| Renovate           | Security  | [RenovateDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/RenovateDetector.kt)           | `ci-tools`                                               |
| Git                | VCS       | [GitDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GitDetector.kt)                     | —                                                        |

</details>

Missing something? Detectors are small, pattern-based Kotlin files —
[open an issue][new-detector-template] or send a PR.

## Building from source

TechSheet is a [Kotlin Multiplatform][kmp-url] module with JVM and native
targets (Linux x64, Windows x64, macOS arm64). Requires JDK 21+.

```bash
./gradlew :cli:assemble                        # builds all targets
./gradlew :cli:jvmRun --args="analyze ."       # run the JVM build directly
```

| Target      | Command                                          | Output                                                          |
|-------------|--------------------------------------------------|-----------------------------------------------------------------|
| JVM         | `./gradlew :cli:jvmJar`                          | `cli/build/libs/techsheet-cli-jvm.jar`                          |
| Linux x64   | `./gradlew :cli:linkReleaseExecutableLinuxX64`   | `cli/build/bin/linuxX64/releaseExecutable/techsheet-cli.kexe`   |
| Windows x64 | `./gradlew :cli:linkReleaseExecutableMingwX64`   | `cli/build/bin/mingwX64/releaseExecutable/techsheet-cli.exe`    |
| macOS arm64 | `./gradlew :cli:linkReleaseExecutableMacosArm64` | `cli/build/bin/macosArm64/releaseExecutable/techsheet-cli.kexe` |

Use `linkDebugExecutable*` in place of `linkReleaseExecutable*` for debug builds.

## How detectors are tested

Detector behaviour is validated against small but realistic project trees
under `cli/src/commonTest/resources/test-projects/`. Each directory is a real,
runnable sample — Gradle wrapper, `build.gradle.kts` / `pom.xml`, sources —
that the `Analyzer` runs over exactly like it would on a user's checkout.

Adding a fixture:

1. Drop a real project directory under `cli/src/commonTest/resources/test-projects/<name>/`.
2. Append a `testCase("<name>") { ... }` entry to `AnalyzerIntegrationTest.cases`
   describing the expected `TechSheet`.
3. Run `./gradlew :cli:jvmTest` — and `:cli:assemble` too if you touched
   `commonMain`, so Kotlin/Native catches any JVM-only API slips.

## Contributing

- **Bugs and feature requests:** [open an issue][issues-url].
- **New detectors:** use the ["Propose a new detector" issue template][new-detector-template]
  and follow the fixture-based pattern above.
- **PRs welcome** — no CLA, no ceremony.

## License

[Apache License 2.0](LICENSE).

[release-badge]: https://img.shields.io/github/v/release/techsheet/techsheet?label=release&color=blue

[release-url]: https://github.com/techsheet/techsheet/releases/latest

[ci-badge]: https://img.shields.io/github/actions/workflow/status/techsheet/techsheet/ci.yml?label=ci

[ci-url]: https://github.com/techsheet/techsheet/actions/workflows/ci.yml

[license-badge]: https://img.shields.io/badge/license-Apache%202.0-blue.svg

[license-url]: LICENSE

[docker-badge]: https://img.shields.io/badge/ghcr.io-techsheet%2Fanalyzer-2496ED?logo=docker&logoColor=white

[docker-url]: https://github.com/techsheet/techsheet/pkgs/container/analyzer

[kmp-badge]: https://img.shields.io/badge/kotlin-multiplatform-7F52FF?logo=kotlin&logoColor=white

[kmp-url]: https://kotlinlang.org/docs/multiplatform.html

[issues-url]: https://github.com/techsheet/techsheet/issues

[new-detector-template]: https://github.com/techsheet/techsheet/issues/new?template=new-detector.yml
