# SKILL-4 — Spring Dependency Injection (Constructor & Setter)

This is a **Spring Core (NO Spring Boot)** project demonstrating:
- Constructor Injection (all fields)
- Setter Injection (at least 2 fields)
- XML Configuration
- Annotation / Java-based Configuration

## Project Structure
- `Student` (POJO)
- `applicationContext.xml` (XML config)
- `XmlMain` (loads XML container)
- `AppConfig` (Java config using @Configuration + @Bean)
- `AnnotationMain` (loads annotation container)

## Run (XML) — default
```bash
mvn compile exec:java
```

## Run (Annotations / Java Config)
```bash
mvn -Dexec.mainClass=com.skill4.di.AnnotationMain compile exec:java
```

## Output
Both mains print the injected values on the console.
