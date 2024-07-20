package com.infogain.BusTicketReservationSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infogain.BusTicketReservationSystem.model.User_Details;

@Repository
public interface UserRepository extends JpaRepository<User_Details,Integer>{

	Optional<User_Details> findByUserName(String userName);
}
