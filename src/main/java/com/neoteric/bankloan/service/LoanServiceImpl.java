package com.neoteric.bankloan.service;

import com.neoteric.bankloan.entity.LoanEligibility;

public class LoanServiceImpl {

    public LoanEligibility loanEligibility;

    public double calculateEMI( LoanEligibility loanEligibility) {
        double r = (loanEligibility.interestRate / 12) / 100;
        int n = loanEligibility.loanTerm * 12;
        return (loanEligibility.salary * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
    }

    public boolean isEligible( LoanEligibility loanEligibility) {
        double maxEligibleLoan = loanEligibility.salary * 0.6*loanEligibility.loanTerm;
        return loanEligibility.loanAmount <= maxEligibleLoan && loanEligibility.cibilScore > 750;
    }
}
