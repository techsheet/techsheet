<div align="center">

# TechSheet.org

**TechSheet is your automated technology detector and inventory. Replace governance chores with a simple CI job.**

[![Release][release-badge]][release-url]
[![CI][ci-badge]][ci-url]
[![License][license-badge]][license-url]
[![Container][docker-badge]][docker-url]
[![Kotlin Multiplatform][kmp-badge]][kmp-url]

</div>

---

TechSheet scans a repository and identifies what it actually uses. It detects languages, frameworks, services, and
tools, including versions where possible.

Run it in CI to generate an up-to-date report on every build. Collect reports across your organization to build a real 
inventory of your stack. It stays current without manual upkeep, so you can drop the spreadsheets and stop pretending 
the Confluence page is accurate. TechSheet is available as a precompiled binary for Linux, macOS, and Windows, a 
distroless Docker image, or a CI snippet you can drop into an existing pipeline.

The goal is simple: make stack visibility and cross-team governance automatic, reliable, and no longer a chore.

## Usage

### CI job

The simplest option is to integrate report generation into a CI job:

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

## Run locally

The TechSheet CLI is also available as a precompiled binary for most platforms. Install it and run:

```sh
techsheet analyze
```

You can also use the Markdown reporter and commit the resulting `TECHSHEET.md` directly to your repo, for example via a
pre-commit hook:

```sh
techsheet analyze --markdown
git add TECHSHEET.md
git commit -m "Update TechSheet"
```

## Install

The CLI can be installed in several ways. The simplest are Docker or precompiled binaries.

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

<!-- TODO: explain available reporters: console, HTML, Markdown, YAML, JSON -->

## What gets detected

TechSheet ships detectors for 30+ languages, frameworks, services, and tools, with more added regularly. Run
`techsheet detectors` to list what is included in your build.

<details>
<summary><strong>Full detector matrix</strong></summary>

<!-- existing tables unchanged -->

</details>

Missing something? Detectors are small, pattern-based Kotlin files. [Open an issue][new-detector-template] or send a PR.

## Building from source

TechSheet is a [Kotlin Multiplatform][kmp-url] module with JVM and native targets (Linux x64, Windows x64, macOS arm64).
Requires JDK 21+.

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

Use `linkDebugExecutable*` instead of `linkReleaseExecutable*` for debug builds.

## How detectors are tested

Detector behavior is validated against small but realistic project trees under
`cli/src/commonTest/resources/test-projects/`. Each directory is a runnable sample that the analyzer processes exactly
like a real repository.

Adding a fixture:

1. Add a project under `cli/src/commonTest/resources/test-projects/<name>/`
2. Add a `testCase("<name>") { ... }` entry to `AnalyzerIntegrationTest.cases`
3. Run `./gradlew :cli:jvmTest` and `:cli:assemble` if you changed `commonMain`

## Contributing

* **Bugs and feature requests:** [open an issue][issues-url]
* **New detectors:** use the ["Propose a new detector" template][new-detector-template]
* **PRs welcome** with minimal process

## License

[Apache License 2.0](LICENSE)

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
