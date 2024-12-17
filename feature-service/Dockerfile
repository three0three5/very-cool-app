FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./build/libs/feature-service.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]