package com.neoteric.bankloan.test;

import com.neoteric.bankloan.entity.LoanEligibility;
import com.neoteric.bankloan.service.LoanService;
import com.neoteric.bankloan.service.LoanServiceImpl;

public class LoanApproval {
    public static void main(String[] args) {
        LoanService loanService = new LoanService();
        LoanServiceImpl loanService1 = new LoanServiceImpl();

        LoanEligibility applicant1 = new LoanEligibility("Venkat", 50000, 250000, 780, 60,8);
        loanService.printLoanDetails(applicant1, loanService1);

        LoanEligibility applicant2 = new LoanEligibility("Venkat", 50000, 35000, 720, 60,9);
        loanService.printLoanDetails(applicant2, loanService1);

    }
}
