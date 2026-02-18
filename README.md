# SKILL-5 — Spring Autowiring Demo using @Autowired (Ready-to-Run)

## What this project demonstrates
- `Student` has a `Certification` object.
- Both classes are annotated with `@Component`
- `Certification` is injected into `Student` using `@Autowired` (Constructor Injection)
- Component scanning is enabled using Java Config (`@Configuration` + `@ComponentScan`)
- A main class loads the IoC container and prints the injected values.

## Prerequisites
- Java 17+
- Maven 3.8+

## How to Run (VS Code Terminal / Command Prompt)
Open terminal inside the folder that contains `pom.xml`, then run:

```bash
mvn clean compile exec:java
```

## Output (Sample)
You will see `Student` details and the injected `Certification` details printed.

## GitHub Push Tip
If you want this as a separate branch (example: `skill05`):
```bash
git checkout -b skill05
git add .
git commit -m "Skill-5: Spring Autowiring with @Autowired"
git remote add origin <YOUR_REPO_URL>   # only if not already added
git push -u origin skill05
```
