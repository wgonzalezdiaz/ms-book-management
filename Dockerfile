FROM maven:latest as BUILD
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/ms-book-management-1.0.0-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","ms-book-management-1.0.0-SNAPSHOT.jar"]