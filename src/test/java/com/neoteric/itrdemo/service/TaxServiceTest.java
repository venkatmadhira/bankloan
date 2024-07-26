package com.neoteric.itrdemo.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.neoteric.itrdemo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaxServiceTest {

    private TaxService taxService;

    @BeforeEach
    public void setUp() {
        taxService = new TaxService();
    }

    @Test
    public void taxForNoAdditional() {
        User user1 = new User("Venkat", 200000, 30, false, false, false, false, false, false);
        double tax1=taxService.calculateTax(user1);
        assertEquals(0,tax1 , 0.01);

        User user2 = new User("Venkat", 500000, 40, false, false, false, false, false, false);
        double tax2=taxService.calculateTax(user2);
        assertEquals(25000,tax2, 0.01);

        User user3 = new User("Venkat", 700000, 25, false, false, false, false, false, false);
        double tax3= taxService.calculateTax(user3);
        assertEquals(45000,tax3, 0.01);

        User user4 = new User("Venkat", 1000000, 50, false, false, false, false, false, false);
        double tax4=taxService.calculateTax(user4);
        assertEquals(105000,tax4, 0.01);
    }

    @Test
    public void taxWithCapitalGainsAndMultipleHouseProperties() {
        User user1 = new User("Venkat", 700000, 30, true, true, false, false, false, false);
        double tax1=taxService.calculateTax(user1, user1.hasCapitalGains, user1.hasMultipleHouseProperties);
        assertEquals(125000,tax1, 0.01);

        User user2 = new User("Venkat", 1000000, 40, true, true, false, false, false, false);
        double tax2=taxService.calculateTax(user2, user2.hasCapitalGains, user2.hasMultipleHouseProperties);
        assertEquals(215000,tax2, 0.01);
    }

    @Test
    public void taxWithBusinessIncome() {
        User user1 = new User("Venkat", 700000, 25, false, false, false, false, false, true);
        double tax1=taxService.calculateTax(user1, user1.hasBusinessIncome);
        assertEquals(150000,tax1, 0.01);

        User user2 = new User("Venkat", 1000000, 50, false, false, false, false, false, true);
        double tax2=taxService.calculateTax(user2, user2.hasBusinessIncome);
        assertEquals(255000, tax2, 0.01);
    }

    @Test
    public void taxMixedCases() {
        User user1 = new User("Venkat", 700000, 25, true, true, false, false, false, true);
        double tax=taxService.calculateTax(user1, user1.hasCapitalGains, user1.hasMultipleHouseProperties);
        assertEquals(125000,tax, 0.01);

        User user2 = new User("Venkat", 1000000, 27, true, true, false, false, false, true);
        double tax1= taxService.calculateTax(user2, user2.hasCapitalGains, user2.hasMultipleHouseProperties);
        assertEquals(215000,tax1, 0.01);
    }
}

