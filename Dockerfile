# Use official OpenJDK image as base
FROM openjdk:17-slim

# Install Python and Pillow
RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    pip3 install pillow && \
    apt-get clean

# Set working directory
WORKDIR /app

# Copy backend files (including your Python script)
COPY . .

# Build the Spring Boot app
RUN ./mvnw package -DskipTests

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/precix-backend.jar"]
