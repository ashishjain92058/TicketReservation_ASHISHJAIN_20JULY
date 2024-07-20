package com.infogain.BusTicketReservationSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infogain.BusTicketReservationSystem.model.Route;

public interface RouteRpository extends JpaRepository<Route, Long>{

	@Query("select r from Route r where (:departure IS NULL OR r.departure = :departure) AND (:arrival IS NULL OR r.arrival = :arrival)")
	List<Route> searchRoute(@Param("departure") String  departure,@Param("arrival") String arrival);

	
}
