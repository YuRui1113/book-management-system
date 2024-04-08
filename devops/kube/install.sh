#!/bin/bash
BASEDIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
namespace=book

### working as k8s admin ###

### create book namespace ###
kubectl create -f ${BASEDIR}/resources/namespace.yaml
echo "Namespace \'$namespace\' was created."

### create local storage class ###
kubectl create -f ${BASEDIR}/resources/storage/storageClass.yaml
echo "Storage class was created."

### create PersistentVolume for postgres database ###
kubectl create -f ${BASEDIR}/resources/storage/pv.yaml
echo "PersistentVolume was created"

### create db configmaps ###
kubectl create -f ${BASEDIR}/resources/configmaps/db.yaml -n $namespace
kubectl create -f ${BASEDIR}/resources/configmaps/initsql.yaml -n $namespace
echo "Configmaps were created."

### create db secrets ###
kubectl create -f ${BASEDIR}/resources/secrets/db.yaml -n $namespace
echo "Secrets were created."

### installation for postgresql database ###
${BASEDIR}/postgresql/install.sh $namespace

### installation for rest API ###
${BASEDIR}/rest-api/install.sh $namespace

### installation for Angular web application ###
${BASEDIR}/web-front/install.sh $namespace

### create book ingress ###
kubectl create -f ${BASEDIR}/resources/ingress.yaml -n $namespace
echo "Ingress book was created."