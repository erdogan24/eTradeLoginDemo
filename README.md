🎮 eTradeLoginDemo

A small project built with a layered architecture that simulates a user registration and login system. 
It demonstrates sign-up, login, verification, email sending (mock), and external service integration (Google adapter) through console outputs.

🎯 Purpose of the Project

This project was created to demonstrate business logic, validation rules, and layered software design without needing a real database or external service.
It focuses on:
	•	User management (registration, login, listing)
	•	Validation rules (email format, password length, name/surname control)
	•	Simulated email service and external login integration

⚙️ What It Does
	•	👤 User Management – Add, update, delete, and fetch users through UserManager
	•	✅ Validation Rules – AuthManager + BusinessRules handle:
	•	Email format validation (regex)
	•	Minimum password length (6 characters)
	•	Minimum name/surname length (2 characters)
	•	📩 Email Simulation – EmailManager.send() prints “email sent” to console
	•	🔌 External Login (Adapter Example) – GoogleAuthManagerAdapter simulates Google login
	•	🗄️ Mock Data Access – HibernateUserDao runs with an in-memory list of users

Example flow: A user is created in Main.java → register() runs the business rules → 
if valid, registration succeeds and a “verification email” message appears → login() validates login credentials → Google login is simulated using the adapter.

🧱 Architecture (Packages)
entities/         -> User entity
dataAccess/       -> UserDao (abstract), HibernateUserDao (mock data)
business/         -> AuthService, UserService, EmailService (interfaces)
                    AuthManager, UserManager, EmailManager (implementations)
core/             -> BusinessRules (validation helper), adapters/ (Google adapter)
googleAuth/       -> GoogleAuthManager (stub)
Main.java         -> demo scenario

🚀 How to Run
	1.	Make sure you have JDK 8+ installed.
	2.	Import the project into your IDE (IntelliJ/Eclipse) or compile manually:

  javac -d out $(find eTradeLoginDemo -name "*.java")
  java -cp out eTradeLoginDemo.Main

  	3.	You’ll see console outputs showing registration, login, email, and adapter actions.

🧪 Example Scenario (from Main.java)
	•	User("Erdogan", "Akpolat", "erdo98@gmail.com", "435455") is created
	•	authService.register(user) → applies validation rules → if valid → success + verification email
	•	authService.login(email, password) → login success/failure message
	•	googleAuthService.login(...) → Google login simulation
