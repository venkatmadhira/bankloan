package com.neoteric.itrdemo.service;
import static org.junit.jupiter.api.Assertions.*;
import com.neoteric.itrdemo.model.User;
import org.junit.jupiter.api.Test;

public class TaxServiceTest {

    @Test
    public void testCalculateTax_ITR1_LowIncome() {
        User user = new User("Sampath", 300000, 28, false, false, false, false, false, false);
        TaxService service = new TaxService();
        double tax = service.calculateTax(user);
        assertEquals(15000, tax);
    }

    @Test
    public void testCalculateTax_ITR1_HighIncome() {
        User user = new User("Bobby", 1500000, 40, false, false, false, false, false, false);
        TaxService service = new TaxService();
        double tax = service.calculateTax(user);
        assertEquals(275000, tax);
    }

    @Test
    public void testCalculateTax_ITR2_NoAdditionalConditions() {
        User user = new User("Manideep", 800000, 32, false, false, false, false, false, false);
        TaxService service = new TaxService();
        double tax = service.calculateTax(user, false, false);
        assertEquals(85000, tax);
    }

    @Test
    public void testCalculateTax_ITR2_WithCapitalGains() {
        User user = new User("Uday", 800000, 32, true, false, false, false, false, false);
        TaxService service = new TaxService();
        double tax = service.calculateTax(user, true, false);
        double expectedTax = 85000 + (800000 * 0.1);
        assertEquals(expectedTax, tax);
    }

    @Test
    public void testCalculateTax_ITR2_WithMultipleHouseProperties() {
        User user = new User("Sarath", 800000, 32, false, true, false, false, false, false);
        TaxService service = new TaxService();
        double tax = service.calculateTax(user, false, true);
        double expectedTax = 85000 + 10000;
        assertEquals(expectedTax, tax);
    }

    @Test
    public void testCalculateTax_ITR2_WithBothConditions() {
        User user = new User("Gopi", 800000, 32, true, true, false, false, false, false);
        TaxService service = new TaxService();
        double tax = service.calculateTax(user, true, true);
        double expectedTax = 85000 + (800000 * 0.1) + 10000;
        assertEquals(expectedTax, tax);
    }

    @Test
    public void testCalculateTax_ITR3_NoBusinessIncome() {
        User user = new User("Dinesh", 1000000, 38, false, false, false, false, false, false);
        TaxService service = new TaxService();
        double tax = service.calculateTax(user, false);
        // Calculation: 25000 + (1000000 - 500000) * 0.2 = 125000
        assertEquals(125000, tax);
    }

    @Test
    public void testCalculateTax_ITR3_WithBusinessIncome() {
        User user = new User("Anil", 1000000, 38, false, false, false, false, false, true);
        TaxService service = new TaxService();
        double tax = service.calculateTax(user, true);
        double expectedTax = 125000 + (1000000 * 0.15);
        assertEquals(expectedTax, tax);
    }

    @Test
    public void testCalculateTax_ITR4_NoPresumptiveIncome() {
        User user = new User("Pavan", 700000, 29, false, false, false, false, false, false);
        TaxService service = new TaxService();
        double tax = service.calculateTax( false,user);
        assertEquals(65000, tax);
    }

    @Test
    public void testCalculateTax_ITR4_WithPresumptiveIncome() {
        User user = new User("Venkat", 700000, 29, false, false, false, false, false, false);
        TaxService service = new TaxService();
        double tax = service.calculateTax( true,user);
        double expectedTax = 65000 + (700000 * 0.1);
        assertEquals(expectedTax, tax);
    }
}

