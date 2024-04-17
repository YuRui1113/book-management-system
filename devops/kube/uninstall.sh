#!/bin/bash
### working as k8s admin ###

### delete all in book namespace ###
kubectl delete ns book

### delete PersistentVolume for postgres database ###
kubectl delete pv postgres

### delete local storage class ###
kubectl delete storageclass taylor-local-storage