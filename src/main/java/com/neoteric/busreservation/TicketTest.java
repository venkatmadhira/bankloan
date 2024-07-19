package com.neoteric.busreservation;

import com.neoteric.busreservation.model.Bus;
import com.neoteric.busreservation.model.Passenger;
import com.neoteric.busreservation.model.Route;
import com.neoteric.busreservation.model.Ticket;
import com.neoteric.busreservation.service.*;

import java.util.ArrayList;
import java.util.List;

public class TicketTest {
    public static void main(String[] args) {
        // Initialize services
        BusService busService = new BusService();
        PassengerService passengerService = new PassengerService();
        RouteService routeService = new RouteService();
        TicketService ticketService = new TicketService(busService, passengerService, routeService);
        BusReservation helper = new BusReservation();

        // Add sample data
        busService.addBus(new Bus("Volvo", 1, 40));
        busService.addBus(new Bus("Scania", 2, 50));
        busService.addBus(new Bus("Mercedes", 3, 60));

        passengerService.addPassenger(new Passenger(1, "John Doe", 30, "1234567890", "john@example.com"));
        passengerService.addPassenger(new Passenger(2, "Jane Smith", 25, "0987654321", "jane@example.com"));

        List<Bus> route1Buses = new ArrayList<>();
        route1Buses.add(busService.getBus(1));
        route1Buses.add(busService.getBus(2));
        routeService.addRoute(new Route(1, "City A", "City B", 500, 300, "2023-07-20", route1Buses));

        List<Bus> route2Buses = new ArrayList<>();
        route2Buses.add(busService.getBus(3));
        routeService.addRoute(new Route(2, "City C", "City D", 700, 500, "2023-07-21", route2Buses));

        // Test case: Display available buses
        helper.displayAvailableBuses(busService);

        // Test case: Book tickets
        Ticket ticket1 = ticketService.bookTicket(1, 1, 1);
        Ticket ticket2 = ticketService.bookTicket(2, 2, 1);

        System.out.println("Booked Ticket 1: " + ticket1);
        System.out.println("Booked Ticket 2: " + ticket2);

        // Test case: Display all tickets
        helper.displayAllTickets(ticketService);

        // Test case: Search buses by route and date
        helper.searchBusesByRouteAndDate(routeService, "City A", "City B", "2023-07-20");
    }
}
