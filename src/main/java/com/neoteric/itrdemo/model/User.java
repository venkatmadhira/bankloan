package com.neoteric.itrdemo.model;

public class User {
    public String name;
    public double annualIncome;
    public int age;
    public boolean hasCapitalGains;
    public boolean hasMultipleHouseProperties;
    public boolean hasForeignAssets;
    public boolean isCompanyDirector;
    public boolean isInvestedInUnlistedShares;
    public boolean hasBusinessIncome;

    public User(String name, double annualIncome, int age, boolean hasCapitalGains, boolean hasMultipleHouseProperties, boolean hasForeignAssets, boolean isCompanyDirector, boolean isInvestedInUnlistedShares, boolean hasBusinessIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
        this.age = age;
        this.hasCapitalGains = hasCapitalGains;
        this.hasMultipleHouseProperties = hasMultipleHouseProperties;
        this.hasForeignAssets = hasForeignAssets;
        this.isCompanyDirector = isCompanyDirector;
        this.isInvestedInUnlistedShares = isInvestedInUnlistedShares;
        this.hasBusinessIncome = hasBusinessIncome;
    }
}
