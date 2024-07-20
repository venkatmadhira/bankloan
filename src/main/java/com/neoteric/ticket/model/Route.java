package com.neoteric.ticket.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    public List<Bus> buses= new ArrayList<>();
    public String from;
    public String to;
    public double fare;
    public double distance;
    public String date;

    public Route(String from, String to, double fare, double distance, String date) {
        this.from = from;
        this.to = to;
        this.fare = fare;
        this.distance = distance;
        this.date = date;
    }
}
