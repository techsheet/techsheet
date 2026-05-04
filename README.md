<div align="center">

# <a href="#"><img src="./docs/logo/techsheet-logo.svg" style="height:1em;"></a> TechSheet.org

An **open standard** and toolchain to report **technical insights** about **software projects** in an automated, 
structured, uniform manner.

[![Release][release-badge]][release-url]
[![CI][ci-badge]][ci-url]
[![Container][docker-badge]][docker-url]
[![License][license-badge]][license-url]
[![OSSF-Scorecard][ossf-badge]][ossf-url]

</div>

*TechSheet provides a [CLI](#cli) to analyze your repositories. It currently detects 
**[15+ languages](./docs/detectors.md#languages)**, **[84+ frameworks](./docs/detectors.md#frameworks)**, and 
**[32+ tools](./docs/detectors.md#tools)**, including versions where possible. Additionally, the TechSheet 
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
<summary>Apple macOS</summary>

Download the precompiled binary from releases:

```bash
sudo curl -fsSL -o /usr/local/bin/techsheet https://github.com/techsheet/techsheet/releases/latest/download/techsheet-macos-arm64
sudo chmod +x /usr/local/bin/techsheet
```

***Note:** We only build for Apple silicon (ARM) cpu's. If you use an older Intel Mac, please use Docker, JAR, or build 
from source.*

</details>

<details>
<summary>Linux</summary>

Download the precompiled binary from releases:

```bash
sudo curl -fsSL -o /usr/local/bin/techsheet https://github.com/techsheet/techsheet/releases/latest/download/techsheet-linux-x64
sudo chmod +x /usr/local/bin/techsheet
```

***Note:** We only build for 64 bit platforms.*

</details>

<details>
<summary>Windows</summary>

Download `techsheet-windows-x64.exe` from the [releases page][release-url]

***Note:** We currently don't support any package managers or installers for Windows, as there's no demand.*

</details>

<details>
<summary>JVM</summary>

Download the JAR and execute it:

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

Besides unit tests, behavior is validated against realistic project trees in the
[`test-projects`](https://github.com/techsheet/test-projects) submodule. Each directory is a minimal but realistic
project that the analyzer processes like a real repo. The test compares the output against a checked-in
`techsheet.expected.yml`; a `techsheet.actual.yml` is written on each run for diff inspection. All directories are
auto-discovered — no code changes needed to register a new fixture.

Adding a fixture:

1. Add or extend a project in the [`test-projects`](https://github.com/techsheet/test-projects) repo (via PR)
2. Add or update `techsheet.expected.yml` in that project directory
3. Update the submodule pointer in this repo
4. Run `./gradlew :cli:jvmTest` and `:cli:assemble` if you changed `commonMain`

## Contributing

Contributions of any kind are very welcome. Please read the [contribution guidelines](CONTRIBUTING.md) first, then 
[open an issue][issues-url] or propose a [pull request][pullrequest-url].

## License

[Apache License 2.0](LICENSE)

[release-badge]: https://img.shields.io/github/v/release/techsheet/techsheet?include_prereleases&label=Release

[release-url]: https://github.com/techsheet/techsheet/releases/latest

[ci-badge]: https://github.com/techsheet/techsheet/actions/workflows/ci.yml/badge.svg

[ci-url]: https://github.com/techsheet/techsheet/actions/workflows/ci.yml

[license-badge]: https://img.shields.io/github/license/techsheet/techsheet?label=License

[license-url]: LICENSE

[docker-badge]: https://img.shields.io/badge/ghcr.io-techsheet%2Fanalyzer-2496ED?logo=docker&logoColor=white

[docker-url]: https://github.com/techsheet/techsheet/pkgs/container/analyzer

[kmp-url]: https://kotlinlang.org/docs/multiplatform.html

[issues-url]: https://github.com/techsheet/techsheet/issues

[pullrequest-url]: https://github.com/techsheet/techsheet/pulls

[new-detector-template]: https://github.com/techsheet/techsheet/issues/new?template=new-detector.yml

[ossf-badge]: https://img.shields.io/ossf-scorecard/github.com/techsheet/techsheet?label=OpenSSF

[ossf-url]: https://scorecard.dev/viewer/?uri=github.com/techsheet/techsheet
