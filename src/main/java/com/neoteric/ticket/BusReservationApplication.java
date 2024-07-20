package com.neoteric.ticket;

import com.neoteric.ticket.model.Bus;
import com.neoteric.ticket.model.Route;
import com.neoteric.ticket.service.BusReservationService;

import java.util.List;

public class BusReservationApplication {
    public static void main(String[] args) {
        BusReservationService service = new BusReservationService();

        Bus bus1 = new Bus("AC", "101", 40);
        Bus bus2 = new Bus("Non-AC", "102", 45);

        Route route1 = new Route("Hyd", "Gnt", 500, 300, "2024-07-20");
        route1.buses.add(bus1);
        route1.buses.add(bus2);

        service.routes.add(route1);

        List<Bus> availableBuses = service.searchBuses("Hyd", "Gnt", "2024-07-20");
        service.printAvailableBuses(availableBuses);
    }
}
