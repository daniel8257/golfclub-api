# Use the official OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Copy the Spring Boot jar file into the container
COPY target/golfclub-api.jar golfclub-api.jar

# Expose port 8080 for the application
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "golfclub-api.jar"]
