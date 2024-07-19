package com.neoteric.busreservation.model;

public class Bus {
    public String busType;
    public int serviceNo;
    public int seatNo;
    public boolean isFull;

    public Bus(String busType, int serviceNo, int seatNo) {
        this.busType = busType;
        this.serviceNo = serviceNo;
        this.seatNo = seatNo;
        this.isFull = false;
    }

    public void bookSeat() {
        isFull = true;
    }

    @Override
    public String toString() {
        return "Bus Type: " + busType + ", Service No: " + serviceNo + ", Seat No: " + seatNo;
    }
}
