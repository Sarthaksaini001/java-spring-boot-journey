<!-- filepath: /Users/sarthaksaini/java-spring-boot-journey/Practice/mini_projects/library-management-system/src/com/sarthaksaini/library/Readme.md -->
# 🎯 Mini Project: Library Management System

## 📚 **Project Overview**

Build a **Library Management System** that manages different types of books with borrowing functionality.

---

## 🎓 **Concepts You'll Apply**

✅ **OOP Basics** - Classes and Objects  
✅ **Encapsulation** - Private fields with getters/setters  
✅ **Constructors** - Initialize objects  
✅ **Inheritance** - Book types inherit from base Book class  
✅ **Method Overriding** - Custom behavior for each book type  

---

## 📋 **Project Requirements**

### **1. Parent Class: Book**

**Private fields:**
- `title` (String)
- `author` (String)
- `isbn` (String)
- `price` (double)
- `isAvailable` (boolean)

**Constructor:**
- Parameterized constructor to initialize all fields
- Validate: price must be positive

**Methods:**
- `borrowBook()` - If available, mark as unavailable and print success message. If not available, print error message
- `returnBook()` - Mark book as available and print success message
- `displayInfo()` - Print all book details (title, author, isbn, price, availability status)
- `getBookType()` - Return "General Book" (will be overridden by child classes)

**Getters:**
- Create getters for all private fields

---

### **2. Child Class: FictionBook** (extends Book)

**Additional private field:**
- `genre` (String) - e.g., "Fantasy", "Mystery", "Romance"

**Constructor:**
- Accept all Book fields + genre
- Use `super()` to call parent constructor
- Initialize genre

**Getter:**
- `getGenre()` - Return the genre

**Override Methods:**
- `getBookType()` - Return "Fiction"
- `displayInfo()` - Call parent's displayInfo() using `super.displayInfo()`, then print genre

---

### **3. Main Class: LibraryManagementSystem**

**Create objects and test functionality:**

1. **Create Book objects** - Instantiate at least 2 Book objects
2. **Create FictionBook objects** - Instantiate at least 2 FictionBook objects
3. **Test displayInfo()** - Display information for both book types
4. **Test borrowBook()** - Borrow an available book
5. **Test error handling** - Try borrowing an already borrowed book
6. **Test returnBook()** - Return a borrowed book
7. **Test price validation** - Create a book with negative price
8. **Test all getters** - Verify all getter methods work correctly

---

## 🚀 **How to Run**

### **Compile the project:**
```bash
javac src/com/sarthaksaini/library/*.java
```

### **Run the main class:**
```bash
java -cp src com.sarthaksaini.library.LibraryManagementSystem
```

---

## 📂 **Project Structure**

```
library-management-system/
├── src/
│   └── com/
│       └── sarthaksaini/
│           └── library/
│               ├── Book.java
│               ├── FictionBook.java
│               ├── LibraryManagementSystem.java
│               └── Readme.md
```

---

## ✅ **Expected Output**

The program should:
- ✅ Display book information for both general and fiction books
- ✅ Successfully borrow available books
- ✅ Show error when trying to borrow unavailable books
- ✅ Successfully return borrowed books
- ✅ Handle invalid price input (negative values)
- ✅ Demonstrate all getter methods working correctly

---

## 🎯 **Learning Outcomes**

After completing this project, you will understand:
- How to create and use classes in Java
- How to implement encapsulation using private fields and getters
- How to use constructors to initialize objects
- How inheritance works with `extends` keyword
- How to override methods in child classes
- How to use `super` to call parent class methods and constructors
- How to validate input in constructors
- How to organize Java projects with packages

---

## 🔧 **Future Enhancements**

Consider adding:
- Additional book types (NonFictionBook, ReferenceBook)
- A Library class to manage multiple books
- Search functionality by title, author, or ISBN
- Due date tracking for borrowed books
- Late fee calculation
- User/Member management system

---

## 👨‍💻 **Author**

Sarthak Saini

---

## 📅 **Date**

January 2026