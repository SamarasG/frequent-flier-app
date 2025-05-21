FROM openjdk:21-jdk

WORKDIR /app

COPY ./target/chat-1.0.0-SNAPSHOT-runner.jar chat-service.jar

EXPOSE 8083

CMD ["java", "-jar", "chat-service.jar"]