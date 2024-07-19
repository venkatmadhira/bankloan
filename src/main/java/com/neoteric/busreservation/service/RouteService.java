package com.neoteric.busreservation.service;

import com.neoteric.busreservation.model.Route;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteService {
    public List<Route> routes;

    public RouteService() {
        routes = new ArrayList<>();
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public Route getRoute(int routeId) {
        for (Route route : routes) {
            if (route.routeId == routeId) {
                return route;
            }
        }
        return null;
    }

    public List<Route> getRoutesByCriteria(String from, String to, String date) {
        List<Route> matchingRoutes = new ArrayList<>();
        for (Route route : routes) {
            if (route.from.equalsIgnoreCase(from) && route.to.equalsIgnoreCase(to) && route.date.equals(date)) {
                matchingRoutes.add(route);
            }
        }
        return matchingRoutes;
    }
}
