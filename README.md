📚 Library Management System for a Primary School in Rural Nepal

🧩 Overview
This project is a **Java-based Library Management System** designed for a **primary school in rural Nepal**.  
It provides a simple, offline solution for managing books, members, and borrowing operations using **CSV file storage**.  
The system follows **Object-Oriented Programming (OOP)** principles and was developed through **Agile sprints**.



🚀 Features
- Add, search, and manage books and members  
- Borrow and return books with availability tracking  
- Support for **Premium Members** with extended borrow limits  
- CSV-based data storage (no database required)  
- Simple console-based user interface  
- Unit and integration testing using **JUnit**



🧠 Technologies Used
| Tool / Framework | Purpose |
|------------------|----------|
| **Java** | Core programming language |
| **Maven** | Build automation and dependency management |
| **JUnit 5** | Unit and integration testing |
| **Git & GitHub** | Version control and collaboration |
| **CSV** | Lightweight data storage |
| **IntelliJ IDEA / VS Code** | Development environment |



🏗️ Project Structure
```
LibraryManagementSystem/
│
├── src/
│   ├── main/java/com/naps/Library/
│   │   ├── Book.java
│   │   ├── Member.java
│   │   ├── PremiumMember.java
│   │   ├── Borrowable.java
│   │   ├── Library.java
│   │   └── Main.java
│   │
│   └── test/java/com/naps/Library/
│       ├── LibraryTest.java
│       ├── BookTest.java
│       └── MemberTest.java
│
├── resources/
│   └── Book.csv
│
└── README.md


▶️ How to Run
1. Clone the repository
```bash
git clone https://github.com/<your-username>/LibraryManagementSystem.git
```

2. Navigate into the project
```bash
cd LibraryManagementSystem
```

3. Compile and run using Maven
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.naps.Library.Main"
```

---

🧪 Running Tests
```bash
mvn test
```

Tests include:
- Book and Member search  
- Borrow and return logic
- Member and premium memebr limit 
---

🧠 Development Process
The project was developed in **three Agile sprints**:
1. **Sprint 1:Core classes and project setup  
2. **Sprint 2:Logic implementation + testing  
3. **Sprint 3: UI + integration + refinements  

---

⚙️ Future Enhancements
- Add database support (MySQL/SQLite)  
- Develop a GUI or web-based interface  
- Implement overdue tracking and fine calculation  
- Add role-based access (Admin, Librarian, Student)  
- Enable cloud backup and analytics dashboard  

---

👥 Contributors
- **Padam** — Project Manager & Developer  
- **Suga10** — Developer   
- **Pranathasheh56** — UI Designer  

---

📄 License
This project is open-source and available under the **MIT License**.

---

## 🏫 Acknowledgment
Developed as part of an academic project for the **ITS 206 Software construction and Design**,  
Great Thanks to, 
Lecturer: Dr Brighter Agyemang



