# Stage 1: Build the Spring Boot application using Maven and OpenJDK 21
FROM openjdk:21-jdk-slim as build

WORKDIR /app
COPY pom.xml .
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Final runtime image
FROM openjdk:21-slim

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
