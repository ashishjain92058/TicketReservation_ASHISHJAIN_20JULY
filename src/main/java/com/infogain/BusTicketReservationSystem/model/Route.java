package com.infogain.BusTicketReservationSystem.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long route_id;
	
	private String departure;
	
	private String arrival;
	private LocalDate date;
	
	@ManyToOne
	private Bus bus;
}
