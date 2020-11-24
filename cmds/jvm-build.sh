#!/bin/bash

rm -rf build
./gradlew build

if [ "$(ls build/*-runner.jar | wc -l)" -eq "0" ]; then
    echo "Jar not found"
    exit 1
fi

IMAGE_NAME="quarkus-jvm:1.0.0"
docker rmi -f ${IMAGE_NAME}
docker build -f Dockerfile.jvm -t ${IMAGE_NAME} .
