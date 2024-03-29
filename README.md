# Book Management System
 
## Overview
The book management system  includes  two applications:
- Rest-API which developed using Spring Boot, code path /rest-api
- Web Front application which developed using Angular, code path /WebFront

## How To Build

- Build preparation

Make sure install below softwares on your local machine:
1. Java JDK 17
2. Apache Maven 4.0.0-alpha-8 or above it
3. Angular CLI 16.0.1 or above it
4. NPM 9.6.4 or above it

- Build Rest-API using Apache Maven

Enter the project root directory and build Rest-API with below command: 
```
cd rest-api
mvn clean package
```
It will generate a jar named 'rest-api-0.0.1-SNAPSHOT.jar' in /target folder.

- Build Web Front using Angular CLI

Enter the project root directory and build Web Front with below command: 
```
cd WebFront
npm install
ng build -c development
```
It will generate the build package in /dist/web-front folder.

## How To Run
For run application on local environment, must follow below steps:
- Create a PostgreSQL database named 'book_database' on your local machine

You can use the default postgres account to create it with below using command line:
```
-- Login
psql -h localhost -U postgres
-- Create the database
CREATE DATABASE book_database;
```

- Run Rest-API

At project root folder, run Rest-API by below command:
```
cd target
java -jar rest-api-0.0.1-SNAPSHOT.jar
```
Verify the application running by view http://localhost:8080/api/v1/book?page=0&size=10.

- Run Web Front

At project root folder, run Web Front application by below command:
```
ng serve
```
Verify the application running by view http://localhost:4200.

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

## Run application on local using docker compose
At project root folder, run docker compose by below command:
```
docker commpose up -d
```