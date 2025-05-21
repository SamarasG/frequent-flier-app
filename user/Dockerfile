# user/Dockerfile
FROM openjdk:21-jdk

WORKDIR /app

COPY ./target/user-1.0.0-SNAPSHOT-runner.jar user-service.jar

EXPOSE 8082

CMD ["java", "-jar", "user-service.jar"]
