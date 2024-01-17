package com.lumen.flightmgmt.flightmgmt.repository;

import com.lumen.flightmgmt.flightmgmt.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
}
