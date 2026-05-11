# syntax=docker/dockerfile:1
#
# Expects the build context to contain a Linux x64 binary named `techsheet`.
# In the release pipeline the context is `dist/cli/linux-x64`.

FROM debian:bookworm-slim@sha256:67b30a61dc87758f0caf819646104f29ecbda97d920aaf5edc834128ac8493d3
COPY techsheet /usr/local/bin/techsheet

WORKDIR /workspace
CMD ["techsheet", "analyze"]
