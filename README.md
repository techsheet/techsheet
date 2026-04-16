TechSheet.org
=============

Detectors
---------

The TechSheet Analyzer is based on **detectors**, pieces of code to scan for specific languages, technologies or tools
used in projects. The following list shows current detectors as well as the test-projects validating them. For all tests
and test-projects, see [AnalyzerIntegrationTest](cli/src/jvmTest/kotlin/org/techsheet/cli/AnalyzerIntegrationTest.kt).

### Languages

| Language   | Detector                                                            | Test Project(s)                                   |
|------------|---------------------------------------------------------------------|---------------------------------------------------|
| C#         | _planned_                                                           | —                                                 |
| C++        | _planned_                                                           | —                                                 |
| Go         | _planned_                                                           | —                                                 |
| Java       | [JavaDetector](org.techsheet.cli.detector.JavaDetector)             | `java-spring-boot-maven`                          |
| JavaScript | [JavaScriptDetector](org.techsheet.cli.detector.JavaScriptDetector) | `play-scala-seed`, `node-express`                 |
| Kotlin     | [KotlinDetector](org.techsheet.cli.detector.KotlinDetector)         | `kotlin-spring-boot-gradle`                       |
| PHP        | _planned_                                                           | —                                                 |
| Python     | [PythonDetector](org.techsheet.cli.detector.PythonDetector)         | `python_django`, `python_fastapi`, `python_flask` |
| Rust       | _planned_                                                           | —                                                 |
| Scala      | [ScalaDetector](org.techsheet.cli.detector.ScalaDetector)           | `play-scala-seed`                                 |
| TypeScript | [TypeScriptDetector](org.techsheet.cli.detector.TypeScriptDetector) | `angular`, `playwright`, `next-js`                |

### Technologies

| Technology      | Category  | Detector                                                            | Test Project(s)                                                                    |
|-----------------|-----------|---------------------------------------------------------------------|------------------------------------------------------------------------------------|
| Angular         | Framework | [AngularDetector](org.techsheet.cli.detector.AngularDetector)       | `angular`                                                                          |
| Django          | Framework | [DjangoDetector](org.techsheet.cli.detector.DjangoDetector)         | `python_django`                                                                    |
| Express         | Framework | [ExpressDetector](org.techsheet.cli.detector.ExpressDetector)       | `node-express`                                                                     |
| FastAPI         | Framework | [FastApiDetector](org.techsheet.cli.detector.FastApiDetector)       | `python_fastapi`                                                                   |
| Flask           | Framework | [FlaskDetector](org.techsheet.cli.detector.FlaskDetector)           | `python_flask`                                                                     |
| Laravel         | Framework | _planned_                                                           | —                                                                                  |
| NestJS          | Framework | _planned_                                                           | —                                                                                  |
| Next.js         | Framework | [NextDetector](org.techsheet.cli.detector.NextDetector)             | `next-js`                                                                          |
| Nuxt.js         | Framework | _planned_                                                           | —                                                                                  |
| Play Framework  | Framework | [PlayDetector](org.techsheet.cli.detector.PlayDetector)             | `play-scala-seed`                                                                  |
| React           | Framework | [ReactDetector](org.techsheet.cli.detector.ReactDetector)           | `next-js`                                                                          |
| Ruby on Rails   | Framework | _planned_                                                           | —                                                                                  |
| Spring Boot     | Framework | [SpringDetector](org.techsheet.cli.detector.SpringDetector)         | `groovy-spring-boot-gradle`, `kotlin-spring-boot-gradle`, `java-spring-boot-maven` |
| Spring Data     | Framework | [SpringDetector](org.techsheet.cli.detector.SpringDetector)         | `java-spring-boot-maven`                                                           |
| Spring MVC      | Framework | [SpringDetector](org.techsheet.cli.detector.SpringDetector)         | `kotlin-spring-boot-gradle`                                                        |
| Spring Security | Framework | [SpringDetector](org.techsheet.cli.detector.SpringDetector)         | `java-spring-boot-maven`                                                           |
| Spring WebFlux  | Framework | [SpringDetector](org.techsheet.cli.detector.SpringDetector)         | `groovy-spring-boot-gradle`                                                        |
| Svelte          | Framework | [SvelteDetector](org.techsheet.cli.detector.SvelteDetector)         | —                                                                                  |
| Symfony         | Framework | _planned_                                                           | —                                                                                  |
| Vue.js          | Framework | [VueDetector](org.techsheet.cli.detector.VueDetector)               | —                                                                                  |
| WordPress       | Framework | _planned_                                                           | —                                                                                  |
| Tailwind CSS    | Library   | [TailwindDetector](org.techsheet.cli.detector.TailwindDetector)     | `next-js`                                                                          |
| JUnit           | Testing   | [JUnitDetector](org.techsheet.cli.detector.JUnitDetector)           | `groovy-spring-boot-gradle`, `kotlin-spring-boot-gradle`                           |
| Playwright      | Testing   | [PlaywrightDetector](org.techsheet.cli.detector.PlaywrightDetector) | `playwright`                                                                       |

