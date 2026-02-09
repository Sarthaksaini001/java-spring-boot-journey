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
    
    private final String employeeId;
    private String employeeName;
    private String employeeDepartment;
    private double employeeBaseSalary;
    private int yearsOfService;

    // Constructor chaining for New Hires
    public Employee(String employeeId, String employeeName, String employeeDepartment, double employeeBaseSalary){
        // Calls the constructor for current employee and sets Years of service to 0 
        this(employeeId, employeeName, employeeDepartment, employeeBaseSalary, 0);
    }
    
    // Constructor for Current class
    public Employee(String employeeId, String employeeName, String employeeDepartment, double employeeBaseSalary, int yearsOfService){
        
        // Business Rules for EmployeeID 
        if (employeeId != null && employeeId.length() == 6){
            this.employeeId = employeeId;
        }else{
            this.employeeId = null; // ******** Not using Exception here as not learned yet ***********
            System.err.println("Employee ID must be of 6 Length"); 
        }

        // Business Rules for Employee Name and Department 
        if(employeeName != null && !employeeName.isEmpty() && employeeDepartment != null && !employeeDepartment.isEmpty()){
            this.employeeName = employeeName;
            this.employeeDepartment = employeeDepartment;
        }else{
            System.err.println("Name or Department can't be null or empty");
        }

        // Business Rules for Employee salary and years of service
        if(employeeBaseSalary >0 && yearsOfService >=0){        
        this.employeeBaseSalary = employeeBaseSalary;
        this.yearsOfService = yearsOfService;
        }else{
            System.err.println("Salary or Year of service entered incorrectly");
        }
        
    }

    // Method for calculating gross monthly pay
    public double getGrossMonthlyPay() {
        double bonusPercentage = Math.min(yearsOfService*0.02, 0.20);
        double annualSalary = employeeBaseSalary * (1+bonusPercentage);
        return annualSalary/12;
    }

    // Getters for all 
    public String getEmployeeId(){
        return employeeId;
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public String getEmployeeDepartment(){
        return employeeDepartment;
    }

    public double getEmployeeBaseSalary(){
        return employeeBaseSalary;
    }

    public int getYearsOfService(){
        return yearsOfService;
    }

    // Business Rules for Allow updating department (promotions/transfers) ||| Allow incrementing years of service (annual review)
    // Allow salary updates (raises, promotions)
    public void setEmployeeDepartment(String employeeDepartment){
        if (employeeDepartment != null && !employeeDepartment.isEmpty()) {
        this.employeeDepartment = employeeDepartment;
        } else {
        System.err.println("Department cannot be null or empty");
        }
    }

    public void setYearsOfService(int yearsOfService){
        if (yearsOfService >= 0) {
        this.yearsOfService = yearsOfService;
        } else {
        System.err.println("Years of service cannot be negative");
        }
    }

    public void setEmployeeBaseSalary(double employeeBaseSalary){
        if (employeeBaseSalary > 0) {
            this.employeeBaseSalary = employeeBaseSalary;
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
                "ID='" + employeeId + '\'' +
                ", Name='" + employeeName + '\'' +
                ", Department='" + employeeDepartment + '\'' +
                ", Base Salary=$" + String.format("%.2f", employeeBaseSalary) +
                ", Years of Service=" + yearsOfService +
                ", Gross Monthly Pay=$" + String.format("%.2f", getGrossMonthlyPay()) +
                '}';
    }
}   
