package com.infogain.BusTicketReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.BusTicketReservationSystem.model.Seat;
import com.infogain.BusTicketReservationSystem.service.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
  
	@Autowired
	SeatService seatService;
	
	@GetMapping
	public ResponseEntity<List<Seat>> getAvailableSeat(@RequestParam Long busId,@RequestParam Long routeId){
		
		List<Seat> availableSeat = seatService.getAvailableSeats(busId,routeId);
		return ResponseEntity.ok(availableSeat);
		
		
	}
	
}
