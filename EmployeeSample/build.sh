#!/bin/bash

echo "Cleaning and packaging the app..."
mvn clean install

echo "Building docker image..."
docker build -t employee-sample3 .
