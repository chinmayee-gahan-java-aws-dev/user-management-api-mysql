# User Management API - Spring Boot + MySQL + JPA

Production-ready REST API with database integration and API versioning.

## Key Features
- **MySQL + Spring Data JPA**: Full CRUD operations
- **API Versioning**: URI, Request Param, Header, Media Type, Custom - 5 approaches
- **Exception Handling**: Global @ControllerAdvice with custom exceptions  
- **JSON Filtering**: Dynamic field filtering with @JsonFilter
- **Internationalization**: i18n support via messages.properties
- **Seed Data**: data.sql for sample users

## Tech Stack
Java 17 | Spring Boot 3.x | Spring Data JPA | MySQL 8 | Maven

## How to Run
1. Update MySQL credentials in `src/main/resources/application.properties`
2. Run: `mvn spring-boot:run`
3. Test API: `http://localhost:8080/users`

## API Versioning Demo
GET `/v1/person` vs `/v2/person` vs Header `X-API-VERSION=2`