FROM openjdk:21-jdk-buster

WORKDIR /app

COPY target/docker-emo-V.1.0.jar app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]