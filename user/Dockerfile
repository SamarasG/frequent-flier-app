FROM openjdk:17-jdk-slim



COPY ./target/user-1.0.0-SNAPSHOT.jar /user-service.jar

EXPOSE 8080
CMD ["java", "-jar", "/user-service.jar"]