package com.neoteric.busreservation;

import com.neoteric.busreservation.model.Bus;
import com.neoteric.busreservation.model.Passenger;
import com.neoteric.busreservation.model.Route;
import com.neoteric.busreservation.model.Ticket;
import com.neoteric.busreservation.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusTest {
    public BusService busService;
    public PassengerService passengerService;
    private RouteService routeService;
    private TicketService ticketService;
    private BusReservation helper;

    @BeforeEach
    public void setUp() {
        busService = new BusService();
        passengerService = new PassengerService();
        routeService = new RouteService();
        ticketService = new TicketService(busService, passengerService, routeService);
        helper = new BusReservation();

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
    }

    @Test
    public void testDisplayAvailableBuses() {
        System.out.println("Test Case: Display Available Buses");
        helper.displayAvailableBuses(busService);
        assertTrue(busService.getBuses().size() > 0, "Available buses should be more than 0");
    }

    @Test
    public void testBookTicket() {
        System.out.println("Test Case: Book Tickets");
        Ticket ticket1 = ticketService.bookTicket(1, 1, 1);
        Ticket ticket2 = ticketService.bookTicket(2, 2, 1);

        System.out.println("Booked Ticket 1: " + ticket1);
        System.out.println("Booked Ticket 2: " + ticket2);

        assertNotNull(ticket1, "Ticket 1 should be successfully booked");
        assertNotNull(ticket2, "Ticket 2 should be successfully booked");
    }

    @Test
    public void testDisplayAllTickets() {
        ticketService.bookTicket(1, 1, 1);
        ticketService.bookTicket(2, 2, 1);

        System.out.println("Test Case: Display All Tickets");
        helper.displayAllTickets(ticketService);
        assertTrue(ticketService.getAllTickets().size() > 0, "All tickets should be more than 0");
    }

    @Test
    public void testSearchBusesByRouteAndDate() {
        System.out.println("Test Case: Search Buses by Route and Date");
        helper.searchBusesByRouteAndDate(routeService, "City A", "City B", "2023-07-20");
        List<Route> routes = routeService.getRoutesByCriteria("City A", "City B", "2023-07-20");
        assertTrue(routes.size() > 0, "Routes for the given criteria should be more than 0");
    }
}
