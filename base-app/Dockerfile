FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./build/libs/base-app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]