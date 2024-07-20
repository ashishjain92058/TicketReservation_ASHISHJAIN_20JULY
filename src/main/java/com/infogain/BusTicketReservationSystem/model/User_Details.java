package com.infogain.BusTicketReservationSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String userName;
	
	String Password;
}
