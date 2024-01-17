package com.lumen.flightmgmt.flightmgmt.viewModels;

import java.time.LocalDateTime;
import java.util.List;

public class FlightPassengerListViewModel {
    private int flightId;
    private String flightCode;
    private String origin;
    private String destination;
    private LocalDateTime localDateTime;
    private int capacity;
    private List<PassengerViewModel> passengers;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<PassengerViewModel> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerViewModel> passengers) {
        this.passengers = passengers;
    }
}
