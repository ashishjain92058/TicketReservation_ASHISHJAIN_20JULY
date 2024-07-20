package com.infogain.BusTicketReservationSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infogain.BusTicketReservationSystem.model.Seat;

public interface SeatRpository extends JpaRepository<Seat, Long>{

	@Query("select s from Seat s where bus = :busId and route = :routeId and isAvailable = :t")
	List<Seat> findByBusRouteAndIsAvailable(@Param("busId") Long busId,@Param("routeId") Long routeId,@Param("t") boolean b);

	Seat findByIdAndIsAvailable(Long seatId, boolean b);

	
}
