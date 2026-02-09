package V01;

/**
 * This File is Written using GitHub Copilot for Testing Purposes
 */
public class PayrollDemo {
    
    public static void main(String[] args) {
        
        System.out.println("=== Employee Payroll System Demo ===\n");
        
        // Test 1: Creating new hires (years of service defaults to 0)
        System.out.println("--- Test 1: New Hires ---");
        Employee newHire1 = new Employee("EMP001", "John Doe", "IT", 60000.0);
        Employee newHire2 = new Employee("EMP002", "Jane Smith", "HR", 55000.0);
        
        System.out.println(newHire1);
        System.out.println(newHire2);
        System.out.println();
        
        // Test 2: Creating existing employees (legacy import with years of service)
        System.out.println("--- Test 2: Existing Employees ---");
        Employee existing1 = new Employee("EMP003", "Bob Johnson", "Finance", 70000.0, 5);
        Employee existing2 = new Employee("EMP004", "Alice Brown", "IT", 80000.0, 10);
        
        System.out.println(existing1);
        System.out.println(existing2);
        System.out.println();
        
        // Test 3: Testing loyalty bonus cap (20% max)
        System.out.println("--- Test 3: Loyalty Bonus Cap ---");
        Employee veteran = new Employee("EMP005", "Charlie Wilson", "Operations", 50000.0, 15);
        System.out.println(veteran);
        System.out.println("Note: 15 years should cap at 20% bonus");
        System.out.println();
        
        // Test 4: Using getters
        System.out.println("--- Test 4: Using Getters ---");
        System.out.println("Employee ID: " + newHire1.getEmployeeId());
        System.out.println("Employee Name: " + newHire1.getEmployeeName());
        System.out.println("Department: " + newHire1.getEmployeeDepartment());
        System.out.println("Base Salary: $" + String.format("%.2f", newHire1.getEmployeeBaseSalary()));
        System.out.println("Years of Service: " + newHire1.getYearsOfService());
        System.out.println("Gross Monthly Pay: $" + String.format("%.2f", newHire1.getGrossMonthlyPay()));
        System.out.println();
        
        // Test 5: Testing setters - Department transfer
        System.out.println("--- Test 5: Department Transfer ---");
        System.out.println("Before: " + newHire1);
        newHire1.setEmployeeDepartment("Engineering");
        System.out.println("After: " + newHire1);
        System.out.println();
        
        // Test 6: Testing setters - Salary raise
        System.out.println("--- Test 6: Salary Raise ---");
        System.out.println("Before: " + newHire2);
        newHire2.setEmployeeBaseSalary(62000.0);
        System.out.println("After: " + newHire2);
        System.out.println();
        
        // Test 7: Testing setters - Years of service increment (annual review)
        System.out.println("--- Test 7: Annual Review - Increment Years ---");
        System.out.println("Before: " + existing1);
        existing1.setYearsOfService(6);  // Changed from setYearOfService
        System.out.println("After: " + existing1);
        System.out.println();
        
        // Test 8: Testing validation - Invalid employee ID
        System.out.println("--- Test 8: Validation Tests ---");
        System.out.println("Attempting to create employee with invalid ID:");
        Employee invalid1 = new Employee("E01", "Invalid User", "IT", 50000.0);
        System.out.println(invalid1);
        System.out.println();
        
        // Test 9: Testing validation - Invalid salary
        System.out.println("Attempting to set negative salary:");
        newHire1.setEmployeeBaseSalary(-5000.0);
        System.out.println();
        
        // Test 10: Testing validation - Invalid years of service
        System.out.println("Attempting to set negative years of service:");
        newHire1.setYearsOfService(-2);  // Changed from setYearOfService
        System.out.println();
        
        System.out.println("=== Demo Complete ===");
    }
}