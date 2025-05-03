# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/flights-0.0.1-SNAPSHOT.jar /app/flight-service.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "/app/flight-service.jar"]