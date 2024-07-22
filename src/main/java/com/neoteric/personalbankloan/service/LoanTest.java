package com.neoteric.personalbankloan.service;

import com.neoteric.personalbankloan.model.Customer;
import com.neoteric.personalbankloan.model.Loan;

public class LoanTest {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        LoanService loanService = new LoanService(bankService);

        Customer customer = new Customer("Venkat", 40000,10000);
        Loan loan = new Loan(customer, 100000, 9, 10);

        System.out.println("Customer: " + customer.getName());
        System.out.println("Salary: Rs" + customer.getSalary());
        System.out.println("Applying for loan amount: Rs" + loan.getAmount());

        loanService.applyForLoan(loan);
        loanService.isApproved(loan,customer,loanService);
    }
}
