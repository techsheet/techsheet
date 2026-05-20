# syntax=docker/dockerfile:1
#
# Expects the build context to contain a Linux x64 binary named `techsheet`.
# In the release pipeline the context is `dist/cli/linux-x64`.

FROM debian:bookworm-slim@sha256:0104b334637a5f19aa9c983a91b54c89887c0984081f2068983107a6f6c21eeb
COPY techsheet /usr/local/bin/techsheet

WORKDIR /workspace
CMD ["techsheet", "analyze"]
