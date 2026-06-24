#!/usr/bin/env bash
set -euo pipefail

# Run from the project root regardless of the caller's CWD.
cd "$(dirname "$0")/.."

# Note: `:analyzer:jvmRun` sets ./analyzer as the JVM's working directory,
# so the `../` source argument for analyze resolves relative to the project root.

./gradlew :docs:updateDocs

./gradlew :analyzer:jvmRun --args="analyze ../ \
  --file=../techsheet.yml"

./gradlew :analyzer:jvmRun --args="analyze ../ \
  -q \
  --file=../docs/example/techsheet.yml \
  --report-markdown=../docs/example/techsheet.md \
  --report-html=../docs/example/techsheet.html \
  --report-json=../docs/example/techsheet.json"

.venv/bin/generate-schema-doc --config-file jsfh-conf.yaml docs/content/spec/v2/techsheet.json docs/content/spec/v2/techsheet.md
sed -i '1s/^/---\ntitle: Schema V2 (current)\nweight: 60\naliases:\n  - \/schema\/v2\/techsheet\n---\n\n/' docs/content/spec/v2/techsheet.md
