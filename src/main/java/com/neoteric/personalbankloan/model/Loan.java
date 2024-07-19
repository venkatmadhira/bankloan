package com.neoteric.personalbankloan.model;

import java.util.UUID;

public class Loan {
    private Customer customer;
    private double amount;
    private boolean approved;
    private double balance;
    private String applicationNumber;
    private String loanId;
    private double interestRate;
    private int termInMonths;

    public Loan(Customer customer, double amount, double interestRate, int termInMonths) {
        this.customer = customer;
        this.amount = amount;
        this.balance = amount;
        this.applicationNumber = UUID.randomUUID().toString();
        this.interestRate = interestRate;
        this.termInMonths = termInMonths;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String  getApplicationNumber() {
        return applicationNumber;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTermInMonths() {
        return termInMonths;
    }
}
