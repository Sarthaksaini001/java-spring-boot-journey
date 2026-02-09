package V01;
/**
 * NO AI is used to write this file.
 * 
 * This class represents an employee in the payroll system.
 * 
 * @author Sarthak Saini
 * @version 1.0
 * @since 2026-02-09
 */
public class Employee {
    
    private final String id;
    private final String name;
    private String department;
    private double baseSalary;
    private int yearsOfService;

    // Constructor chaining for New Hires
    public Employee(String id, String name, String department, double baseSalary){
        // Calls the constructor for current employee and sets Years of service to 0 
        this(id, name, department, baseSalary, 0);
    }
    
    // Constructor for Current class
    public Employee(String id, String name, String department, double baseSalary, int yearsOfService){
        
        // Business Rules for EmployeeID 
        if (id != null && id.length() == 6){
            this.id = id;
        }else{
            this.id = null; // ******** Not using Exception here as not learned yet ***********
            System.err.println("Employee ID must be of 6 Length"); 
        }

        // Business Rules for Employee Name and Department 
        if(name != null && !name.isEmpty() && department != null && !department.isEmpty()){
            this.name = name;
            this.department = department;
        }else{
            this.name = null;
            System.err.println("Name or Department can't be null or empty");
        }

        // Business Rules for Employee salary and years of service
        if(baseSalary >0 && yearsOfService >=0){        
        this.baseSalary = baseSalary;
        this.yearsOfService = yearsOfService;
        }else{
            System.err.println("Salary or Year of service entered incorrectly");
        }
        
    }

    // Method for calculating gross monthly pay
    public double getGrossMonthlyPay() {
        double bonusPercentage = Math.min(yearsOfService*0.02, 0.20);
        double annualSalary = baseSalary * (1+bonusPercentage);
        return annualSalary/12;
    }

    // Getters for all 
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDepartment(){
        return department;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public int getYearsOfService(){
        return yearsOfService;
    }

    // Business Rules for Allow updating department (promotions/transfers) ||| Allow incrementing years of service (annual review)
    // Allow salary updates (raises, promotions)
    public void setDepartment(String department){
        if (department != null && !department.isEmpty()) {
        this.department = department;
        } else {
        System.err.println("Department cannot be null or empty");
        }
    }

    public void incrementYearsOfService(){
        this.yearsOfService++;
    }

    public void setBaseSalary(double baseSalary){
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        } else {
            System.err.println("Salary must be positive");
        }
    }

    // Override toString() for readable employee details
    // Concept to remember - toString() is a built-in Java method 
    // inherited from Object class that returns a String representation of the object. 
    // By default it returns "ClassName@HashCode", but we override it to return meaningful employee information.
    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Department='" + department + '\'' +
                ", Base Salary=$" + String.format("%.2f", baseSalary) +
                ", Years of Service=" + yearsOfService +
                ", Gross Monthly Pay=$" + String.format("%.2f", getGrossMonthlyPay()) +
                '}';
    }
}   
