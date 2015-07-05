# Start from a Debian image with the latest version of Go installed
# and a workspace (GOPATH) configured at /go.
FROM golang

# Copy the local package files to the container's workspace.
ADD src /go/src

# Build the runnable eventsapp inside the container.
# (You may fetch or manage dependencies here,
# either manually or with a tool like "godep".)

RUN go install github.com/ipolding/eventsapp

# Document which port the service listens on
EXPOSE 4000
