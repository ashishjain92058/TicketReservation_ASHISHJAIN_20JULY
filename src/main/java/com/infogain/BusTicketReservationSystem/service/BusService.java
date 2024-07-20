package com.infogain.BusTicketReservationSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.infogain.BusTicketReservationSystem.model.Bus;

public interface BusService {

	
	List<Bus> getAllBuses();

	
}
