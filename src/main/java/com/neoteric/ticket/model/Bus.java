package com.neoteric.ticket.model;

public class Bus {
    public String busType;
    public String serviceNo;
    public int seatNo;

    public Bus(String busType, String serviceNo, int seatNo) {
        this.busType = busType;
        this.serviceNo = serviceNo;
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busType='" + busType + '\'' +
                ", serviceNo='" + serviceNo + '\'' +
                ", seatNo=" + seatNo +
                '}';
    }
}
