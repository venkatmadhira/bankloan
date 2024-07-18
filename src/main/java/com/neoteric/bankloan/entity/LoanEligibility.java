package com.neoteric.bankloan.entity;

import com.neoteric.bankloan.service.LoanServiceImpl;

public class LoanEligibility {
    public String name;
    public double salary;
    public double loanAmount;
    public int cibilScore;
    public double interestRate;
    public int loanTerm; // Loan term in years

    public LoanEligibility(String name, double salary, double loanAmount, int cibilScore, int loanTerm,double interestRate) {
        this.name = name;
        this.salary = salary;
        this.loanAmount = loanAmount;
        this.cibilScore = cibilScore;
        this.loanTerm = loanTerm;
        this.interestRate=interestRate;

    }
}

