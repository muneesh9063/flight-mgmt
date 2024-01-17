package com.lumen.flightmgmt.flightmgmt.service;

import com.lumen.flightmgmt.flightmgmt.exception.RecordNotFoundException;
import com.lumen.flightmgmt.flightmgmt.models.Flight;
import com.lumen.flightmgmt.flightmgmt.models.Passenger;
import com.lumen.flightmgmt.flightmgmt.repository.FlightRepository;
import com.lumen.flightmgmt.flightmgmt.repository.PassengerRepository;
import com.lumen.flightmgmt.flightmgmt.viewModels.PassengerCreateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.PassengerUpdateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.PassengerViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImplementation implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;

    public PassengerServiceImplementation(PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public List<PassengerViewModel> getAll() {
        return passengerRepository.findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public PassengerViewModel getPassengerById(Integer passengerId) {
        return toViewModel(getEntityById(passengerId));
    }

    @Override
    public PassengerViewModel create(PassengerCreateViewModel viewModel) {
//        boolean result=validate(viewModel.getEmail(),viewModel.getMobileNumber());
//        if (result) {
            return toViewModel(passengerRepository.saveAndFlush(toEntity(viewModel)));
//        }
//        return new PassengerViewModel();
    }

    @Override
    public PassengerViewModel update(int passengerId, PassengerUpdateViewModel viewModel) {
        Passenger entity=getEntityById(passengerId);
        BeanUtils.copyProperties(viewModel,entity);
        return toViewModel(passengerRepository.saveAndFlush(entity));
    }

    @Override
    public void deleteByPassengerId(int passengerId){
        passengerRepository.deleteById(passengerId);
    }

    @Override
    public boolean validate(String email, long mobileNumber) {
        if(email.contains("@gmail.com")) {
            return true;
        }
        return false;
    }

    private PassengerViewModel toViewModel(Passenger entity) {
        PassengerViewModel viewModel = new PassengerViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }
    private Passenger toEntity(PassengerCreateViewModel passengerViewModel){
        Flight flight=getParentEntityById(passengerViewModel.getFlightId());
        Passenger entity=new Passenger();
        BeanUtils.copyProperties(passengerViewModel,entity);
        entity.setFlight(flight);
        return entity;
    }
    private Passenger getEntityById(int passengerId){
        return passengerRepository.findById(passengerId)
                .orElseThrow(
                        ()-> new RecordNotFoundException(String.format("Passenger with id: %d is not found",passengerId)
                        ));
    }
    private Flight getParentEntityById(int flightId){
        return flightRepository.findById(flightId)
                .orElseThrow(
                        ()-> new RecordNotFoundException(String.format("Flight with id: %d is not found",flightId)
                        ));
    }
}
