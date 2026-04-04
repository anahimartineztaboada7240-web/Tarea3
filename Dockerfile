FROM gradle:8-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/app.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]