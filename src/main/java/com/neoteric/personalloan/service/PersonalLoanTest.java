package com.neoteric.personalloan.service;
import com.neoteric.personalloan.model.Address;
import com.neoteric.personalloan.model.Customer;
import com.neoteric.personalloan.model.PersonalLoan;

public class PersonalLoanTest {
    public static void main(String[] args) {
        PersonalLoanService loanService = new PersonalLoanService();
        Address address=new Address("123","Kphb","Kphb","Hyd","500080");
        Customer customer = new Customer("Venkat",address,"9182");
        PersonalLoan personalLoan = loanService.createLoan(1000000, 9, 60, 200000, customer);
        System.out.println(personalLoan);
    }
}
