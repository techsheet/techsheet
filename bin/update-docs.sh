#!/usr/bin/env bash
set -euo pipefail

# Run from the project root regardless of the caller's CWD.
cd "$(dirname "$0")/.."

# Note: `:cli:jvmRun` sets ./cli as the JVM's working directory, so paths
# passed to --args are resolved against ./cli — hence the `../` prefixes
# below for detectors (whose output path is relative to the JVM CWD) and
# the `../` source argument for analyze (so its output paths resolve
# relative to the project root).

./gradlew :cli:jvmRun --args="detectors --markdown=../docs/detectors.md"
./gradlew :cli:jvmRun --args="analyze ../ \
  --markdown=docs/example/techsheet.md \
  --html=docs/example/techsheet.html \
  --yaml=docs/example/techsheet.yml \
  --json=docs/example/techsheet.json"
