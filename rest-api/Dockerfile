FROM openjdk:17-jdk-alpine

LABEL org.opencontainers.image.authors="yurui_113@hotmail.com"

COPY target/rest-api-0.0.1-SNAPSHOT.jar rest-api-0.0.1-SNAPSHOT.jar

#ENTRYPOINT ["java","-jar","/rest-api-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/rest-api-0.0.1-SNAPSHOT.jar"]