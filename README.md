TechSheet.org
=============


Building the CLI
----------------

The CLI is a Kotlin Multiplatform module with JVM and native (Linux x64, Windows x64, macOS arm64) targets.

Build all targets at once:

```bash
./gradlew :cli:assemble
```

Per-target builds:

| Target      | Command                                         | Output                                                         |
|-------------|-------------------------------------------------|----------------------------------------------------------------|
| JVM         | `./gradlew :cli:jvmJar`                         | `cli/build/libs/techsheet-cli-jvm-<version>.jar`               |
| Linux x64   | `./gradlew :cli:linkReleaseExecutableLinuxX64`  | `cli/build/bin/linuxX64/releaseExecutable/techsheet-cli.kexe`  |
| Windows x64 | `./gradlew :cli:linkReleaseExecutableMingwX64`  | `cli/build/bin/mingwX64/releaseExecutable/techsheet-cli.exe`   |
| macOS arm64 | `./gradlew :cli:linkReleaseExecutableMacosArm64`| `cli/build/bin/macosArm64/releaseExecutable/techsheet-cli.kexe`|

Use `linkDebugExecutable*` in place of `linkReleaseExecutable*` for debug builds.

Run the JVM build directly:

```bash
./gradlew :cli:jvmRun
```

Testing
-------

Detector behavior is validated against small but realistic project trees under
`cli/src/commonTest/resources/test-projects/` (e.g. `kotlin-spring-boot-gradle`,
`java-spring-boot-maven`). Each directory is a full, runnable sample — Gradle
wrapper, `build.gradle.kts` / `pom.xml`, sources — that the `Analyzer` runs over
exactly like it would on a user's checkout.

`AnalyzerIntegrationTest` (in `cli/src/jvmTest/...`) resolves each fixture from
the test classpath via `ClassLoader.getResource(...)` and emits one JUnit 5
`DynamicTest` per fixture, asserting the produced `TechSheet` matches the
expected one.

Adding a new fixture:

1. Drop a real project directory under `cli/src/commonTest/resources/test-projects/<name>/`.
2. Append a `testCase("<name>") { ... }` entry to `AnalyzerIntegrationTest.cases`
   describing the expected `TechSheet`.
3. Run `./gradlew :cli:jvmTest`.

Roadmap
-------

Coverage targets for detectors. Checked boxes are already shipping.

### Programming languages

- [x] Python
- [x] JavaScript
- [x] TypeScript
- [x] Java
- [ ] C#
- [ ] C++
- [ ] Go
- [ ] Rust
- [x] Kotlin
- [ ] PHP
- [x] Scala

### Frameworks & libraries

- [ ] React
- [ ] Vue.js
- [x] Angular
- [ ] Svelte
- [ ] Next.js
- [ ] Nuxt.js
- [ ] Express
- [ ] NestJS
- [x] Django
- [x] Flask
- [x] FastAPI
- [ ] Ruby on Rails
- [ ] Laravel
- [x] Spring Boot
- [x] Spring MVC
- [x] Spring WebFlux
- [x] Spring Security
- [x] Spring Data
- [x] Play Framework
- [x] Playwright

### Tools

- [ ] Git
- [x] Docker
- [x] Docker Compose
- [ ] Kubernetes
- [x] Maven
- [x] Gradle
- [x] sbt
- [x] npm
- [x] Yarn
- [ ] pnpm
- [ ] Webpack
- [ ] Prettier
- [x] GitHub Actions
- [x] GitLab CI
- [ ] Jenkins
- [x] Renovate
- [x] CODEOWNERS
- [x] EditorConfig
- [x] IntelliJ IDEA
- [x] Visual Studio Code
