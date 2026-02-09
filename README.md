# Learn Spring Framework

A comprehensive learning project for Spring Framework fundamentals and Java OOP concepts.

## 📋 Project Overview

This repository contains:
- Spring Framework basics and dependency injection examples
- Java 8 features and Stream API practice
- Object-Oriented Programming (OOP) concepts
- Mini projects for hands-on practice

## 🗂️ File Structure and Contents

### Root Level
```
learn-spring-framework/
├── pom.xml                    # Maven project configuration
├── mvnw, mvnw.cmd            # Maven wrapper scripts
├── rewrite.yml               # OpenRewrite configuration
└── README.md                 # This file
```

### Main Application (`src/main/java/com/sarthak/learn_spring_framework/`)

**Core Files:**
- [`App01GamingBasic.java`](src/main/java/com/sarthak/learn_spring_framework/App01GamingBasic.java) - Basic gaming application without Spring
- [`App02HelloWoeldSpring.java`](src/main/java/com/sarthak/learn_spring_framework/App02HelloWoeldSpring.java) - Hello World with Spring Framework
- [`HelloWorldConfiguration.java`](src/main/java/com/sarthak/learn_spring_framework/HelloWorldConfiguration.java) - Spring configuration class

**Game Package (`game/`):**
- [`GameRunner.java`](src/main/java/com/sarthak/learn_spring_framework/game/GameRunner.java) - Game runner implementation
- [`GamingConsole.java`](src/main/java/com/sarthak/learn_spring_framework/game/GamingConsole.java) - Gaming console interface
- [`MarioGame.java`](src/main/java/com/sarthak/learn_spring_framework/game/MarioGame.java) - Mario game implementation
- [`SuperContraGame.java`](src/main/java/com/sarthak/learn_spring_framework/game/SuperContraGame.java) - Super Contra game implementation

### OOPs Practice (`OopsPractice/`)

#### Java 8 Features (`OopsPractice/Java8Features/`)
Stream API and functional programming examples:
- [`CountEvements.java`](OopsPractice/Java8Features/CountEvements.java) - Counting even elements
- [`CountOccurence.java`](OopsPractice/Java8Features/CountOccurence.java) - Counting occurrences in streams
- [`DistintCount.java`](OopsPractice/Java8Features/DistintCount.java) - Finding distinct elements
- [`EvenNumbers.java`](OopsPractice/Java8Features/EvenNumbers.java) - Filtering even numbers
- [`FilterAverage.java`](OopsPractice/Java8Features/FilterAverage.java) - Filtering and calculating averages
- [`FindFirst.java`](OopsPractice/Java8Features/FindFirst.java) - Finding first element in streams
- [`FinfLongestString.java`](OopsPractice/Java8Features/FinfLongestString.java) - Finding longest string
- [`OddSquare.java`](OopsPractice/Java8Features/OddSquare.java) - Odd number operations
- [`Practice.java`](OopsPractice/Java8Features/Practice.java) - General practice examples
- [`Problem02.java`](OopsPractice/Java8Features/Problem02.java) - Problem-solving exercises
- [`SimpleTransformation.java`](OopsPractice/Java8Features/SimpleTransformation.java) - Basic transformations
- [`SortLimit.java`](OopsPractice/Java8Features/SortLimit.java) - Sorting and limiting streams
- [`StringFiltering.java`](OopsPractice/Java8Features/StringFiltering.java) - String filtering operations
- [`StringJoining.java`](OopsPractice/Java8Features/StringJoining.java) - String joining with streams
- [`StringTranformation.java`](OopsPractice/Java8Features/StringTranformation.java) - String transformations
- [`SumAll.java`](OopsPractice/Java8Features/SumAll.java) - Summing elements
- [`TransformFilterSum.java`](OopsPractice/Java8Features/TransformFilterSum.java) - Combined operations

