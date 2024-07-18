package com.neoteric.personalloan;

import com.neoteric.personalloan.model.Address;
import com.neoteric.personalloan.model.Customer;
import com.neoteric.personalloan.model.PersonalLoan;
import com.neoteric.personalloan.service.PersonalLoanService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalLoanServiceTest {

    @Test
    public void testCreateLoan_ValidLoan() {
        PersonalLoanService loanService = new PersonalLoanService();
        Address address = new Address("123", "Kphb", "Kphb", "Hyd", "500080");
        Customer customer = new Customer("Venkat", address, "9182");

        double principal = 20000.0;
        double interestRate = 6.0;
        int repaymentPeriod = 24;
        double salary = 60000.0;

        PersonalLoan loan = loanService.createLoan(principal, interestRate, repaymentPeriod, salary, customer);

        assertNotNull(loan, "Expected loan to be approved");
        assertEquals("Venkat", loan.customer.name, "Expected customer name to match");
        assertEquals(principal, loan.principal, 0.01, "Expected principal to match");
        assertEquals(interestRate, loan.interestRate, 0.01, "Expected interest rate to match");
        assertEquals(repaymentPeriod, loan.tenure, "Expected repayment period to match");
    }
    @Test
    public void testCreateLoan_MaxRepaymentPeriod() {
        PersonalLoanService loanService = new PersonalLoanService();
        Address address = new Address("101", "Gachibowli", "Gachibowli", "Hyd", "500083");
        Customer customer = new Customer("Priya", address, "9403");

        double principal = 30000.0;
        double interestRate = 5.0;
        int repaymentPeriod = 360;
        double salary = 80000.0;

        PersonalLoan loan = loanService.createLoan(principal, interestRate, repaymentPeriod, salary, customer);

        assertNotNull(loan, "Expected loan to be approved");
        assertEquals(repaymentPeriod, loan.tenure, "Expected repayment period to match");
    }
    @Test
    public void testCreateLoan_HighInterestRate() {
        PersonalLoanService loanService = new PersonalLoanService();
        Address address = new Address("456", "Hitech", "Hitech", "Hyd", "500081");
        Customer customer = new Customer("Ravi", address, "8192");

        double principal = 50000.0;
        double interestRate = 15.0;
        int repaymentPeriod = 24;
        double salary = 60000.0;

        PersonalLoan loan = loanService.createLoan(principal, interestRate, repaymentPeriod, salary, customer);

        assertNotNull(loan, "Expected loan to be approved");
        assertEquals(interestRate, loan.interestRate, 0.01, "Expected interest rate to match");
    }
    @Test
    public void testCreateLoan_LargePrincipal_ShortRepaymentPeriod() {
        PersonalLoanService loanService = new PersonalLoanService();
        Address address = new Address("123", "Kphb", "Kphb", "Hyd", "500080");
        Customer customer = new Customer("Venkat", address, "9182");

        double principal = 100000.0;
        double interestRate = 7.0;
        int repaymentPeriod = 6;
        double salary = 80000.0;

        PersonalLoan loan = loanService.createLoan(principal, interestRate, repaymentPeriod, salary, customer);

        assertNotNull(loan, "Expected loan to be approved");
        assertEquals(principal, loan.principal, 0.01, "Expected principal to match");
    }
    @Test
    public void testCreateLoan_ZeroSalary() {
        PersonalLoanService loanService = new PersonalLoanService();
        Address address = new Address("789", "Madhapur", "Madhapur", "Hyd", "500082");
        Customer customer = new Customer("Suresh", address, "7261");

        double principal = 20000.0;
        double interestRate = 6.0;
        int repaymentPeriod = 24;
        double salary = 0.0;

        PersonalLoan loan = loanService.createLoan(principal, interestRate, repaymentPeriod, salary, customer);
        assertEquals(null, loan);
    }







}
