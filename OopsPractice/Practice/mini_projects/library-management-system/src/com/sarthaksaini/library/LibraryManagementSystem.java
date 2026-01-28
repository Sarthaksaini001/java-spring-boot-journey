package com.sarthaksaini.library;

public class LibraryManagementSystem {
    
    public static void main(String[] args) {
        
        // Object creation - Parent Book Class
        Book book1 = new Book("Hello World in Java", "Nobody", "123-4567891011",  199, true);
        Book book2 = new Book("1984", "George Orwell", "978-0451524935", 13.99, true);

        // Object creation - Child Book class
        FictionBook fictionBook1 = new FictionBook("Harry Potter", "J.K. Rowling", "978-0439708180", 15.99, true, "Fantasy");
        FictionBook fictionBook2 = new FictionBook("The Hobbit", "J.R.R. Tolkien", "978-0547928227", 14.99, true, "Adventure");


        // AI (Co-pilot) is used to write the code below (For print statements only).
        // Test 1: Display info
        System.out.println("=== Test 1: Display Info ===");
        book1.displayInfo();
        System.out.println("Type: " + book1.getBookType());
        
        System.out.println("\n=== Fiction Book ===");
        fictionBook1.displayInfo();
        System.out.println("Type: " + fictionBook1.getBookType());

        // Test 2: Borrow when available
        System.out.println("\n=== Test 2: Borrow Available Book ===");
        book1.borrowBook();
        System.out.println("Is Available: " + book1.getIsAvailable());

        // Test 3: Try borrowing already borrowed book (error case)
        System.out.println("\n=== Test 3: Borrow Already Borrowed Book ===");
        book1.borrowBook();

        // Test 4: Return book
        System.out.println("\n=== Test 4: Return Book ===");
        book1.returnBook();
        System.out.println("Is Available: " + book1.getIsAvailable());

        // Test 5: Negative price validation
        System.out.println("\n=== Test 5: Invalid Price ===");
        Book invalidBook = new Book("Test", "Author", "123", -10, true);
        System.out.println("Price set to: " + invalidBook.getPrice());

        // Test 6: All getters
        System.out.println("\n=== Test 6: Getters ===");
        System.out.println("Title: " + fictionBook1.getTitle());
        System.out.println("Author: " + fictionBook1.getAuthor());
        System.out.println("ISBN: " + fictionBook1.getIsbn());
        System.out.println("Price: $" + fictionBook1.getPrice());
        System.out.println("Available: " + fictionBook1.getIsAvailable());
        System.out.println("Genre: " + fictionBook1.getGenre());
    }
}
