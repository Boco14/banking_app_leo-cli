# BANKING APP - LEO
---

# 💳 Banking App CLI

A lightweight **command-line banking application** built in **Java** with **MySQL integration**.  
Designed as a **school project** and **portfolio piece**, this app demonstrates core banking operations, database connectivity, and clean coding practices.

---

## 🎯 Purpose
- **For end-users:** A simple way to simulate banking operations locally.  
- **For recruiters:** Showcases backend development, database integration, and CLI design skills.  
- **For classmates:** A collaborative learning project to explore Java, Spring Boot, and MySQL.  

---

## 🚀 Features
- Create, update, and delete user accounts  
- Deposit and withdraw funds  
- Transfer money between accounts  
- View balances and transaction history  
- Secure persistence with MySQL  

---

## 🛠️ Tech Stack
- **Java 17+**  
- **Maven** (build & dependency management)  
- **MySQL** (database)  
- **Spring Boot** (optional REST API extension)  

---

## 📦 Installation
```bash
# Clone the repository
git clone https://github.com/your-username/banking_app_leo-cli.git
cd banking_app_leo-cli

# Build with Maven
mvn clean install

# Run the app
java -jar target/banking_app_cli.jar
```

---

## ⚙️ Configuration
Update your database credentials in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gcashappdb
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

## 🧪 Usage Examples
```bash
# Create account
create-account --name "Leo" --initialDeposit 1000

# Deposit
deposit --accountId 1 --amount 500

# Transfer
transfer --from 1 --to 2 --amount 200
```

---

## 📖 Learning Goals
- Practice **Java + MySQL integration**  
- Explore **Spring Boot REST APIs**  
- Apply **best practices** in CLI design and database security  
- Build a **portfolio-ready project** for recruiters and classmates  

---

## 🤝 Contributing
This project is part of a school portfolio. Contributions are welcome for improvements, bug fixes, or feature suggestions.  

---

## 📜 License
Licensed under the MIT License.

---

Would you like me to **add badges and a sample screenshot section** so your README looks more professional for recruiters?
