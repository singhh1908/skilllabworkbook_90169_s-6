# curdop — Hibernate CRUD Operations (MySQL + VS Code)

## 1) Create Database (MySQL)
```sql
CREATE DATABASE retail_inventory;
USE retail_inventory;
```

## 2) Configure DB password
Edit:
`src/main/resources/hibernate.cfg.xml`

Replace:
```xml
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
```
with your real MySQL password (or keep empty if no password).

## 3) Run the project
From the project folder:
```bash
mvn clean compile exec:java
```

## 4) What this project includes
- Product entity mapped using JPA annotations
- Full CRUD (Create/Read/Update/Delete)
- ID Strategy demo:
  - AUTO  -> table: products_auto
  - IDENTITY -> table: products_identity
  - SEQUENCE -> table: products_sequence
Use menu option **7** to insert 1 row into each and print generated IDs.
