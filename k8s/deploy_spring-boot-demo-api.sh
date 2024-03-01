#!/bin/bash

kubectl apply -f spring-boot-demo-api-cfgmap.yaml
kubectl apply -f spring-boot-demo-api-deployment.yaml
kubectl apply -f spring-boot-demo-api-service.yaml

