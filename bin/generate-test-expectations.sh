#!/usr/bin/env bash
set -euo pipefail

# Regenerate techsheet.expected.yml for every fixture in the test-projects
# submodule, using the current analyzer via :cli:jvmRun. After running this,
# inspect the diff in the test-projects repo before committing.
#
# Note: :cli:jvmRun sets ./cli as the JVM working directory, so the source
# argument is passed as ../test-projects/<name>. The --yaml path is resolved
# by the analyzer relative to the source, so "techsheet.expected.yml" lands
# inside each fixture directory.

cd "$(dirname "$0")/.."

if [ ! -d test-projects ]; then
  echo "Error: test-projects submodule not found. Did you run 'git submodule update --init'?" >&2
  exit 1
fi

for dir in test-projects/*/; do
  name="$(basename "$dir")"
  echo "==> $name"
  ./gradlew -q :cli:jvmRun --args="analyze ../test-projects/$name -q --file=../test-projects/$name/techsheet.expected.yml"
done

echo
echo "Done. Review test-projects/*/techsheet.expected.yml and commit in the submodule."
