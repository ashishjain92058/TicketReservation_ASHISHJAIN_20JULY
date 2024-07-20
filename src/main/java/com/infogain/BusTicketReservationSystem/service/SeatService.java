package com.infogain.BusTicketReservationSystem.service;

import java.util.List;

import com.infogain.BusTicketReservationSystem.model.Seat;

public interface SeatService {

	List<Seat> getAvailableSeats(Long busId, Long routeId);

}
