FROM openjdk:8-jdk-alpine

COPY ./build/libs/connect-portal-delete-service.jar app.jar
COPY ./entrypoint.sh entrypoint.sh
EXPOSE 8080
ENTRYPOINT ["/bin/sh","entrypoint.sh"]