package com.sarthaksaini.library;
public class Book{
    
    // Keeping all the variables Private
    private String title;
    private String author;
    private String isbn;
    private double price;
    private boolean isAvailable;

    // Parameterized Constructor to initialize all field
    public Book(String title, String author, String isbn, double price, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        // Validation for price
        if (price >= 0) {
            this.price = price;
        } else {
            System.err.println("Incorrect Price, must be positive");
            this.price = 0.0;
        }
        this.isAvailable = isAvailable;
    }

    // Method : borrowBook() -  If available, mark as unavailable and print success message. If not available, print error message
    void borrowBook(){
        if (this.isAvailable == true){
            this.isAvailable = false;
            System.out.println("Book is borrowed");
        } else {
            System.err.println("Book is not available to borrow");
        }
    }

    // Method : returnBook() - Mark book as available and print success message
    void returnBook(){
        this.isAvailable = true;
        System.out.println("Book returned succesfully");
    }

    // Method : displayInfo() - Print all book details (title, author, isbn, price, availability status)
    void displayInfo(){
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Price: $" + this.price);
        System.out.println("Available: " + (this.isAvailable ? "Yes" : "No"));
    }

    //Method : getBookType() - Return “General Book” (will be overridden by child classes)
    public String getBookType() {
        return "General Book";
    }  

    // Getters for alll the private field 
    String getTitle(){
        return this.title;
    }

    String getAuthor(){
        return this.author;
    }

    String getIsbn(){
        return this.isbn;
    }

    double getPrice(){
        return this.price;
    }

    boolean getIsAvailable(){
        return this.isAvailable;
    }

}