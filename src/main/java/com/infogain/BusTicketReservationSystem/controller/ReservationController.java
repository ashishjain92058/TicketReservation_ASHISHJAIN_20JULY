package com.infogain.BusTicketReservationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.BusTicketReservationSystem.model.Reservation;
import com.infogain.BusTicketReservationSystem.model.ReservationRequest;
import com.infogain.BusTicketReservationSystem.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@PostMapping
	public ResponseEntity<Reservation> bookSeat(@RequestBody ReservationRequest reservationRequest){
		
		Reservation reservation = reservationService.bookSeat(reservationRequest); 
		return ResponseEntity.ok(reservation);
	}
}
