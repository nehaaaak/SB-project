# Use an official Maven image to build the project
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy all files into the container
COPY . .

# Build the Spring Boot app (creates target/*.jar)
RUN mvn clean package -DskipTests

# --- Production image ---
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy only the built jar from the previous image
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
