package com.neoteric.itrdemo.service;
import com.neoteric.itrdemo.model.User;
public class TaxService {

    public double calculateTax(User user) {
        if (user.annualIncome <= 300000) {
            return 0;
        } else if (user.annualIncome <= 600000) {
            return user.annualIncome * 0.05;
        } else if (user.annualIncome <= 900000) {
            return 30000 + (user.annualIncome - 600000) * 0.15;
        } else {
            return 75000 + (user.annualIncome - 900000) * 0.3;
        }
    }
    public double calculateTax(User user, boolean hasBusinessIncome) {
        double tax = calculateTax(user);
        if (hasBusinessIncome) {
            tax += user.annualIncome * 0.15;
        }return tax;
    }
    public double calculateTax(User user, boolean hasCapitalGains, boolean hasMultipleHouseProperties) {
        double tax = calculateTax(user);
        if (hasCapitalGains) {
            tax += user.annualIncome * 0.1;
        }
        if (hasMultipleHouseProperties) {
            tax += 10000;
        }return tax;
    }
}

