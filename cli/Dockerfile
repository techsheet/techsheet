# syntax=docker/dockerfile:1
#
# Expects the build context to contain a Linux x64 binary named `techsheet`.
# In the release pipeline the context is `dist/cli/linux-x64`.

FROM debian:bookworm-slim@sha256:f9c6a2fd2ddbc23e336b6257a5245e31f996953ef06cd13a59fa0a1df2d5c252
COPY techsheet /usr/local/bin/techsheet

WORKDIR /workspace
CMD ["techsheet", "analyze"]