### Tools

| Tool               | Category    | Detector                                                                  | Test Project(s)                                    |
|--------------------|-------------|---------------------------------------------------------------------------|----------------------------------------------------|
| Gradle (Groovy)    | Build       | [GradleDetector](org.techsheet.cli.detector.GradleDetector)               | `groovy-spring-boot-gradle`                        |
| Gradle (Kotlin)    | Build       | [GradleDetector](org.techsheet.cli.detector.GradleDetector)               | `kotlin-spring-boot-gradle`                        |
| Maven              | Build       | [MavenDetector](org.techsheet.cli.detector.MavenDetector)                 | `java-spring-boot-maven`                           |
| npm                | Build       | [NpmDetector](org.techsheet.cli.detector.NpmDetector)                     | `angular`, `playwright`, `next-js`, `node-express` |
| pnpm               | Build       | _planned_                                                                 | —                                                  |
| sbt                | Build       | [SbtDetector](org.techsheet.cli.detector.SbtDetector)                     | `play-scala-seed`                                  |
| Webpack            | Build       | _planned_                                                                 | —                                                  |
| Yarn               | Build       | [YarnDetector](org.techsheet.cli.detector.YarnDetector)                   | `playwright`                                       |
| CODEOWNERS         | CI          | [CodeOwnersDetector](org.techsheet.cli.detector.CodeOwnersDetector)       | `ci-tools`                                         |
| GitHub Actions     | CI          | [GitHubActionsDetector](org.techsheet.cli.detector.GitHubActionsDetector) | `playwright`                                       |
| GitLab CI          | CI          | [GitLabCiDetector](org.techsheet.cli.detector.GitLabCiDetector)           | `ci-tools`                                         |
| Jenkins            | CI          | _planned_                                                                 | —                                                  |
| Docker             | Container   | [DockerDetector](org.techsheet.cli.detector.DockerDetector)               | `ci-tools`                                         |
| Docker Compose     | Container   | [DockerComposeDetector](org.techsheet.cli.detector.DockerComposeDetector) | `ci-tools`                                         |
| Kubernetes         | Container   | _planned_                                                                 | —                                                  |
| EditorConfig       | Dev Tooling | [EditorConfigDetector](org.techsheet.cli.detector.EditorConfigDetector)   | `angular`, `ci-tools`                              |
| ESLint             | Dev Tooling | [EslintDetector](org.techsheet.cli.detector.EslintDetector)               | `next-js`                                          |
| Git                | Dev Tooling | [GitDetector](org.techsheet.cli.detector.GitDetector)                     | —                                                  |
| Node.js            | Dev Tooling | [NodeDetector](org.techsheet.cli.detector.NodeDetector)                   | `node-express`                                     |
| Prettier           | Dev Tooling | [PrettierDetector](org.techsheet.cli.detector.PrettierDetector)           | —                                                  |
| Renovate           | Dev Tooling | [RenovateDetector](org.techsheet.cli.detector.RenovateDetector)           | `ci-tools`                                         |
| IntelliJ IDEA      | IDE         | [IntelliJIdeaDetector](org.techsheet.cli.detector.IntelliJIdeaDetector)   | `groovy-spring-boot-gradle`                        |
| Visual Studio Code | IDE         | [VsCodeDetector](org.techsheet.cli.detector.VsCodeDetector)               | `angular`                                          |

Building the CLI
----------------

The CLI is a Kotlin Multiplatform module with JVM and native (Linux x64, Windows x64, macOS arm64) targets.

Build all targets at once:

```bash
./gradlew :cli:assemble
```

Per-target builds:

| Target      | Command                                          | Output                                                          |
|-------------|--------------------------------------------------|-----------------------------------------------------------------|
| JVM         | `./gradlew :cli:jvmJar`                          | `cli/build/libs/techsheet-cli-jvm-<version>.jar`                |
| Linux x64   | `./gradlew :cli:linkReleaseExecutableLinuxX64`   | `cli/build/bin/linuxX64/releaseExecutable/techsheet-cli.kexe`   |
| Windows x64 | `./gradlew :cli:linkReleaseExecutableMingwX64`   | `cli/build/bin/mingwX64/releaseExecutable/techsheet-cli.exe`    |
| macOS arm64 | `./gradlew :cli:linkReleaseExecutableMacosArm64` | `cli/build/bin/macosArm64/releaseExecutable/techsheet-cli.kexe` |

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
