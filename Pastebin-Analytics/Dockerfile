FROM gradle:8.5.0-jdk17 AS build
LABEL authors="cryptotradercheese"
WORKDIR /app
COPY . .
RUN gradle bootJar

FROM openjdk:17-jdk-alpine
COPY --from=build /app/build/libs/*.jar /app/AnalyticsApplication.jar
ENTRYPOINT ["java", "-jar", "/app/AnalyticsApplication.jar"]