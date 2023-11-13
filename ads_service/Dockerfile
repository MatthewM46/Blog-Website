FROM maven:3.9 AS build

COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn package -DskipTests

FROM openjdk:22-slim
COPY --from=build target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]