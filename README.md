# 🧩 Proxy-Based Department Service

This Java Spring Boot project implements the **Proxy Design Pattern** to manage access to department data. It dynamically switches between a live database and a JSON backup file to ensure continued functionality even when the database is unavailable.

## 📌 Features

- ⚙️ Automatic fallback to JSON backup if DB is unavailable
- 📄 Read-only mode when using the backup
- 🔗 Seamless integration via a proxy service layer
- ✅ Full CRUD support when the database is active
- 🚫 Disable write operations in fallback mode
- 📂 Backup stored as a local JSON file

## 🔧 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Jackson (for JSON parsing)**
- **H2/MySQL (depending on configuration)**
- **Maven**

## 🧩 Proxy Design Pattern Components

| Component                | Description                                                        |
|--------------------------|--------------------------------------------------------------------|
| `ProxyDepartmentService` | Acts as a proxy between the client and the real/fallback services |
| `DepartmentServiceImpl`  | Main service for DB operations                                     |
| `JsonDepartmentService`  | Read-only fallback service using a local JSON file                 |
| `BackupDepartmentService`| Loads backup data using Jackson                                    |

## 🧠 Use Case

The Proxy Pattern is applied to ensure the web application:
- Functions even when the database is down
- Provides read-only data access from a cached source
- Avoids changes to the client code (controllers remain unaware of the source switch)


