# Use Java 17 (recommended for Spring Boot 3)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the application
RUN ./mvn clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/*.jar"]
