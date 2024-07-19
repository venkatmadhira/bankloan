package com.neoteric.busreservation.model;

public class Ticket {
    public int ticketId;
    public int busNumber;
    public int passengerId;
    public int routeId;

    public Ticket(int ticketId, int busNumber, int passengerId, int routeId) {
        this.ticketId = ticketId;
        this.busNumber = busNumber;
        this.passengerId = passengerId;
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Bus Number: " + busNumber + ", Passenger ID: " + passengerId + ", Route ID: " + routeId;
    }
}
