package com.infogain.BusTicketReservationSystem.service;

import com.infogain.BusTicketReservationSystem.model.Reservation;
import com.infogain.BusTicketReservationSystem.model.ReservationRequest;

public interface ReservationService {

	Reservation bookSeat(ReservationRequest reservationRequest);

}
