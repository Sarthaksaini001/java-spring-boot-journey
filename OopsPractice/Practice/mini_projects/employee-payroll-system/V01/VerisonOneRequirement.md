# Prompt I used :-
"I am embarking on a comprehensive journey to master Object-Oriented Programming in Java. I need a curriculum of incremental coding challenges that transition from fundamental syntax to high-level design patterns.
Please generate a series of 'Level Up' tasks. For each task:
* Concept Focus: Target a specific area (e.g., Method Overriding vs. Overloading, Interface Default Methods, or Composition).
* The Challenge: Provide a real-world scenario (e.g., a Banking System or a Smart Home Hub).
* Refactoring Goal: After I solve it, I want you to ask me to refactor the code to be more extensible, simulating a professional environment where requirements change.
Begin at Level 1: Object State and Behavior. Provide a challenge that tests my understanding of constructors and access modifiers."



# Claude Rquirement given for Version 1.0
# Java OOP Mastery: Level-Up Curriculum

I'm excited to guide you through this journey! Your systematic approach and C++ background will serve you well as we build increasingly sophisticated Java systems.

---

## **Level 1: Object State and Behavior**

### **Concept Focus**
- Constructor overloading and initialization patterns
- Access modifiers (`private`, `public`, `protected`, package-private)
- Encapsulation principles
- Instance vs. class members
- Immutability basics

### **The Challenge: Employee Payroll System**

You're building a payroll system for a mid-sized company. The system needs to track employees with different employment types and calculate their monthly compensation.

#### **Requirements:**

**Part 1: Core Implementation**

Create an `Employee` class that:

1. **Stores essential employee data:**
   - Employee ID (should never change after creation)
   - Full name
   - Department
   - Base salary
   - Years of service

2. **Enforces business rules:**
   - Employee ID must be exactly 6 characters (e.g., "EMP001")
   - Base salary cannot be negative
   - Years of service cannot be negative
   - Name and department cannot be null or empty

3. **Provides multiple construction paths:**
   - A new hire (ID, name, department, salary) - defaults years of service to 0
   - An existing employee being imported from legacy system (all fields)

4. **Calculates monthly compensation:**
   - Base salary + loyalty bonus (2% of base salary per year of service, capped at 20%)
   - Provide a method to get gross monthly pay

5. **Supports safe data access:**
   - Allow reading all employee information
   - Allow updating department (promotions/transfers)
   - Allow incrementing years of service (annual review)
   - Prevent direct modification of ID and salary after creation

6. **Provides meaningful string representation:**
   - Override `toString()` to show employee details in a readable format

#### **Part 2: Testing Your Design**

Create a `PayrollDemo` class with a `main` method that:
- Creates at least 3 employees using different constructors
- Demonstrates proper encapsulation by attempting (and failing) invalid operations
- Simulates a department transfer
- Simulates an annual review (incrementing service years)
- Prints employee details and calculates total monthly payroll

#### **Validation Test Cases:**

Your implementation should handle these scenarios:
```java
// Should throw exception or handle gracefully
new Employee("EMP1", "John Doe", "IT", 5000);  // Invalid ID format
new Employee("EMP001", "", "IT", 5000);        // Empty name
new Employee("EMP001", "Jane", "HR", -1000);   // Negative salary
```

---

### **Starter Code Structure:**

```java
public class Employee {
    // Define your fields here
    
    // Constructor for new hires
    
    // Constructor for legacy imports
    
    // Business logic methods
    
    // Getter/setter methods following encapsulation principles
    
    // toString override
}

public class PayrollDemo {
    public static void main(String[] args) {
        // Your test implementation
    }
}
```

---

### **What I'm Looking For:**

1. **Proper field declarations** with appropriate access modifiers
2. **Constructor chaining** (if you use it - there are multiple valid approaches)
3. **Validation logic** in constructors or setters
4. **Defensive copying** considerations (especially for mutable fields if you add them)
5. **Clear method contracts** - what can and cannot be modified

---

### **Hints from Your C++ Experience:**

- Java doesn't have `const` - you'll use `final` for fields that shouldn't change after construction
- No destructors needed - garbage collection handles cleanup
- All objects are heap-allocated (no stack objects like C++)
- String comparison uses `.equals()`, not `==`

---

**Take your time with this challenge.** Once you've implemented and tested your solution, share your code with me. I'll review it for:
- Encapsulation quality
- Design decisions
- Edge case handling

Then I'll introduce **Level 1 Refactoring Challenge** where a new business requirement will test the extensibility of your design!

Good luck! 🚀