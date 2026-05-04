#!/bin/bash
set -e

increment_minor() {
  local major=$(echo "$1" | cut -d. -f1)
  local minor=$(echo "$1" | cut -d. -f2)
  echo "$major.$((minor + 1)).0"
}

# Check we're in a git repo
if ! git rev-parse --is-inside-work-tree > /dev/null 2>&1; then
  echo "Error: Not inside a git repository."
  exit 1
fi

# Check we're on master
BRANCH=$(git rev-parse --abbrev-ref HEAD)
if [ "$BRANCH" != "master" ]; then
  echo "Error: Must be on master (currently on $BRANCH)."
  exit 1
fi

# Check working directory is clean
if [ -n "$(git status --porcelain)" ]; then
  echo "Error: Working directory is not clean. Commit or stash your changes."
  exit 1
fi

# Read current version
if [ ! -f "version.txt" ]; then
  echo "Error: version.txt not found."
  exit 1
fi

CURRENT_VERSION=$(cat version.txt | tr -d '[:space:]')

if ! echo "$CURRENT_VERSION" | grep -qE '^[0-9]+\.[0-9]+\.[0-9]+$'; then
  echo "Error: version.txt is not valid semver (got '$CURRENT_VERSION')."
  exit 1
fi

DEFAULT_VERSION=$(increment_minor "$CURRENT_VERSION")

read -p "New version [$DEFAULT_VERSION]: " NEW_VERSION
NEW_VERSION=${NEW_VERSION:-$DEFAULT_VERSION}

if ! echo "$NEW_VERSION" | grep -qE '^[0-9]+\.[0-9]+\.[0-9]+$'; then
  echo "Error: '$NEW_VERSION' is not valid semver."
  exit 1
fi

echo "$NEW_VERSION" > version.txt

# Update generated docs before committing
"$(dirname "$0")/update-docs.sh"

git add version.txt README.md docs/
git commit -m "Release v$NEW_VERSION"
git tag "v$NEW_VERSION"
git push origin master "v$NEW_VERSION"

echo "Released v$NEW_VERSION"
