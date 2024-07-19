package com.neoteric.busreservation.model;

public class Passenger {
    public int passengerId;
    public String name;
    public int age;
    public String mobileNo;
    public String mail;

    public Passenger(int passengerId, String name, int age, String mobileNo, String mail) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.mobileNo = mobileNo;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Passenger ID: " + passengerId + ", Name: " + name + ", Age: " + age + ", Mobile No: " + mobileNo + ", Mail: " + mail;
    }
}
