# 🌐 DigitalBehaviorSystem

> *"In the 5G era, the device is the same — but the behavior defines the future."*

A Java OOP project that analyzes how people use their screen time in the post-5G era — classifying their digital behavior, ranking them by productivity, and saving a full report to disk.

---

## 👨‍💻 Author

**Karesh S** — [@leo10zephyr-tech](https://github.com/leo10zephyr-tech)  
B.Tech Computer Science | Java OOP Project | CS Department

---

## 💡 The Problem This Solves

After 5G arrived, everyone got faster internet. But the real question is —  
**are people using that speed to grow, or to scroll?**

This system takes real input about daily screen time across 4 categories:
- Productive Apps (AI tools, Learning, Work)
- Social Media (Instagram, Twitter, etc.)
- Entertainment (Netflix, YouTube, Gaming)
- Communication (WhatsApp, Email, Calls)

And classifies each user's digital behavior with a score, risk level, personalized advice, and a productivity leaderboard.

---

## 🏗️ Project Structure

```
DigitalBehaviorSystem/
│
├── MainApp.java                        ← Entry point, runs everything
│
├── core/
│     ├── Person.java                   ← Base class (Encapsulation)
│     ├── DigitalUser.java              ← Child class (Inheritance + Interface + Comparable)
│     ├── UsageProfile.java             ← Stores screen time data + Enum
│     ├── Analyzer.java                 ← Abstract class (Abstraction)
│     └── Reportable.java              ← Interface (Contract)
│
├── services/
│     ├── ClassificationService.java    ← Extends Analyzer (Polymorphism)
│     └── FileService.java             ← Saves report to file (File I/O)
│
└── utils/
      ├── InputValidator.java           ← Static utility, input validation + Regex
      └── InvalidUserDataException.java ← Custom Exception (Industry pattern)
```

---

## 🧠 OOP Concepts Covered

| Concept | File | What It Does |
|---|---|---|
| **Encapsulation** | `Person.java` | Private fields, public getters/setters |
| **Inheritance** | `DigitalUser extends Person` | Child gets all parent properties |
| **Abstraction** | `Analyzer.java` | Abstract class forces child to implement analyze() |
| **Polymorphism** | `ClassificationService.java` | Overrides abstract analyze() with real behavior |
| **Interface** | `Reportable.java` | Contract — generateSummary, getRiskLabel, getScore |
| **Custom Exception** | `InvalidUserDataException.java` | Domain-specific error handling |
| **Enum** | `UsageProfile.java` | DominantCategory — fixed set of behavior types |
| **Static Members** | `DigitalUser.totalUsers` | Shared counter across all instances |
| **Comparable** | `DigitalUser.compareTo()` | Auto-sorts users by productivity score |
| **Collections** | `MainApp.java` | List<DigitalUser> + Collections.sort() |
| **File I/O** | `FileService.java` | Writes full report to output/report.txt |
| **Exception Handling** | `MainApp + FileService` | try-catch for bad input and file errors |
| **Regex** | `InputValidator.java` | Pattern matching for name and email |

---

## ⚙️ How to Run

### Prerequisites
- Java JDK 11 or above
- VS Code with Extension Pack for Java

### Check Java is installed
```bash
java -version
```

### Step 1 — Clone the repo
```bash
git clone https://github.com/leo10zephyr-tech/DigitalBehaviorSystem.git
cd DigitalBehaviorSystem
```

### Step 2 — Create output folders
```bash
mkdir -p out output
```

### Step 3 — Compile
```bash
javac -d out MainApp.java core/Person.java core/Reportable.java core/UsageProfile.java core/Analyzer.java core/DigitalUser.java services/ClassificationService.java services/FileService.java utils/InvalidUserDataException.java utils/InputValidator.java
```

### Step 4 — Run
```bash
java -cp out MainApp
```

---

## 📊 Sample Output

```
=============================================
   DIGITAL BEHAVIOR ANALYZER - Post 5G
   OOP Java Project | CS Department
=============================================

--- Enter User Details ---
Full Name     : Karesh S
Age           : 20
Email         : karesh@gmail.com

--- Daily Screen Time in hours per day ---
Productive Apps  : 6
Social Media     : 2
Entertainment    : 1
Communication    : 1

User added: [Karesh S | Age: 20 | Screen: 10.0h/day | Score: 60.0%]
Risk Status : LOW RISK

==============================================
        ANALYSIS REPORT - ALL USERS
==============================================

User   : Karesh S
Age    : 20 (Young Adult)

Productive    [###############----------] 6.0h
Social Media  [######-------------------] 2.0h
Entertainment [###----------------------] 1.0h
Communication [###----------------------] 1.0h

Productivity Score : 60.0%
Behavior Type      : Digital Achiever
Insight            : Excellent - keep using AI and learning tools!
Risk Level         : LOW - Healthy usage pattern

============= PRODUCTIVITY LEADERBOARD =======
  #1  Karesh S        Score:  60.0%   LOW RISK
  #2  Test User       Score:  10.0%   HIGH RISK

  TOP PERFORMER   : Karesh S
  NEEDS ATTENTION : Test User
==============================================

Report saved to: output/report.txt
```

---

## 🏷️ Behavior Classifications

| Behavior Type | Condition | Risk Level |
|---|---|---|
| 🚀 Digital Achiever | Productive dominant + score > 60% | SAFE |
| 📈 Moderate Productive | Productive dominant + score < 60% | LOW |
| 📱 Social Overuser | Social dominant + score < 20% | HIGH |
| 🌐 Social-Leaning | Social dominant + score > 20% | MEDIUM |
| 🎮 Entertainment-Hooked | Entertainment dominates | HIGH |
| 🤝 Connector | Communication dominates | LOW/MEDIUM |
| ⚖️ Digitally Balanced | All categories roughly equal | MEDIUM |

---

## 🔄 Program Flow

```
START
  │
  ▼
Enter Name → Age → Email
  ├── Invalid? → throws InvalidUserDataException → skip
  │
  ▼
Enter screen time for 4 categories
  │
  ▼
UsageProfile created → stored in DigitalUser
  │
  ▼
Add more users? → loop / continue
  │
  ▼
Collections.sort() → ranks by productivity (Comparable)
  │
  ▼
ClassificationService.analyze() for each user
  ├── Bar chart
  ├── Productivity Score %
  ├── Behavior Type + Advice
  └── Risk Level
  │
  ▼
Leaderboard printed → Top Performer vs Needs Attention
  │
  ▼
FileService saves report → output/report.txt
  │
  ▼
END → git push to GitHub
```

---

## 📁 Output File

After every run, a full report is saved to:
```
output/report.txt
```

To read it:
```bash
cat output/report.txt
```

---

## 🐙 Git Workflow Used

```bash
git init
git add .
git commit -m "feat: DigitalBehaviorSystem - Java OOP Post-5G Analyzer"
git remote add origin https://github.com/leo10zephyr-tech/DigitalBehaviorSystem.git
git branch -M main
git push -u origin main
```

For every update:
```bash
git add .
git commit -m "describe what you changed"
git push
```

---

## 📌 Why This Project Stands Out

| Normal Java Project | This Project |
|---|---|
| 1-2 classes | 10 files across 4 packages |
| Basic print statements | Bar chart + Leaderboard |
| No input validation | Custom Exception class |
| No file handling | Saves report to disk |
| 2-3 OOP concepts | All 4 pillars + Interface + Comparable + Enum + Collections |
| No version control | Full GitHub commit history |

---

## 📜 License

This project is open source and available for educational use.

---

*Built with Java | Powered by OOP | Hosted on GitHub*