#### OOP Concepts (`OopsPractice/Practice/`)
Core OOP principles:
- [`ConstructorPractice.java`](OopsPractice/Practice/ConstructorPractice.java) - Constructor usage examples
- [`EncapsulationPractice.java`](OopsPractice/Practice/EncapsulationPractice.java) - Encapsulation concepts
- [`oops.java`](OopsPractice/Practice/oops.java) - General OOP examples

### Mini Projects (`OopsPractice/Practice/mini_projects/`)

#### Employee Payroll System
**Location:** `OopsPractice/Practice/mini_projects/employee-payroll-system/V01/`
- [`Employee.java`](OopsPractice/Practice/mini_projects/employee-payroll-system/V01/Employee.java) - Employee class implementation
- [`PayrollDemo.java`](OopsPractice/Practice/mini_projects/employee-payroll-system/V01/PayrollDemo.java) - Payroll system demonstration
- [`VersionOneRequirement.md`](OopsPractice/Practice/mini_projects/employee-payroll-system/V01/VersionOneRequirement.md) - Project requirements

#### Library Management System
**Location:** `OopsPractice/Practice/mini_projects/library-management-system/src/com/sarthaksaini/library/`
- [`Book.java`](OopsPractice/Practice/mini_projects/library-management-system/src/com/sarthaksaini/library/Book.java) - Book class
- [`FictionBook.java`](OopsPractice/Practice/mini_projects/library-management-system/src/com/sarthaksaini/library/FictionBook.java) - Fiction book subclass
- [`LibraryManagementSystem.java`](OopsPractice/Practice/mini_projects/library-management-system/src/com/sarthaksaini/library/LibraryManagementSystem.java) - Main system implementation
- [`Readme.md`](OopsPractice/Practice/mini_projects/library-management-system/src/com/sarthaksaini/library/Readme.md) - Project documentation

### Telstra Account System (`OopsPractice/src/com/telstra/account/`)
Mobile account management example:
- [`Customer.java`](OopsPractice/src/com/telstra/account/Customer.java) - Customer class
- [`MobilePlan.java`](OopsPractice/src/com/telstra/account/MobilePlan.java) - Mobile plan details
- [`TelstraAccountSystem.java`](OopsPractice/src/com/telstra/account/TelstraAccountSystem.java) - Account system implementation

### Tests (`src/test/java/com/sarthak/learn_spring_framework/`)
- [`LearnSpringFrameworkApplicationTests.java`](src/test/java/com/sarthak/learn_spring_framework/LearnSpringFrameworkApplicationTests.java) - Unit tests

### Build Output (`target/`)
Contains compiled classes and Maven build artifacts (auto-generated, not tracked in version control)

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Maven 3.6+

### Build the Project
```bash
./mvnw clean install
```

### Run Spring Application
```bash
./mvnw spring-boot:run
```

Or run specific classes:
```bash
java -cp target/classes com.sarthak.learn_spring_framework.App01GamingBasic
java -cp target/classes com.sarthak.learn_spring_framework.App02HelloWoeldSpring
```

## 📚 Learning Topics Covered

### Spring Framework
- Dependency Injection (DI)
- Spring Configuration
- Bean Management
- Gaming Console example with Spring

### Java 8 Features
- Lambda Expressions
- Stream API
- Functional Interfaces
- Method References

### OOP Concepts
- Encapsulation
- Inheritance
- Polymorphism
- Constructors
- Interfaces and Abstract Classes

### Mini Projects
- **Employee Payroll System**: Practice with classes, objects, and payroll calculations
- **Library Management System**: Book management with inheritance
- **Telstra Account System**: Customer and mobile plan management

## 📝 Notes

- The project structure follows Maven conventions
- Spring Framework examples demonstrate basic DI concepts
- Java 8 features section contains extensive Stream API practice
- Mini projects provide real-world application scenarios

## 🎯 Next Steps

- Add more Spring Boot features (REST APIs, JPA, etc.)
- Implement additional design patterns
- Add more comprehensive unit tests
- Explore Spring AOP and Transaction Management

---

**Happy Learning! 🚀**
