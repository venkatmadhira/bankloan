package com.neoteric.personalbankloan.service;

import com.neoteric.personalbankloan.model.Customer;
import com.neoteric.personalbankloan.model.Loan;

public class LoanService {
    private BankService bankService;

    public LoanService(BankService bankService) {
        this.bankService = bankService;
    }

    public void applyForLoan(Loan loan) {
        System.out.println("Application submitted. Application number: " + loan.getApplicationNumber());
        boolean approved = bankService.approveLoan(loan.getCustomer(), loan.getAmount());
        loan.setApproved(approved);
        if (approved) {
            String loanId = bankService.generateLoanId();
            loan.setLoanId(loanId);
            System.out.println("Loan approved for " + loan.getCustomer().getName() + " for amount Rs" + loan.getAmount());
            System.out.println("Loan ID: " + loanId);
        } else {
            System.out.println("Loan not approved for " + loan.getCustomer().getName());
        }
    }

    public double calculateTotalInterest(Loan loan) {
        double amount=(loan.getAmount() * loan.getInterestRate() * loan.getTermInMonths())/(100*12);
        return amount;
    }

    public double calculateTotalPayable(Loan loan) {
        double amount=loan.getAmount() + calculateTotalInterest(loan);
        return amount;
    }
    public void isApproved(Loan loan, Customer customer,LoanService loanService){
        if (loan.isApproved()) {
            System.out.println("Loan approved for " + customer.getName() + " for amount Rs" + loan.getAmount());
            System.out.println("Loan ID: " + loan.getLoanId());

            double totalInterest = loanService.calculateTotalInterest(loan);
            double totalPayable = loanService.calculateTotalPayable(loan);

            System.out.println("Total interest to be paid: Rs" + totalInterest);
            System.out.println("Total amount to be paid over the term: Rs" + totalPayable);
        } else {
            System.out.println("Loan not approved for " + customer.getName());
        }
    }
}
