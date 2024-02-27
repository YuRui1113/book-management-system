# Book Management System
 
## Overview
The book management system  includes  two applications:
- Rest-API which developed using Spring Boot, code path /rest-api
- Web Front application which developed using Angular, code path /WebFront

## How To Build
- Build Rest-API using Apache Maven

Enter the project root directory and run below command: 
```
mvn clean package
```
It will generate a jar named 'rest-api-0.0.1-SNAPSHOT.jar' in /target folder.

- Build Web Front using Angular CLI

Enter the project root directory and run below command: 
```
ng build -c production
```
It will generate the build package in /dist/web-front folder.

## How To Run
For run application on local environment, must follow below steps:
- Create a PostgreSQL database on your local machine

The data source configuration is in application-local.yml, if it is different from your current setting, change this file and rebuild.

- Run Rest-API

At your local environment, you can follow below steps to run Rest-API:
1. Install JRE for java 17
2. Enter the build jar folder '/target' and run Rest-API by below command:
```
java -jar rest-api-0.0.1-SNAPSHOT.jar
```

- Run Web Front


At your local environment, the convenient way is using Angular CLI, make sure your have installed Angular CLI on your machine. Enter the project root directory and use below command to run Web Front application:
```
ng serve
```
Then you can view it by http://localhost:4200.

Another way to run Web Front is using the above build package which  can be run in a web server. Ex. Nginx. If you have Nginx, you can use below steps to run:
1. Install Nginx web server on your machine
2. Deploy above build package in '/dist/web-front' folder to Nginx
3. Run Nginx

## How To Test
Both applications provide unit test cases.
- Test Rest-API

Enter the project root directory and run below command: 
```
mvn test
```

- Test Web Front

Enter the project root directory and run below command: 
```
ng test
```

Manually test can operate on http://localhost:4200 by browser.

## Prepare container image for cloud deployment

Both applications provide a Dockerfile which can be used to create container image, below steps is for building image and push to registry:

- Enter the project root directory
- Run below command to build image:
```
docker build -t tagname .
```
The tagname is 'docker.io/yurui113/rest-api' for Rest-API, and 'docker.io/yurui113/angular-web-front' for Web Front.

- Login to docker hub with below command:
```
docker login
```

- Push image to docker public registry
```
docker push tagname
```

Then you can use these images to create container instance on cloud like Azure.