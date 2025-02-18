FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/authentication-0.0.1.jar /app/auth-microservice.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/auth-microservice.jar"]
