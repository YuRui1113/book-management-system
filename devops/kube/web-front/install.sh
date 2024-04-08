#!/bin/bash
BASEDIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

namespace=$1
if [ -z "$namespace" ]
then
  echo "No namespace supplied, enter the namespace value:"
  read namespace
fi

echo "Namespace is $namespace"

### create deployment for Angular web application ###
kubectl apply -f ${BASEDIR}/deployment.yaml -n $namespace
echo "Deployment was created for Angular web application"

### create service for Angular web application ###
kubectl create -f ${BASEDIR}/service.yaml -n $namespace
echo "Service was created for Angular web application"