# Etapa de construcción
FROM maven:3.8.1-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package -DskipTests

# Etapa de ejecución
FROM openjdk:17-alpine

EXPOSE 9000

COPY --from=build /app/target/facturacion*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]