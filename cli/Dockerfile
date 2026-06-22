# syntax=docker/dockerfile:1
#
# Expects the build context to contain a Linux x64 binary named `techsheet`.
# In the release pipeline the context is `dist/cli/linux-x64`.

FROM debian:bookworm-slim@sha256:96e378d7e6531ac9a15ad505478fcc2e69f371b10f5cdf87857c4b8188404716
COPY techsheet /usr/local/bin/techsheet

WORKDIR /workspace
CMD ["techsheet", "analyze"]
