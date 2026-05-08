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

languages=$(grep -m1 "Currently supporting.*languages" docs/detectors.md | grep -o '[0-9]\+')
frameworks=$(grep -m1 "Currently supporting.*frameworks" docs/detectors.md | grep -o '[0-9]\+')
tools=$(grep -m1 "Currently supporting.*tools" docs/detectors.md | grep -o '[0-9]\+')
sed -i.bak \
  -e "s/\[[0-9]*+ languages\]/[${languages}+ languages]/" \
  -e "s/\[[0-9]*+ frameworks\]/[${frameworks}+ frameworks]/" \
  -e "s/\[[0-9]*+ tools\]/[${tools}+ tools]/" \
  README.md
rm -f README.md.bak

./gradlew :cli:jvmRun --args="analyze ../ \
  --markdown=docs/example/techsheet.md \
  --html=docs/example/techsheet.html \
  --yaml=docs/example/techsheet.yml \
  --json=docs/example/techsheet.json"
