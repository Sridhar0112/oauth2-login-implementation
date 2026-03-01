Here is a clean, professional **README.md** tailored exactly to your Maven configuration and OAuth2 setup.

You can copy this directly into your repository.

---

# Spring Boot OAuth2 Login Demo

## 📌 Overview

This project demonstrates OAuth2 authentication using Spring Boot 4 and Spring Security. It secures application endpoints using OAuth2 login and allows selective public access.

The application uses `SecurityFilterChain` for configuring authentication rules.

---

## 🛠 Tech Stack

* Java 17
* Spring Boot 4.0.2
* Spring Security
* OAuth2 Client
* Maven

---

## 🔐 Security Configuration

* `/api/public` → Accessible without authentication
* All other endpoints → Require authenticated user
* OAuth2 login enabled using default Spring Security configuration

Example configuration:

```java
http.authorizeHttpRequests(auth -> 
    auth.requestMatchers("/api/public").permitAll()
        .anyRequest().authenticated()
).oauth2Login(Customizer.withDefaults());
```

---

## 📦 Dependencies Used

* spring-boot-starter-security
* spring-boot-starter-security-oauth2-client
* spring-boot-starter-webmvc
* spring-boot-starter-security-test
* spring-boot-starter-security-oauth2-client-test
* spring-boot-starter-webmvc-test

---

## ⚙️ Configuration

Add OAuth2 provider credentials inside:

`src/main/resources/application.properties`

Example (Google OAuth2):

```properties
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id:** your client ID**
            client-secret:** your client Secret**
            scope:
              - openid
              - profile
              - email
        provider:
          google:
            authorization-uri: https://accounts.google.com/o/oauth2/v2/auth
            token-uri: https://oauth2.googleapis.com/token
            user-info-uri: https://www.googleapis.com/oauth2/v3/userinfo
```

---

## 🚀 Running the Application

1. Clone the repository
2. Configure OAuth2 credentials
3. Run:

```bash
mvn spring-boot:run
```

4. Access:

Public endpoint:

```
http://localhost:8080/api/public
```

Secured endpoints:

```
http://localhost:8080/api/private
```

You will be redirected to the OAuth2 provider login page.

---

## 🔄 Authentication Flow

1. User accesses secured endpoint
2. Application redirects to OAuth2 provider
3. User authenticates
4. User is redirected back with authorized session

---

## 📂 Project Structure

```
src
 └── main
     ├── java
     │    └── com.example.OAuth2
     │         └── Config
     │              └── SecurityConfig.java
     └── resources
          └── application.properties
```

---

## 🧪 Testing

Security testing dependencies are included:

* OAuth2 client test support
* Spring Security test
* Web MVC test

Run tests using:

```bash
mvn test
```
