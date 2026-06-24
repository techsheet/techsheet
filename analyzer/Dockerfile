# syntax=docker/dockerfile:1
#
# Expects the build context to contain the Linux x64 binary.
# In the release pipeline the context is `dist/`.

FROM debian:bookworm-slim@sha256:f9c6a2fd2ddbc23e336b6257a5245e31f996953ef06cd13a59fa0a1df2d5c252
COPY techsheet-analyzer_linux-x64 /usr/local/bin/techsheet-analyzer

WORKDIR /workspace
CMD ["techsheet-analyzer", "analyze"]
