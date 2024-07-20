package com.infogain.BusTicketReservationSystem.model;

import lombok.Data;

@Data
public class ReservationRequest {

	private Long userId;
	private Long seatId;
	private Long routeId;
}
