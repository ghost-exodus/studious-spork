Here is a cleaner, punchier version. It cuts the fluff and focuses on what the code actually does.

---

# SecureVault

**SecureVault** is a console-based banking system built to practice real backend security and architecture concepts in Java.

Most beginner projects store passwords as plain text. This project implements a **Salted Hashing** system from scratch to simulate how real databases protect user credentials. It separates the "Business Logic" (money) from the "Interface" (console), following clean coding principles.

## ⚡ What It Does

* **Secure Authentication:** Passwords are never stored directly. The system combines your password with your unique Account ID (the "Salt") and scrambles it using Base64 encoding. Even if two users have the password `12345`, their stored hashes will look completely different.
* **Smart Error Handling:** Instead of crashing or printing generic errors, the system throws a custom `FundsException` when a user tries to overdraw, allowing the main program to handle the error gracefully.
* **Instant Lookup:** Uses a `HashMap` structure to simulate a high-speed database for retrieving account details.

## 🛠 Project Structure

* **`Main.java`**: The user interface. Handles inputs and displays menus.
* **`BankService.java`**: The "Database Manager." Stores and retrieves accounts.
* **`Bankaccount.java`**: The core logic. Handles balances, deposits, and withdrawals.
* **`SecurityUtils.java`**: The encryption engine. Handles the salting and hashing logic.
* **`FundsException.java`**: A custom exception class for banking-specific errors.

## 🚀 How to Run

1. Compile the project:
```bash
javac Main.java

```


2. Run the application:
```bash
java Main

```


3. Follow the prompts to register a new account or log in with existing credentials.

---

*Built to demonstrate Core Java, OOP, and Backend Security fundamentals.*
