ARG JDK_VERSION=21

FROM amazoncorretto:$JDK_VERSION-alpine AS build

COPY . /src
WORKDIR /src
RUN ./gradlew --no-daemon installDist

FROM alpine

RUN wget -O /etc/apk/keys/amazoncorretto.rsa.pub  https://apk.corretto.aws/amazoncorretto.rsa.pub
RUN echo "https://apk.corretto.aws/" >> /etc/apk/repositories
RUN apk add --no-cache amazon-corretto-$JDK_VERSION py3-guessit

COPY --from=build /src/build/install/TorrentLoom /

ENTRYPOINT "/bin/TorrentLoom"
