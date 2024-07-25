package com.neoteric.itrdemo.service;
import com.neoteric.itrdemo.model.User;

public class TaxService {

    public double calculateTax(User user) {
        if (user.annualIncome <= 500000) {
            return user.annualIncome * 0.05;
        } else if (user.annualIncome <= 1000000) {
            return 25000 + (user.annualIncome - 500000) * 0.2;
        } else {
            return 125000 + (user.annualIncome - 1000000) * 0.3;
        }
    }

    public double calculateTax(User user, boolean hasCapitalGains, boolean hasMultipleHouseProperties) {
        double tax = calculateTax(user);
        if (hasCapitalGains) {
            tax += user.annualIncome * 0.1;
        }
        if (hasMultipleHouseProperties) {
            tax += 10000;
        }
        return tax;
    }

    public double calculateTax(User user, boolean hasBusinessIncome) {
        double tax = calculateTax(user);
        if (hasBusinessIncome) {
            tax += user.annualIncome * 0.15;
        }
        return tax;
    }

    public double calculateTax( boolean isPresumptiveIncome,User user) {
        double tax = calculateTax(user);
        if (isPresumptiveIncome) {
            tax += user.annualIncome * 0.1;
        }
        return tax;
    }
}

