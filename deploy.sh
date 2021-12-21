#!/bin/bash
mvn clean package -Pnative
sam package --template-file target/sam.native.yaml --output-template-file packaged.yaml --s3-bucket dasniko-quarkus-demo
sam deploy --template-file packaged.yaml --capabilities CAPABILITY_IAM --stack-name peanuts-api
