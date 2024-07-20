package com.infogain.BusTicketReservationSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.BusTicketReservationSystem.model.Bus;


@Repository
public interface BusRpository extends JpaRepository<Bus,Long>{

}
