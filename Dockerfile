# build
FROM maven:3-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# run
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/image-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
