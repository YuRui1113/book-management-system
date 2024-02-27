# Book Management System
 
## Overview
The book mangement system  include  two applications:
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
- Run Rest-API

At your local environment, you can follow below steps to run Rest-API:
1. Install JRE for java 17
2. Run Rest-API by below command:
```
java -jar rest-api-0.0.1-SNAPSHOT.jar
```

- Run Web Front

The package which above step builds can be run in a web server. Ex. Nginx
1. Install Nginx web server on your machine
2. Deploy above build package to Nginx
3. Run Nginx

At your local environment, there is another convenient way which uses Angular CLI to run
```
ng serve
```
Then you can acess it by http://localhost:4200.

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

The you can use these images to create container instance on cloud like Azure.