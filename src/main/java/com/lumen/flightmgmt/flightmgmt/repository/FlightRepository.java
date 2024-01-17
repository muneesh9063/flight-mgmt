package com.lumen.flightmgmt.flightmgmt.repository;

import com.lumen.flightmgmt.flightmgmt.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {

}
