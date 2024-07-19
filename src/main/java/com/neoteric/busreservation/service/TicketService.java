package com.neoteric.busreservation.service;

import com.neoteric.busreservation.model.Bus;
import com.neoteric.busreservation.model.Passenger;
import com.neoteric.busreservation.model.Route;
import com.neoteric.busreservation.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    public List<Ticket> tickets;
    public BusService busService;
    public PassengerService passengerService;
    public RouteService routeService;
    public int ticketIdCounter;

    public TicketService(BusService busService, PassengerService passengerService, RouteService routeService) {
        this.tickets = new ArrayList<>();
        this.busService = busService;
        this.passengerService = passengerService;
        this.routeService = routeService;
        this.ticketIdCounter = 1;
    }

    public Ticket bookTicket(int busNumber, int passengerId, int routeId) {
        Bus bus = busService.getBus(busNumber);
        Passenger passenger = passengerService.getPassenger(passengerId);
        Route route = routeService.getRoute(routeId);

        if (bus != null && passenger != null && route != null && !bus.isFull) {
            bus.bookSeat();
            Ticket ticket = new Ticket(ticketIdCounter++, busNumber, passengerId, routeId);
            tickets.add(ticket);
            return ticket;
        }
        return null;
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }
}
