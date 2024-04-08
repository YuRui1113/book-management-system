#!/bin/bash
BASEDIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

namespace=$1
if [ -z "$namespace" ]
then
  echo "No namespace supplied, enter the namespace value:"
  read namespace
fi

echo "Namespace is $namespace"

### create PersistentVolumeClaim for postgres database ###
kubectl create -f ${BASEDIR}/pvc.yaml -n $namespace
echo "PersistentVolumeClaim was created for postgres database"

### create deployment for postgres database ###
kubectl apply -f ${BASEDIR}/deployment.yaml -n $namespace
echo "Deployment was created for postgres database"

### create service for postgres database ###
kubectl create -f ${BASEDIR}/service.yaml -n $namespace
echo "Service was created for postgres database"