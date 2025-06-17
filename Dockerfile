# Dockerfile for Spring Boot Backend

# Stage 1: Build the Spring Boot application using Maven and OpenJDK 17
# Using a "builder" stage to create a smaller final image
FROM openjdk:21-jdk-slim as build

# Set the working directory inside the container for the build process
WORKDIR /app

# Copy the Maven project file (pom.xml) first. This allows Docker to cache the
# dependency download layer if the pom.xml doesn't change.
COPY pom.xml .

# Download project dependencies
# The -B (batch mode) option makes Maven non-interactive.
# dependency:go-offline downloads all dependencies required for the project.
RUN mvn dependency:go-offline -B

# Copy the rest of the application source code
COPY src ./src

# Build the Spring Boot application.
# clean: Cleans the target directory.
# package: Compiles, tests, and packages the code into a JAR file.
# -DskipTests: Skips running tests during the build.
#              Consider running tests in a separate CI/CD stage.
RUN mvn clean package -DskipTests

# --- Stage 2: Create the final, lean runtime image ---
# Use a minimal OpenJDK JRE image for the final application to keep image size small
FROM openjdk:21-jre-slim

# Set the working directory for the application
WORKDIR /app

# Copy the built JAR file from the 'build' stage into the /app directory of the final image.
# The JAR file typically follows the pattern <artifactId>-<version>.jar.
# We use *.jar to be flexible with the version.
COPY --from=build /app/target/*.jar app.jar

# Expose the port that Spring Boot's embedded Tomcat server listens on (default is 8080)
EXPOSE 8080

# Define the command to run the application when the container starts.
# 'java -jar app.jar' executes the Spring Boot application.
ENTRYPOINT ["java", "-jar", "app.jar"]
