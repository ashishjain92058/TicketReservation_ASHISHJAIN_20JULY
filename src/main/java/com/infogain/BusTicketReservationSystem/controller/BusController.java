package com.infogain.BusTicketReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.BusTicketReservationSystem.model.Bus;
import com.infogain.BusTicketReservationSystem.model.Route;
import com.infogain.BusTicketReservationSystem.service.BusService;
import com.infogain.BusTicketReservationSystem.service.RouteService;

@RestController
@RequestMapping("/api/buses")
public class BusController {

	@Autowired
	BusService busService;

	@GetMapping
	public ResponseEntity<List<Bus>> getAllBuses() {
		return ResponseEntity.ok(busService.getAllBuses());
	}
}
