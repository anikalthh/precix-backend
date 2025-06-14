FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/image-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
