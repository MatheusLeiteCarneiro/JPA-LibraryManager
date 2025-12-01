# 📚 Library Manager – JPA & Hibernate Project

A simple console-based application built to practice Jakarta Persistence API (JPA) with Hibernate, using an H2 in-memory database.
The system allows full CRUD operations for Authors and Books, demonstrating entity relationships, DAO patterns, transaction control, and basic persistence configuration.

---
## 🚀 Features

### Author Operations
* **Create new author**
* **List all authors**
* **Find author by ID and display their books**
* **Update author information**
* **Delete an author and cascade delete their books**

### Book Operations
* **Create new book**
* **List all books**
* **Find a book by ID**
* **Update book information**
* **Delete a book**

---

## 🗃️ Technologies Used
* **Java 25**
* **Jakarta Persistence (JPA 3.0)**
* **Hibernate**
* **H2 database**
* **Maven**

---

## ⚙️ How to Run

1.  Open your **Terminal** (or `Git Bash` on Windows).
2.  Navigate to the directory (folder) where you want to save the project.
3.  Clone the repository.
4. Import the project into your IDE.
5. Run the `Main.main()` method.

---

## 📁 Access H2 Database
* Open your browser.
* Go to 👉 http://localhost:8082

*(The H2 Console only works while the application is running, because the database is in-memory.)*

### 🔒 Login on H2
* Driver Class: **org.h2.Driver**
* JDBC URL: **jdbc:h2:mem:Library**
* User: **User**
* Password: *(leave empty)*

---

## 🧠 Purpose Of This Project
The main goal of this project was to practice and solidify essential **JPA & HIBERNATE** concepts by building a full **CRUD** application.
Additionally, the project serves as training in core Java, object-oriented programming, and fundamental database management concepts.

---

### ✏️ Author: **Matheus Leite Carneiro**
