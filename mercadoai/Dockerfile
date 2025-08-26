# syntax=docker/dockerfile:1

# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render expone el puerto en la variable de entorno $PORT
EXPOSE 8081

# Usa el puerto de Render o 8081 por defecto
ENV PORT=8081

ENTRYPOINT ["java", "-jar", "app.jar"]