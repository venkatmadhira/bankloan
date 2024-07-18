package com.neoteric.personalbankloan.service;

import com.neoteric.personalbankloan.model.Customer;

import java.util.UUID;

public class BankService {
    public boolean approveLoan(Customer customer, double loanAmount) {
        double salary = customer.getSalary();
        double finalAmount=salary-customer.getUsageAmount();
        double emiAmount=finalAmount*0.6;
        if (emiAmount < 10000) {
            System.out.println("Loan not approved. Reason: Salary too low.");
            return false;
        } else if (loanAmount > salary * 10) {
            System.out.println("Loan not approved. Reason: Loan amount exceeds limit based on salary.");
            return false;
        } else {
            System.out.println("Loan approved.");
            return true;
        }
    }

    public String generateLoanId() {
        return UUID.randomUUID().toString();
    }
}
