/**
 * -------------Practice Problem:------------------------
 * Create a Phone class:
 *
 * Private fields:
 * - brand (String)
 * - price (double - must be positive)
 * - batteryPercentage (int - must be 0-100)
 *
 * Public methods:
 * - Constructor
 * - Getters for all fields
 * - setBatteryPercentage(int battery) with validation
 * - charge(int amount) - increases battery (max 100)
 * - use(int amount) - decreases battery (min 0)
 * - displayPhoneInfo()
 *--------------------------------------------------------

 * OOPs : Encapsulation (Data Hiding)
 *
 * Concepts Learned :
 * - Why use private fields
 * - Getter methods (to READ data)
 * - Setter methods (to WRITE data with validation)
 * - Access modifiers (private, public)
 *
 * @author Sarthak Saini
 * @date 10 January 2026
 */

// Phone Class contaning
class Phone{

 // Parameters - Private here
    private String brand;
    private double price;
    private int batteryPercentage;

    // Constructor (Parameterized)
    public Phone(String brand, double price, int batteryPercentage){
        this.brand = brand;
        if (price > 0){
            this.price = price;
        }
        else {
            System.err.println("Wrong Price Entered, can't be negative");
        }
        if(batteryPercentage >= 0 && batteryPercentage <=100 ){
            this.batteryPercentage = batteryPercentage;
        }
        else {
            System.err.println("Wrong battery percentage entered, must be 0-100");
        }
    }

    // Get methods for all the field
    public String getBrand(){
        return brand;
    }
    public double getPrice(){
        return price;
    }
    public int getBatteryPercentage(){
        return batteryPercentage;
    }

    // Set method for battery percentage with validation
    public void setBatteryPercentage(int batteryPercentage){
        if(batteryPercentage >= 0 ){
            this.batteryPercentage = batteryPercentage;
        }
        else{
            System.err.println("Error : Wrong Battery Percentage");
        }
    }

    // Charge method that adds up the charging 
    public void charge(int amount){
        if(batteryPercentage >= 0 && batteryPercentage < 100 && amount >= 0 ){
            this.batteryPercentage += amount;
            if (this.batteryPercentage > 100)
                this.batteryPercentage = 100;
        System.out.println("New battery percentage is " + this.batteryPercentage);
        }
        else {
            System.err.println("No -ve values please");
        }
    }

    // Use method that decrease the charging
    public void use(int amount){
        if(batteryPercentage >= 0 && batteryPercentage < 100 && amount >= 0 ){
            this.batteryPercentage -= amount;
            if (this.batteryPercentage > 100)
                this.batteryPercentage = 100;
        System.out.println("New battery percentage is " + this.batteryPercentage);
        }
        else {
            System.err.println("No usage detected");
        }
    } 
    public void displayPhoneInfo(){
        System.out.println("Brand: " + brand + ", Price: $" + price + ", Battery: " + batteryPercentage + "%");
    }

}

public class EncapsulationPractice{
    public static void main(String[] args) {
        
        // Objects
        Phone apple = new Phone("Apple", 45000, 85);
        Phone samsung = new Phone("Samsung", 35000, 90);
        // Display Info
        apple.displayPhoneInfo();
        samsung.displayPhoneInfo();
        //Testing charge and use methods
        apple.charge(10);
        samsung.use(20);
        // Testing setter with invalid value
        apple.setBatteryPercentage(-50);
        // Testing setter with valid value
        samsung.setBatteryPercentage(75);
        samsung.displayPhoneInfo();     
        //Tesing getter methods
        System.out.println("Apple Phone Brand: " + apple.getBrand());
        System.out.println("Samsung Phone Price: " + samsung.getPrice());  

    }
}