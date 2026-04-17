TechSheet.org
=============

Detectors
---------

The TechSheet Analyzer is based on **detectors**, pieces of code to scan for specific languages, frameworks, services or
tools used in projects. The following list shows current detectors as well as the test-projects validating them. For all
tests and test-projects, see [AnalyzerIntegrationTest](cli/src/jvmTest/kotlin/org/techsheet/cli/AnalyzerIntegrationTest.kt).

### Languages

| Language   | Detector                                                            | Test Project(s)                                   |
|------------|---------------------------------------------------------------------|---------------------------------------------------|
| C#         | [CSharpDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/CSharpDetector.kt) | `asp-net-core-app`                                |
| C++        | [CppDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/CppDetector.kt) | `qt-cmake-app`                                    |
| Go         | _planned_                                                           | —                                                 |
| Java       | [JavaDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/JavaDetector.kt)             | `java-spring-boot-maven`                          |
| JavaScript | [JavaScriptDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/JavaScriptDetector.kt) | `play-scala-seed`<br>`node-express`               |
| Kotlin     | [KotlinDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/KotlinDetector.kt)         | `kotlin-spring-boot-gradle`                       |
| PHP        | _planned_                                                           | —                                                 |
| Python     | [PythonDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/PythonDetector.kt)         | `python_django`<br>`python_fastapi`<br>`python_flask` |
| Rust       | _planned_                                                           | —                                                 |
| Scala      | [ScalaDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/ScalaDetector.kt)           | `play-scala-seed`                                 |
| TypeScript | [TypeScriptDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/TypeScriptDetector.kt) | `angular`<br>`playwright`<br>`next-js`            |

### Frameworks

| Framework       | Category    | Detector                                                            | Test Project(s)                                                                        |
|-----------------|-------------|---------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| Angular         | Application | [AngularDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/AngularDetector.kt)       | `angular`                                                                              |
| ASP.NET Core    | Application | [AspNetCoreDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/AspNetCoreDetector.kt) | `asp-net-core-app`                                                                     |
| Django          | Application | [DjangoDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/DjangoDetector.kt)         | `python_django`                                                                        |
| Express         | Application | [ExpressDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/ExpressDetector.kt)       | `node-express`                                                                         |
| FastAPI         | Application | [FastApiDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/FastApiDetector.kt)       | `python_fastapi`                                                                       |
| Flask           | Application | [FlaskDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/FlaskDetector.kt)           | `python_flask`                                                                         |
| Laravel         | Application | _planned_                                                           | —                                                                                      |
| NestJS          | Application | _planned_                                                           | —                                                                                      |
| Next.js         | Application | [NextDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/NextDetector.kt)             | `next-js`                                                                              |
| Nuxt.js         | Application | _planned_                                                           | —                                                                                      |
| Play Framework  | Application | [PlayDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/PlayDetector.kt)             | `play-scala-seed`                                                                      |
| Qt              | Application | [QtDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/QtDetector.kt)                 | `qt-cmake-app`                                                                         |
| React           | Application | [ReactDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/ReactDetector.kt)           | `next-js`                                                                              |
| Ruby on Rails   | Application | _planned_                                                           | —                                                                                      |
| Spring Boot     | Application | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `groovy-spring-boot-gradle`<br>`kotlin-spring-boot-gradle`<br>`java-spring-boot-maven` |
| Spring MVC      | Application | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `kotlin-spring-boot-gradle`                                                            |
| Spring WebFlux  | Application | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `groovy-spring-boot-gradle`                                                            |
| Svelte          | Application | [SvelteDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SvelteDetector.kt)         | —                                                                                      |
| Symfony         | Application | _planned_                                                           | —                                                                                      |
| Vue.js          | Application | [VueDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/VueDetector.kt)               | —                                                                                      |
| WordPress       | Application | _planned_                                                           | —                                                                                      |
| Spring Data     | Data        | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `java-spring-boot-maven`                                                               |
| Spring Security | Security    | [SpringDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SpringDetector.kt)         | `java-spring-boot-maven`                                                               |
| JUnit           | Testing     | [JUnitDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/JUnitDetector.kt)           | `groovy-spring-boot-gradle`<br>`kotlin-spring-boot-gradle`                             |
| Playwright      | Testing     | [PlaywrightDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/PlaywrightDetector.kt) | `playwright`                                                                           |
| Tailwind CSS    | UI          | [TailwindDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/TailwindDetector.kt)     | `next-js`                                                                              |

### Services

| Service      | Category | Detector  | Test Project(s) |
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

| Tool               | Category    | Detector                                                                  | Test Project(s)                                    |
|--------------------|-------------|---------------------------------------------------------------------------|----------------------------------------------------|
| Gradle (Groovy)    | Build       | [GradleDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GradleDetector.kt)               | `groovy-spring-boot-gradle`                        |
| Gradle (Kotlin)    | Build       | [GradleDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GradleDetector.kt)               | `kotlin-spring-boot-gradle`                        |
| Maven              | Build       | [MavenDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/MavenDetector.kt)                 | `java-spring-boot-maven`                           |
| npm                | Build       | [NpmDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/NpmDetector.kt)                     | `angular`<br>`playwright`<br>`next-js`<br>`node-express` |
| pnpm               | Build       | _planned_                                                                 | —                                                  |
| sbt                | Build       | [SbtDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/SbtDetector.kt)                     | `play-scala-seed`                                  |
| Webpack            | Build       | _planned_                                                                 | —                                                  |
| Yarn               | Build       | [YarnDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/YarnDetector.kt)                   | `playwright`                                       |
| CODEOWNERS         | CI          | [CodeOwnersDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/CodeOwnersDetector.kt)       | `ci-tools`                                         |
| GitHub Actions     | CI          | [GitHubActionsDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GitHubActionsDetector.kt) | `playwright`                                       |
| GitLab CI          | CI          | [GitLabCiDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GitLabCiDetector.kt)           | `ci-tools`                                         |
| Jenkins            | CI          | _planned_                                                                 | —                                                  |
| Docker             | Container   | [DockerDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/DockerDetector.kt)               | `ci-tools`                                         |
| Docker Compose     | Container   | [DockerComposeDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/DockerComposeDetector.kt) | `ci-tools`                                         |
| Kubernetes         | Container   | _planned_                                                                 | —                                                  |
| EditorConfig       | Format      | [EditorConfigDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/EditorConfigDetector.kt)   | `angular`<br>`ci-tools`                            |
| ESLint             | Format      | [EslintDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/EslintDetector.kt)               | `next-js`                                          |
| Prettier           | Format      | [PrettierDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/PrettierDetector.kt)           | —                                                  |
| IntelliJ IDEA      | IDE         | [IntelliJIdeaDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/IntelliJIdeaDetector.kt)   | `groovy-spring-boot-gradle`                        |
| Visual Studio Code | IDE         | [VsCodeDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/VsCodeDetector.kt)               | `angular`                                          |
| Node.js            | Runtime     | [NodeDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/NodeDetector.kt)                   | `node-express`                                     |
| Renovate           | Security    | [RenovateDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/RenovateDetector.kt)           | `ci-tools`                                         |
| Git                | VCS         | [GitDetector](cli/src/commonMain/kotlin/org/techsheet/cli/detector/GitDetector.kt)                     | —                                                  |

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
