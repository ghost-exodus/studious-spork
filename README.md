# SecureVault (Pepo Bank) - Advanced Console Banking System

**SecureVault** is a Java-based banking application re-engineered to demonstrate **Enterprise Backend Architecture**.

Unlike basic banking scripts, this project implements a strict **Layered Architecture**, separating **User Identity** from **Financial Assets**. It features a robust One-to-Many relationship model (One User -> Multiple Accounts) and a custom security layer.

## 🚀 Key Features

* **Layered Identity Management:**
    * **User Layer:** Manages authentication (Username/Password) and owns the portfolio.
    * **Account Layer:** Manages financial data (Balance, Type, Transactions).
    * **Relationship:** Implements a `1:N` (One-to-Many) relationship, allowing a single user to open and manage multiple accounts (Savings, Current, etc.) simultaneously.

* **Secure Authentication (Zero-Knowledge):**
    * Passwords are salted using the unique `username` and hashed via `Base64` encoding before storage.
    * Raw passwords are never stored in the database.
    * Login flow verifies the hash of the input against the stored hash.

* **Interactive Session Management:**
    * **Dynamic Account Selection:** Users can view their entire portfolio and select specific accounts to operate on.
    * **In-Memory Persistence:** A central `BankService` acts as the database, maintaining state for all users and their linked accounts during runtime.

## 🛠 Tech Stack & Concepts

* **Language:** Java (JDK 17+)
* **Architecture:** Layered (Controller -> Service -> Model)
* **Core Concepts:**
    * **Encapsulation:** Strict access control for account balances.
    * **Polymorphism:** Scalable account types (Savings/Current).
    * **Exception Handling:** Custom `FundsException` for business logic errors.
    * **Collections:** Heavy use of `ArrayList` and `HashMap` for data management.

## 📂 Project Structure

* **`Main.java` (The Controller):** Handles user input, login flow, and the "Account Selector" menu.
* **`BankService.java` (The Database):** A centralized service that maps `String username` -> `User` objects.
* **`User.java` (The Identity Model):** The "Owner" class. Holds the password hash and a `List<Bankaccount>`.
* **`Bankaccount.java` (The Asset Model):** The "Product" class. Holds the balance, account number, and bank type.
* **`SecurityUtils.java` (The Guard):** Handles the SHA-simulation and salting logic.

## 🗺️ Roadmap & Status

- [x] **Core Security:** Salted Password Hashing.
- [x] **Architecture Refactor:** Split `User` from `Account`.
- [x] **Scalability:** Implemented `ArrayList` for multi-account support.
- [x] **User Interface:** Added "Account Selector" menu (Choice 1...N).
- [ ] **Transfer System:** Peer-to-Peer money transfer (In Progress).
- [ ] **Data Persistence:** File I/O to save data after exit.

## ⚡ How to Run

1.  Compile the project:
    ```bash
    javac Main.java
    ```
2.  Run the application:
    ```bash
    java Main
    ```
3.  **Flow:**
    * **Register:** Create a username and your *first* account.
    * **Login:** Enter credentials.
    * **Select:** Choose an existing account OR select the option to **Open a New Account**.
    * **Transact:** Deposit, Withdraw, or Check Balance.

---
*Developed by [Your Name] - Backend Engineering Portfolio*