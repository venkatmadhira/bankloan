package com.neoteric.personalloan.model;


public class Customer {
    public String name;
    public Address address;
    public String phoneNumber;

    public Customer(String name, Address address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}

