package com.neoteric.busreservation.service;

import com.neoteric.busreservation.model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusService {
    public List<Bus> buses;

    public BusService() {
        buses = new ArrayList<>();
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public Bus getBus(int serviceNo) {
        for (Bus bus : buses) {
            if (bus.serviceNo == serviceNo) {
                return bus;
            }
        }
        return null;
    }

    public List<Bus> getBuses() {
        return buses;
    }

}
