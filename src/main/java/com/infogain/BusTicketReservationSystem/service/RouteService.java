package com.infogain.BusTicketReservationSystem.service;

import java.util.List;

import com.infogain.BusTicketReservationSystem.model.Route;

public interface RouteService {

	List<Route> searchRoute(String departure, String arrival);

}
