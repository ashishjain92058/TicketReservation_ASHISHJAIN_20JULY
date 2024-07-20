package com.infogain.BusTicketReservationSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infogain.BusTicketReservationSystem.Repository.BusRpository;
import com.infogain.BusTicketReservationSystem.Repository.ReservationRepository;
import com.infogain.BusTicketReservationSystem.Repository.RouteRpository;
import com.infogain.BusTicketReservationSystem.Repository.SeatRpository;
import com.infogain.BusTicketReservationSystem.Repository.UserRepository;
import com.infogain.BusTicketReservationSystem.model.Bus;
import com.infogain.BusTicketReservationSystem.model.Reservation;
import com.infogain.BusTicketReservationSystem.model.ReservationRequest;
import com.infogain.BusTicketReservationSystem.model.Route;
import com.infogain.BusTicketReservationSystem.model.Seat;
import com.infogain.BusTicketReservationSystem.model.User_Details;

@Service
public class ServiceImpl implements UserService, BusService, RouteService, SeatService, ReservationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private BusRpository busRepository;

	@Autowired
	private RouteRpository routeRepository;

	@Autowired
	private SeatRpository seatRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public User_Details register(User_Details userDetails) {
		Optional<User_Details> user = userRepository.findByUserName(userDetails.getUserName());
		// add check if username already exist then chosse any other combination
		// user name is unique
		if (user.isPresent()) {
			return null;
		} else {
			// encode the password and save into database
			userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
			return userRepository.save(userDetails);
		}
	}

	@Override
	public CustomUserDetails loadUserByUsername(String username) {
		Optional<User_Details> user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		User_Details userDetails = user.get();
		return new CustomUserDetails(userDetails.getUserName(), userDetails.getPassword(), new ArrayList<>());
	}

	@Override
	public List<Bus> getAllBuses() {
		return busRepository.findAll();
	}

	@Override
	public List<Route> searchRoute(String departure, String arrival) {
		return routeRepository.searchRoute(departure, arrival);
	}

	@Override
	public List<Seat> getAvailableSeats(Long busId, Long routeId) {

		return seatRepository.findByBusRouteAndIsAvailable(busId, routeId, true);
	}

	@Override
	public Reservation bookSeat(ReservationRequest reservationRequest) {

		Seat seat = seatRepository.findByIdAndIsAvailable(reservationRequest.getSeatId(), true);

		Optional<Route> route = routeRepository.findById(reservationRequest.getRouteId());

		if (seat != null && route.isPresent()) {
           seat.setAvailable(false);
           seatRepository.save(seat);
           
           Reservation reservation = new Reservation();
           reservation.setRoute(route.get());
           reservation.setSeat(seat);
           reservation.setUser(reservationRequest.getUserId());
           reservation.setReservationTime(LocalDate.now());
           reservationRepository.save(reservation);
           
           return reservation;
		} else {
			return null;
		}

	}
}
