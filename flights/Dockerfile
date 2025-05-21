FROM openjdk:21-jdk

WORKDIR /app

COPY ./target/flights-1.0.0-SNAPSHOT-runner.jar flight-service.jar

EXPOSE 8084

CMD ["java", "-jar", "flight-service.jar"]