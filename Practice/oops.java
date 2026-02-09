/*
OOPs Basics - Created a Student Record using OOPs

Key Concepts Learned :
 - Creating a Classes
 - Creating an Objects
 - Accessing Object properties
 - Calling Object Using (.) notation

Date: 10 January 2026

 */



// Class representing students of a cohort
class CohortStudent {

    // Properties
    String studentName;
    int age;
    String currentRole;

    // method to display the information
    void getStudentInfo(){
        System.out.println("Name: " + studentName);
        System.out.println("Age: " + age);
        System.out.println("Current Role: " + currentRole);
    }

}

// public class with MAIN
public class oops{ 
    public static void main(String[] args) {
        
        // Object creation for Students
        CohortStudent student1 = new CohortStudent();
        student1.studentName = "Sarthak";
        student1.age = 24;
        student1.currentRole = "Sales Consultant";

        // Student 2 
        CohortStudent student2 = new CohortStudent();
        student2.studentName = "Kamaldeep";
        student2.age = 25;
        student2.currentRole = "Sales Consultant";
        
        // Printing Details
        System.out.println("Student 1 Details:");
        student1.getStudentInfo();
        
        System.out.println("\nStudent 2 Details:");
        student2.getStudentInfo();
    }
}