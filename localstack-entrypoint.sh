#!/bin/sh
aws --endpoint-url http://localhost:4566 sqs create-queue --queue-name demo-queue --region ap-south-1
aws --endpoint-url http://localhost:4566 s3 mb s3://ams-farmrise-shared-data
aws --endpoint-url=http://localhost:4566 s3 ls