FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/authentication.jar auth-microservice.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/auth-microservice.jar"]
