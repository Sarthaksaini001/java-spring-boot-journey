/* 
--- Problem Practiced ---
Create a Car class with constructor:
Properties: brand, model, year

Methods:
Constructor to initialize all properties
startEngine() - prints "The [brand] [model] engine started!"
displayCarInfo() - prints all car details
Create 3 car objects and test all methods.

--- Concepts Learned ---
- Constructor: Special method to initialize objects
- this keyword: Refers to current object (avoids naming conflicts)
- Parameterized Constructor: Accepts values during object creation
- Cleaner code: One line object creation vs multiple assignments
@author Sarthak Saini
@date 10 January 2026 
*/

class Car {
    //Properties
    String brand;
    String model;
    int year;

    // Parameterized Constructor
    Car(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    // Method to Display car information
    void getCarInfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year" + year);    
    }
}


// Puclic class with Main
public class ConstructorPractice{
    public static void main(String[] args) {
        // Object creation using Contructor 
        Car audi = new Car("audi","A4",2023);
        Car bmw = new Car("BMW","X6",2024);

        // Display values
        audi.getCarInfo();
        bmw.getCarInfo();
    }
}