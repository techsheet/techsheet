<div align="center">

# TechSheet.org

An **open standard** and toolchain to report **technical insights** about **software projects** in an automated, 
structured, uniform manner.

[![Release][release-badge]][release-url]
[![CI][ci-badge]][ci-url]
[![Container][docker-badge]][docker-url]
[![License][license-badge]][license-url]

</div>

*TechSheet provides a [CLI](#cli) to analyze your repositories. It currently detects 
**[14+ languages](./docs/detectors.md#languages)**, **[74+ frameworks](./docs/detectors.md#frameworks)**, and 
**[20+ tools](./docs/detectors.md#tools)**, including versions where possible. Additionally, the TechSheet 
[Server](#server) can be used for storing and aggregating reports as well as gathering insights across teams and 
projects.*

## CLI

The CLI can be installed and used on various platforms, as a precompiled binary for Linux, OSX and Windows, as a Docker 
image, a CI job on GitHub / GitLab or as a self-containing JAR.

Simply run analyze at your repository root to generate a report:

```bash
techsheet analyze
```

Or use it in your CI jobs:

```yaml
# .gitlab-ci.yml
techsheet:
  image: ghcr.io/techsheet/analyzer:latest
  script:
    - techsheet analyze --markdown
  artifacts:
    paths:
      - techsheet.md
```

### Installation

The CLI can be installed in several ways:

<details open>
<summary>Docker</summary>

```bash
docker run --rm -v "$PWD:/workspace" ghcr.io/techsheet/analyzer
```

</details>

<details>
<summary>OSX (precompiled binary)</summary>

```bash
curl -fsSL -o /usr/local/bin/techsheet https://github.com/techsheet/techsheet/releases/latest/download/techsheet-macos-arm64
chmod +x /usr/local/bin/techsheet
```

</details>

<details>
<summary>Linux (precompiled binary)</summary>

```bash
curl -fsSL -o /usr/local/bin/techsheet https://github.com/techsheet/techsheet/releases/latest/download/techsheet-linux-x64
chmod +x /usr/local/bin/techsheet
```

</details>

<details>
<summary>Windows (precompiled binary)</summary>

Download `techsheet-windows-x64.exe` from the [releases page][release-url]

</details>

<details>
<summary>JVM (jar)</summary>

```bash
curl -fsSL -o techsheet.jar https://github.com/techsheet/techsheet/releases/latest/download/techsheet.jar
java -jar techsheet.jar analyze .
```

</details>

Also, you can use the analyzer directly in your CI jobs:

<details open>
<summary>GitLab CI</summary>

```yaml
techsheet:
  image: ghcr.io/techsheet/analyzer:latest
  script:
    - techsheet analyze --markdown
  artifacts:
    paths:
      - techsheet.md
    when: always
```

</details>

### Reporters

By default, `analyze` just generates reports to console, but various other reporters are supported. For examples, see 
[Markdown](./docs/example/techsheet.md), [HTML](./docs/example/techsheet.html), [YAML](./docs/example/techsheet.yml) or 
[JSON](./docs/example/techsheet.json). For a full list of available reporters, just run:

```bash
techsheet analyze --help
```

### Detectors

The list of detected languages, frameworks, services and tools is constantly growing and improving with each release. 
Find the full list of detectors [here](./docs/detectors.md) or simply run:

```bash
techsheet detectors
```

Missing something? [Open an issue][new-detector-template] or send a PR.

## Server

The TechSheet server can be used to store, aggregate, analyze and gather insights from reports. 

***TBD:** Server is still in early stage development, and therefore not generally available.*

## Development

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

## Testing

Besides unit tests, behavior is validated against small but realistic project trees under
`cli/src/jvmTest/resources/test-projects/`. Each directory is a runnable sample that the analyzer processes like a 
real project.

Adding a fixture:

1. Add a project under `cli/src/jvmTest/resources/test-projects/<name>/`
2. Add a `testCase("<name>") { ... }` entry to `AnalyzerIntegrationTest.cases`
3. Run `./gradlew :cli:jvmTest` and `:cli:assemble` if you changed `commonMain`

## Contributing

Contributions of any kind are very welcome. Please read the [contribution guidelines](CONTRIBUTING.md) first, then 
[open an issue][issues-url] or propose a [pull request][pullrequest-url].

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

[kmp-url]: https://kotlinlang.org/docs/multiplatform.html

[issues-url]: https://github.com/techsheet/techsheet/issues

[pullrequest-url]: https://github.com/techsheet/techsheet/pulls

[new-detector-template]: https://github.com/techsheet/techsheet/issues/new?template=new-detector.yml
