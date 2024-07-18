package com.neoteric.personalloan.model;

public class PersonalLoan extends Loan {
    public Customer customer;
    public double salary;
    public int loanId;
    public int applicationNumber;

    public PersonalLoan(double principal, double interestRate, int repaymentPeriod, double salary, Customer customer, int loanId, int applicationNumber) {
        super(principal, interestRate, repaymentPeriod);
        this.salary = salary;
        this.customer = customer;
        this.loanId = loanId;
        this.applicationNumber = applicationNumber;
    }
}
