package com.neoteric.busreservation.model;

import java.util.Date;
import java.util.List;

public class Route {
    public int routeId;
    public String from;
    public String to;
    public double fare;
    public double distance;
    public String date;
    public List<Bus> buses;

    public Route(int routeId, String from, String to, double fare, double distance, String date, List<Bus> buses) {
        this.routeId = routeId;
        this.from = from;
        this.to = to;
        this.fare = fare;
        this.distance = distance;
        this.date = date;
        this.buses = buses;
    }

    @Override
    public String toString() {
        return "Route ID: " + routeId + ", From: " + from + ", To: " + to + ", Fare: " + fare + ", Distance: " + distance + ", Date: " + date;
    }
}
