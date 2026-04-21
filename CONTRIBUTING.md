# Contributing to TechSheet

Thanks for your interest! Here's how to help.

## Ways to contribute

- **New detector?** Use the [detector request][new-detector] issue template.
- **Bug report?** [Open an issue][issues] with a minimal repro — ideally a small project tree you can share.
- **Pull request?** See below.

## Development

Requires JDK 21+. See the [Development](README.md#development) section of the README for build commands.

When you touch `commonMain`, run **both** `:cli:jvmTest` and `:cli:assemble`:

```bash
./gradlew :cli:jvmTest :cli:assemble
```

`jvmTest` only exercises the JVM target — `:cli:assemble` builds every KMP target and surfaces accidental use of
JVM-only APIs in common code.

## Adding a detector

1. If your detector reports a new language / framework / tool / service, add an entry to the matching enum in
   `cli/src/commonMain/kotlin/org/techsheet/cli/domain/` (`LanguageType`, `FrameworkType`, `ToolType`, `ServiceType`).
2. Add the detector under `cli/src/commonMain/kotlin/org/techsheet/cli/detector/`:
  - For dependency-manifest checks, extend one of the existing abstracts: `AbstractNpmDependencyDetector`,
    `AbstractJvmDependencyDetector`, `AbstractPythonDependencyDetector`, `AbstractSourceFileLanguageDetector`.
  - Otherwise extend `Detector(name, vararg matchers: Matcher)` and override `onMatch(path, content, sheet)`. Pick the
    narrowest `Matcher`: `Filename` / `Extension` match anywhere in the tree (monorepo-friendly); `FileAt` /
    `DirectoryAt` are for markers that must be at a specific path (e.g. `.github/workflows/`).
3. Register the detector in the `Detectors.ALL` list in `Detectors.kt`.
4. Add a fixture project at `cli/src/jvmTest/resources/test-projects/<name>/` containing the marker files.
5. Add a `testCase("<name>") { ... }` entry in `AnalyzerIntegrationTest.cases` asserting the expected `TechSheet`.
6. Run `./gradlew :cli:jvmTest :cli:assemble`.

Keep `onMatch` tiny — it should hand off to the abstract or make a single `sheet.withX(...)` call. Never swallow caught
exceptions silently; log at WARN with the throwable.

## Pull requests

- One feature or fix per PR.
- Include tests for behavior changes.
- CI must be green before requesting review.
- Commit subject: short imperative (e.g. `Add Svelte detector`).

## License

By contributing you agree your contributions are licensed under the [Apache License 2.0](LICENSE).

[new-detector]: https://github.com/techsheet/techsheet/issues/new?template=new-detector.yml

[issues]: https://github.com/techsheet/techsheet/issues
