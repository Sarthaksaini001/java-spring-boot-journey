package com.sarthaksaini.library;

public class FictionBook extends Book {
    
    // Defining genre of the book
    private String genre;

    // Constructor with super constructor
    public FictionBook(String title, String author, String isbn, double price, boolean isAvailable, String genre) {
        super(title, author, isbn, price, isAvailable);
        this.genre = genre;
    }

    // Getter for genre
    String getGenre(){
        return genre;
    }

    @Override
    public String getBookType() {
        return "Fiction";
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Genre " + this.genre);
    }
}