package com.neoteric.personalbankloan.model;

public class Customer {
    private String name;
    private double salary;
    private double usageAmount;

    public Customer(String name, double salary,double usageAmount) {
        this.name = name;
        this.salary = salary;
        this.usageAmount=usageAmount;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double getUsageAmount() {
        return usageAmount;
    }
}