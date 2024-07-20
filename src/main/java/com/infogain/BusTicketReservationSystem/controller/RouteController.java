package com.infogain.BusTicketReservationSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.BusTicketReservationSystem.service.RouteService;

@RestController
@RequestMapping("/api/route")
public class RouteController {
	
	@Autowired
	RouteService routeService;
	
	@GetMapping("search")
	public ResponseEntity<List<com.infogain.BusTicketReservationSystem.model.Route>> searchRouts(@RequestParam(required = false) String departure,
			@RequestParam(required = false) String arrival) {
		return ResponseEntity.ok(routeService.searchRoute(departure, arrival));
	}

}
