    # =========================
# Stage 1: Build
# =========================
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml first for better Docker layer caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build Spring Boot application
RUN mvn clean package -DskipTests


# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Create non-root user
RUN useradd -m appuser

# Copy application JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Give ownership to non-root user
RUN chown appuser:appuser app.jar

# Run application as non-root user
USER appuser

# Spring Boot default port
EXPOSE 8080

# Start Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

