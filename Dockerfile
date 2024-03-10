ARG JDK_VERSION=21

FROM amazoncorretto:${JDK_VERSION}-alpine AS build

WORKDIR /src
COPY . /src
RUN --mount=type=cache,target=/root/.gradle ./gradlew --no-daemon installDist

FROM alpine
ARG JDK_VERSION

RUN wget -O /etc/apk/keys/amazoncorretto.rsa.pub  https://apk.corretto.aws/amazoncorretto.rsa.pub
RUN echo "https://apk.corretto.aws/" >> /etc/apk/repositories
RUN apk add --no-cache amazon-corretto-${JDK_VERSION} py3-guessit

COPY --from=build /src/build/install/torrent-loom /

ENTRYPOINT ["/bin/torrent-loom"]
CMD ["--help"]
