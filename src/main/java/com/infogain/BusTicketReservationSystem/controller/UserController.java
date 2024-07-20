package com.infogain.BusTicketReservationSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.BusTicketReservationSystem.model.User_Details;
import com.infogain.BusTicketReservationSystem.security.JwtUtil;
import com.infogain.BusTicketReservationSystem.service.CustomUserDetails;
import com.infogain.BusTicketReservationSystem.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User_Details userDetails) {

		User_Details user = userService.register(userDetails);
		if (user != null)
			return ResponseEntity.ok(userService.register(userDetails));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose any other unique username");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User_Details userDetails) {
		CustomUserDetails existingUser = userService.loadUserByUsername(userDetails.getUserName());

		if (existingUser != null && passwordEncoder.matches(userDetails.getPassword(), existingUser.getPassword())) {
			return ResponseEntity.status(HttpStatus.OK).body("Bearer "+ jwtUtil.generateToken(existingUser));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
		}

	}

}
