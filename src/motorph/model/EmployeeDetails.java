package motorph.model;

import java.text.DecimalFormat;
import java.util.Locale;

public class EmployeeDetails {

    // Employee attributes: personal and job-related information
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String birthday;
    private String address;
    private String phoneNumber;
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagIbigNumber;
    private String status;
    private String position;
    private String immediateSupervisor;
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;

    // Constructor to initialize the employee's information
    public EmployeeDetails(String employeeNumber, String lastName, String firstName, String birthday, String address,
            String phoneNumber, String sssNumber, String philhealthNumber, String tinNumber, String pagIbigNumber,
            String status, String position, String immediateSupervisor, double basicSalary, double riceSubsidy,
            double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagIbigNumber = pagIbigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    // Getter methods for retrieving employee details
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public String getPhilhealthNumber() {
        return philhealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public String getPagIbigNumber() {
        return pagIbigNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public String getImmediateSupervisor() {
        return immediateSupervisor;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public double getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    // Returns the employee's ID (same as employeeNumber)
    public String getEmployeeId() {
        return employeeNumber;
    }

    // Returns the full name of the employee (First and Last name)
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public void setEmployeeNumber(String employeeNumber) {
        
    }

    // Converts EmployeeDetails object to a CSV array for writing to a file
    public String[] toCSVArray() {
        DecimalFormat noSci = new DecimalFormat("0");       
        
        return new String[] { 
            employeeNumber, 
            lastName, 
            firstName, 
            birthday, 
            address, 
            phoneNumber, 
            sssNumber,
            noSci.format(Double.parseDouble(philhealthNumber)), 
            tinNumber, 
            noSci.format(Double.parseDouble(pagIbigNumber)), 
            status, 
            position, 
            immediateSupervisor,
            String.format(Locale.US, "%.2f", basicSalary), 
            String.format(Locale.US, "%.2f", riceSubsidy), 
            String.format(Locale.US, "%.2f", phoneAllowance),
            String.format(Locale.US, "%.2f", clothingAllowance), 
            String.format(Locale.US, "%.2f", grossSemiMonthlyRate), 
            String.format(Locale.US, "%.2f", hourlyRate) 
        };
    }

    // Provides a string representation of the employee's basic info
    @Override
    public String toString() {
        return "Employee #" + employeeNumber + " | Name: " + firstName + " " + lastName +
                " | Position: " + position + " | Salary: " + basicSalary;
    }
}
