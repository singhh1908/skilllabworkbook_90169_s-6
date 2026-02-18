# Skill-3 — Working with HQL (Sorting, Pagination & Aggregates)

Extends **Skill-2** (Hibernate CRUD) and adds **HQL**:
- Sorting (price ASC/DESC, quantity DESC)
- Pagination (first 3, next 3)
- Aggregates (COUNT, MIN, MAX)
- GROUP BY (counts by description)
- WHERE (price range)
- LIKE (starts/ends/contains/exact length)

## Database
```sql
CREATE DATABASE retail_inventory;
USE retail_inventory;
```

## Configure MySQL password
Edit: `src/main/resources/hibernate.cfg.xml`

Replace:
```xml
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
```
with your password.

## Run
```bash
mvn compile exec:java
```

From main menu choose:
`8. Skill-3: HQL Operations`
