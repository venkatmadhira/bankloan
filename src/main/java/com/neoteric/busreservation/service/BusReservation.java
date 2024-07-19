package com.neoteric.busreservation.service;

import com.neoteric.busreservation.model.Bus;
import com.neoteric.busreservation.model.Route;
import com.neoteric.busreservation.model.Ticket;

import java.util.List;

public class BusReservation {
    public void displayAvailableBuses(BusService busService) {
        System.out.println("Available Buses:");
        for (Bus bus : busService.getBuses()) {
            System.out.println(bus);
        }
    }

    public void displayAllTickets(TicketService ticketService) {
        System.out.println("All Tickets:");
        for (Ticket ticket : ticketService.getAllTickets()) {
            System.out.println(ticket);
        }
    }

    public void searchBusesByRouteAndDate(RouteService routeService, String from, String to, String date) {
        System.out.println("Buses for route from '" + from + "' to '" + to + "' on '" + date + "':");
        List<Route> routes = routeService.getRoutesByCriteria(from, to, date);
        for (Route route : routes) {
            System.out.println(route);
            for (Bus bus : route.buses) {
                System.out.println(bus);
            }
        }
    }
}
