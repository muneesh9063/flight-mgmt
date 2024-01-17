package com.lumen.flightmgmt.flightmgmt.service;

import com.lumen.flightmgmt.flightmgmt.viewModels.FlightCreateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.FlightPassengerListViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.FlightUpdateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.FlightViewModel;

import java.util.List;

public interface FlightService {
    List<FlightViewModel>getAll();
    FlightPassengerListViewModel getFlightById(int flightId);
    FlightPassengerListViewModel getFlightByFlightCode(String flightCode);
    List<FlightViewModel> getFlightByOrigin(String origin);
    List<FlightViewModel> getFlightByDestination(String destination);
    List<FlightViewModel> getFlightByCapacity(int capacity);
    FlightViewModel create(FlightCreateViewModel viewModel);
    FlightViewModel update(int flightId, FlightUpdateViewModel viewModel);
    void deleteByFlightId(int flightId);
}
