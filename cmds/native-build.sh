#!/bin/bash

rm -rf build
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true

if [ "$(ls build/*-runner | wc -l)" -eq "0" ]; then
    echo "Runner not found"
    exit 1
fi

IMAGE_NAME="quarkus-native:1.0.0"
docker rmi -f ${IMAGE_NAME}
docker build -f Dockerfile.native -t ${IMAGE_NAME} .
