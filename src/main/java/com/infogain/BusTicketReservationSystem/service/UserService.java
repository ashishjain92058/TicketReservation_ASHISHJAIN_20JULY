package com.infogain.BusTicketReservationSystem.service;

import org.springframework.stereotype.Service;

import com.infogain.BusTicketReservationSystem.model.User_Details;

public interface UserService {

	public User_Details register(User_Details userDetails);

	public CustomUserDetails loadUserByUsername(String username);
}
