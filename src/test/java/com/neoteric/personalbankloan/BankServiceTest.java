package com.neoteric.personalbankloan;
import static org.junit.jupiter.api.Assertions.*;
import com.neoteric.personalbankloan.model.Customer;
import com.neoteric.personalbankloan.service.BankService;
import org.junit.jupiter.api.Test;

public class BankServiceTest {
    private final BankService bankService = new BankService();

    @Test
    public void testApproveLoan() {
        Customer customer = new Customer("Venkat", 40000,10000);

        assertTrue(bankService.approveLoan(customer, 100000), "Loan should be approved");
        assertFalse(bankService.approveLoan(customer, 500000), "Loan should not be approved due to excessive amount");
        assertFalse(bankService.approveLoan(new Customer("Venkat", 25000,10000), 100000), "Loan should not be approved due to low salary");
    }
    @Test
    public void testGenerateLoanId() {
        String loanId1 = bankService.generateLoanId();
        String loanId2 = bankService.generateLoanId();

        assertNotNull(loanId1, "Generated loan ID should not be null");
        assertNotNull(loanId2, "Generated loan ID should not be null");
        assertNotEquals(loanId1, loanId2, "Generated loan IDs should be unique");
    }
}
