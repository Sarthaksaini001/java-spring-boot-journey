package com.telstra.account;

// CustomerDetails class have all the initial details of a customer.
class Customer {

    // Private classes 
    private int cac; // cac - Customer account code - Will be unique and auto generated.
    private String fullName;
    private String email;   
    private String phoneNumber;
    private String address;
    private String dob; // dob - Date of birth
    private boolean idVerified;
    private boolean accountCreated = false;
    // Auto generating CAC
    private static int lastUsedCac = 1000;
    
    // Constructor to initialize customer details
    public Customer(String fullName, String email, String phoneNumber, String address, String dob, boolean idVerified) {
        boolean isValid = true;


        // Validations for account creation.
        // Name
        if (fullName == null || fullName.trim().isEmpty()) {
            System.out.println("Full Name is required! Account not created.");
            isValid = false;
        }
        // Address
        if (address == null || address.trim().isEmpty()) {
            System.out.println("Address is required! Account not created.");
            isValid = false;
        }
        // Date of Birth
        if (dob == null || !dob.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            System.out.println("Date of Birth is required in DD/MM/YYYY format! Account not created.");
            isValid = false;
        }
        // Id Verification
        if(!idVerified){
            System.out.println("ID Verification is required! Account not created.");
            isValid = false;
        }  
        // Email 
        if (email != null && !email.isEmpty()) {
            if (!email.contains("@") || !email.contains(".")) {
                System.out.println("Invalid email format.");
                email = null;
            }
        } else {
            System.out.println("Email not provided. Non-Email account features will be coming soon.");
            isValid = false;
        }
        // Phone Number
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            if (!phoneNumber.matches("^0[0-9]{9}$")) {
                System.out.println("Invalid phone format (must be 10 digits starting with 0 or 61). Using default.");
                phoneNumber = null;
            }
        } else {
            System.out.println("Phone number not provided. You can add it later.");
            phoneNumber = null;
        }   

        // If all validations pass, assign values
        if (isValid) {
            this.cac = ++lastUsedCac;
            this.fullName = fullName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.dob = dob;
            this.idVerified = idVerified;
            this.accountCreated = true;
            System.out.println("Account created successfully for " + fullName + " with CAC: " + this.cac);
        } else {
            System.out.println("Account creation failed due to invalid details.");
        }
    }

    // Getters for customer details
    public int getCac() {
        return cac;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public String getDob() {
        return dob;
    }
    public boolean isIdVerified() {
        return idVerified;
    }

    // Setters for customer details - only for fields that might change

    //Email Update
    public void setEmail(String email) {
        if (!accountCreated) {
        System.out.println("Cannot update: Account was not created!");
        return;
        }
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
            System.out.println("Email updated successfully!");
        } else {
            System.out.println("Invalid email format!");
        }
    }
    //Phone Number Update
    public void setPhoneNumber(String phoneNumber) {
        if (!accountCreated) {
        System.out.println("Cannot update: Account was not created!");
        return;
        }
        if (phoneNumber != null && phoneNumber.matches("^0[0-9]{9}$")) {
            this.phoneNumber = phoneNumber;
            System.out.println("Phone number updated successfully!");
        } else {
            System.out.println("Invalid phone format (must be 10 digits starting with 0 or 61)");
        }
    }
    //Address Update
    public void setAddress(String address) {
        if (!accountCreated) {
        System.out.println("Cannot update: Account was not created!");
        return;
        }
         if (address != null && !address.trim().isEmpty()) {
            this.address = address;
            System.out.println("Address updated successfully!");
        } else {
            System.out.println("Address cannot be empty!");
        }
    }
    // Method to display customer details
    public void displayCustomerDetails() {

        if (!this.accountCreated) {
            System.out.println("\nCannot display details: Account was not created due to invalid details provided.\n");
            return;
        }
        System.out.println("Customer Account Code: " + cac);
        System.out.println("Full Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Date of Birth: " + dob);
        System.out.println("ID Verified: " + (idVerified ? "Yes" : "No"));
    }



}