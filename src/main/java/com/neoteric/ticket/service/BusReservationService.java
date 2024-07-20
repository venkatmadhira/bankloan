package com.neoteric.ticket.service;

import com.neoteric.ticket.model.Bus;
import com.neoteric.ticket.model.Route;

import java.util.ArrayList;
import java.util.List;

public class BusReservationService {
    public List<Route> routes=new ArrayList<>();

    public List<Bus> searchBuses(String from, String to, String date) {
        List<Bus> availableBuses = new ArrayList<>();
        for (Route route : routes) {
            if (route.from.equalsIgnoreCase(from) && route.to.equalsIgnoreCase(to) && route.date.equals(date)) {
                availableBuses.addAll(route.buses);
            }
        }
        return availableBuses;
    }
    public void printAvailableBuses(List<Bus> buses) {
        for (Bus bus : buses) {
            System.out.println(bus);
        }
    }
}
