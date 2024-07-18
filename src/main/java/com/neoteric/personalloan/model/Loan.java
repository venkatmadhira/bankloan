package com.neoteric.personalloan.model;

public class Loan {
    public double principal;
    public double interestRate;
    public int tenure;

    public Loan(double principal, double interestRate, int tenure) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.tenure = tenure;
    }
}
