package com.neoteric.personalbankloan;
import static org.junit.jupiter.api.Assertions.*;
import com.neoteric.personalbankloan.model.Customer;
import com.neoteric.personalbankloan.model.Loan;
import com.neoteric.personalbankloan.service.BankService;
import com.neoteric.personalbankloan.service.LoanService;
import org.junit.jupiter.api.Test;

public class LoanServiceTest {
    private LoanService loanService;
    private BankService bankService;

    @Test
    public void testApplyForLoan() {
        BankService bankService = new BankService();
        LoanService loanService = new LoanService(bankService);

        Customer customer = new Customer("Venkat", 40000, 10000);
        Loan loan = new Loan(customer, 100000, 8, 10);
        loanService.applyForLoan(loan);

        if (loan.isApproved()) {
            assertNotNull(loan.getLoanId());
            assertNotEquals("", loan.getLoanId());
        } else {
            assertNull(loan.getLoanId());
        }
    }

    @Test
    public void testCalculateTotalInterest() {
        BankService bankService = new BankService();
        LoanService loanService = new LoanService(bankService);

        Customer customer = new Customer("Venkat", 40000, 10000);
        Loan loan = new Loan(customer, 100000, 8, 10);

        double totalInterest = loanService.calculateTotalInterest(loan);
        assertEquals(6666.67, totalInterest, 0.01);
    }

    @Test
    public void testCalculateTotalPayable() {
        BankService bankService = new BankService();
        LoanService loanService = new LoanService(bankService);

        Customer customer = new Customer("Venkat", 40000, 10000);
        Loan loan = new Loan(customer, 100000, 8, 10);

        double totalPayable = loanService.calculateTotalPayable(loan);
        assertEquals(106666.67, totalPayable, 0.01);
    }
}
