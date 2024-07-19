package com.neoteric.busreservation.service;

import com.neoteric.busreservation.model.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerService {
    public List<Passenger> passengers;

    public PassengerService() {
        passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public Passenger getPassenger(int passengerId) {
        for (Passenger passenger : passengers) {
            if (passenger.passengerId == passengerId) {
                return passenger;
            }
        }
        return null;
    }
}
