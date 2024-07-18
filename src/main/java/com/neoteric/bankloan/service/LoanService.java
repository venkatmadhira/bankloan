package com.neoteric.bankloan.service;

import com.neoteric.bankloan.entity.LoanEligibility;

public class LoanService {

    public void printLoanDetails(LoanEligibility loanEligibility,LoanServiceImpl loanServiceImpl) {
        if (loanServiceImpl.isEligible(loanEligibility)) {
            System.out.println("Loan Approved!");
            System.out.println("Name: " + loanEligibility.name);
            System.out.println("Loan Amount: " + loanEligibility.loanAmount);
            System.out.println("CIBIL Score: " + loanEligibility.cibilScore);
            System.out.println("Interest Rate: " + loanEligibility.interestRate + "%");
            System.out.println("Loan Term: " + loanEligibility.loanTerm + " months");
            System.out.println("EMI: " + loanServiceImpl.calculateEMI(loanEligibility));
        } else {
            System.out.println("Loan Denied!");
            if (loanEligibility.loanAmount > loanEligibility.salary * 0.6*loanEligibility.loanTerm) {
                System.out.println("Requested loan amount exceeds 60% of the salary.");
            }
            if (loanEligibility.cibilScore <= 750) {
                System.out.println("CIBIL score is below the required threshold of 750.");
            }
        }
    }
}
