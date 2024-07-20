package com.neoteric.ticket;

import com.neoteric.ticket.model.Bus;
import com.neoteric.ticket.model.Route;
import com.neoteric.ticket.service.BusReservationService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicketTest {
    @Test
    public void testSearchBuses() {
        BusReservationService service = new BusReservationService();

        Bus bus1 = new Bus("AC", "101", 40);
        Bus bus2 = new Bus("Non-AC", "102", 45);

        Route route1 = new Route("Hyd", "Gnt", 500, 300, "2024-07-20");
        route1.buses.add(bus1);
        route1.buses.add(bus2);

        service.routes.add(route1);

        List<Bus> availableBuses = service.searchBuses("Hyd", "Gnt", "2024-07-20");
        assertEquals(2, availableBuses.size());
        assertTrue(availableBuses.contains(bus1));
        assertTrue(availableBuses.contains(bus2));
    }

    @Test
    public void testSearchBuses_NoMatch() {
        BusReservationService service = new BusReservationService();

        Bus bus1 = new Bus("AC", "101", 40);
        Bus bus2 = new Bus("Non-AC", "102", 45);

        Route route1 = new Route("Hyd", "Gnt", 500, 300, "2024-07-20");
        route1.buses.add(bus1);
        route1.buses.add(bus2);

        service.routes.add(route1);

        List<Bus> availableBuses = service.searchBuses("Hyd", "Gnt", "2024-07-21");
        assertEquals(0, availableBuses.size());
    }

    @Test
    public void testSearchBuses_PartialMatch() {
        BusReservationService service = new BusReservationService();
        List<Route> routeList=new ArrayList<>();

        Bus bus1 = new Bus("AC", "101", 40);
        Bus bus2 = new Bus("Non-AC", "102", 45);

        Route route1 = new Route("Hyd", "Gnt", 500, 300, "2024-07-20");
        route1.buses.add(bus1);
        route1.buses.add(bus2);

        service.routes.add(route1);

        Bus bus3 = new Bus("Sleeper", "103", 30);
        Route route2 = new Route("Hyd", "Bza", 700, 500, "2024-07-20");
        route2.buses.add(bus3);

        service.routes.add(route2);

        List<Bus> availableBuses = service.searchBuses("Hyd", "Gnt", "2024-07-20");
        assertEquals(2, availableBuses.size());
        assertTrue(availableBuses.contains(bus1));
        assertTrue(availableBuses.contains(bus2));
    }
}
