# syntax=docker/dockerfile:1
#
# Expects the build context to contain a Linux x64 binary named `techsheet`.
# In the release pipeline the context is `dist/cli/linux-x64`.

FROM debian:bookworm-slim
COPY techsheet /usr/local/bin/techsheet

WORKDIR /workspace
CMD ["techsheet", "analyze"]
