package com.neoteric.personalloan.service;
import com.neoteric.personalloan.model.Customer;
import com.neoteric.personalloan.model.PersonalLoan;

public class PersonalLoanService {

    public static int loanCounter = 1000;

    public double calculateMaxPrincipal(double principal, double interestRate, int repaymentPeriod, double salary) {
        double remainingSalary = salary * 0.7;
        double emiLimit = remainingSalary * 0.6;

        double rpp = interestRate / 100 / 12;
        double maxPrincipal = (emiLimit * (Math.pow(1 + rpp, repaymentPeriod) - 1)) /
                (rpp * Math.pow(1 + rpp, repaymentPeriod));

        return Math.min(principal, maxPrincipal);
    }

    public PersonalLoan approveLoan(double principal, double interestRate, int repaymentPeriod, double salary, Customer customer, double maxPrincipal) {
        if (principal > maxPrincipal) {
            principal = maxPrincipal;
        }

        int loanNumber = loanCounter++;
        int fileNumber = (int) (Math.random() * 100000);

        return new PersonalLoan(principal, interestRate, repaymentPeriod, salary, customer, loanNumber, fileNumber);
    }

    public void printLoanDetails(PersonalLoan loan) {
        double rpp = loan.interestRate / 100 / 12;
        double emi = (loan.principal * rpp * Math.pow(1 + rpp, loan.tenure)) /
                (Math.pow(1 + rpp, loan.tenure) - 1);

        double remainingSalary = loan.salary * 0.7;
        double emiLimit = remainingSalary * 0.6;

        if (emi <= emiLimit) {
            System.out.println("Loan Approved.");
            System.out.println("File Number: " + loan.applicationNumber);
            System.out.println("Loan Number: " + loan.loanId);
            System.out.println("Customer Name: " + loan.customer.name);
            System.out.println("Customer Address: " + loan.customer.address);
            System.out.println("Customer Phone: " + loan.customer.phoneNumber);
            System.out.println("Principal: " + loan.principal);
            System.out.println("Interest Rate: " + loan.interestRate + "%");
            System.out.println("Repayment Period: " + loan.tenure + " months");
            System.out.println("EMI: " + emi);
            System.out.println();
        } else {
            System.out.println("EMI exceeds 60% of the remaining salary after personal expenses.");
            System.out.println("Application Rejected.");
        }
    }
    public PersonalLoan createLoan(double principal, double interestRate, int repaymentPeriod, double salary, Customer customer) {
        if (salary == 0.0) {
            System.out.println("Cannot create loan: Salary is zero.");
            return null;
        }
        double maxPrincipal = calculateMaxPrincipal(principal, interestRate, repaymentPeriod, salary);
        PersonalLoan personalLoan = approveLoan(principal, interestRate, repaymentPeriod, salary, customer, maxPrincipal);
        printLoanDetails(personalLoan);
        return personalLoan;
    }
}
