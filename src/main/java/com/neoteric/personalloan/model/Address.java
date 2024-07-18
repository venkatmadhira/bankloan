package com.neoteric.personalloan.model;

public class Address {
    public String flatNo;
    public String street;
    public String area;
    public String city;
    public String pinCode;

    public Address(String flatNo, String street, String area, String city, String pinCode) {
        this.flatNo = flatNo;
        this.street = street;
        this.area = area;
        this.city = city;
        this.pinCode = pinCode;
    }
}
