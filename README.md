## ms-book-management

#### Technologies

-  Java 17 (corretto-17.0.10)
-  Maven 3.9.5
- SpringBoot 3.2.2
- Spring Security (Basic Auth in memory)
- JPA with H2 database
- JaCoCo 0.8.8
- JUnit 5
- Swagger
- SonarLint
- Postman
- Lombok
- Docker


# Run locally (Docker)

It is suggested to use Docker, the project has a ready dockerfile.

Steps:

1. docker build -t ms-book-management-image .
2. docker run -d -p 8080:8080 --name ms-book-management-container ms-book-management-image

# Run locally (as SpringBoot proyect)

Compile with maven: mvn clean package and run java -jar ms-book-management-1.0.0-SNAPSHOT.jar

From an ide: ensure lombok is installed and run directly from the ide as a spring boot project

#Endpoint Swagger

**In local enviromen**t: http://localhost:8080/swagger-ui.html
**User**: manageuser
**Password**: managepwd

# Endpoints API

This project has 3 endpoints (post, get, delete) which are ready to be executed through the postman collection "Bookmanagement" in the "PostMan" folder.

**User**: manageuser
**Password**: managepwd

#JaCoCo - SonarLint

In the "coverage" folder there is evidence of jacoco coverage, also evidence of statistical code analysis with SonarLint

#DataBase

The user and password are in the microservice properties file, the console view is enable.
The database is "bookdb" and the table is "book".



