# authentication-service-that-returns-JWT

A Spring Boot service that authenticates a user via HTTP Basic Auth and
returns a signed JWT, matching this flow:

```
curl -s -u user:pwd http://localhost:8090/authenticate

{"token":"eyJhbGciOiJIUzI1NiJ9...."}
```

## How the 3 exercise steps map to the code

1. **Create authentication controller and configure it in SecurityConfig**
   - `controller/AuthenticationController.java` exposes `GET /authenticate`.
   - `config/SecurityConfig.java` wires that endpoint into the filter chain and
     requires HTTP Basic Auth on it via `.httpBasic(Customizer.withDefaults())`.

2. **Read Authorization header and decode the username and password**
   - Handled automatically by Spring Security's Basic Auth filter, which reads
     the `Authorization: Basic <base64>` header, decodes it, and authenticates
     the credentials against the `UserDetailsService` / `AuthenticationManager`
     defined in `SecurityConfig`. By the time `authenticate()` runs, the
     resolved user is available as the `Authentication` parameter.

3. **Generate token based on the user retrieved in the previous step**
   - `util/JwtUtil.java` signs a JWT (HS256) with the authenticated username as
     the subject, using `io.jsonwebtoken` (jjwt).

## Demo credentials

Configured in `src/main/resources/application.properties`:

```
app.demo-user.username=user
app.demo-user.password=pwd
```

Change these (and the JWT secret) before using this anywhere real.

## Requirements

- Java 17+
- Maven 3.6+ (or use the included wrapper if you add one)

## Run it

```bash
cd authentication-service-that-returns-JWT
mvn spring-boot:run
```

The service starts on port `8090` (configured in `application.properties`).

## Test it

```bash
curl -s -u user:pwd http://localhost:8090/authenticate
```

Expected response:

```json
{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzE5Nzc4ODAwLCJleHAiOjE3MTk3ODI0MDB9.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"}
```

With wrong credentials you'll get a `401 Unauthorized` instead.

## Build a jar

```bash
mvn clean package
java -jar target/authentication-service-that-returns-jwt-1.0.0.jar
```

## Project layout

```
authentication-service-that-returns-JWT/
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java/com/example/jwtauth
    │   │   ├── JwtAuthServiceApplication.java
    │   │   ├── config/SecurityConfig.java
    │   │   ├── controller/AuthenticationController.java
    │   │   ├── dto/JwtResponse.java
    │   │   └── util/JwtUtil.java
    │   └── resources/application.properties
    └── test/java/com/example/jwtauth/JwtAuthServiceApplicationTests.java
```
