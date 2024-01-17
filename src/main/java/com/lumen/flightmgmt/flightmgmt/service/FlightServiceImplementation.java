package com.lumen.flightmgmt.flightmgmt.service;
import com.lumen.flightmgmt.flightmgmt.exception.RecordNotFoundException;
import com.lumen.flightmgmt.flightmgmt.models.Flight;
import com.lumen.flightmgmt.flightmgmt.models.Passenger;
import com.lumen.flightmgmt.flightmgmt.repository.FlightRepository;
import com.lumen.flightmgmt.flightmgmt.repository.PassengerRepository;
import com.lumen.flightmgmt.flightmgmt.viewModels.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImplementation implements FlightService {

    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;

    public FlightServiceImplementation(FlightRepository flightRepository, PassengerRepository passengerRepository) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<FlightViewModel> getAll() {
        return flightRepository.findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public FlightPassengerListViewModel getFlightById(int flightId) {
        List<PassengerViewModel> passengers=getChildEntityById(flightId);
        Flight entity=getEntityById(flightId);
        FlightPassengerListViewModel viewModel=new FlightPassengerListViewModel();
        BeanUtils.copyProperties(entity,viewModel);
        viewModel.setFlightId(entity.getFlightId());
        viewModel.setPassengers(passengers);
        return viewModel;
    }

    @Override
    public FlightPassengerListViewModel getFlightByFlightCode(String flightCode) {
        List<PassengerViewModel> passengers=getChildEntityByCode(flightCode);
        FlightPassengerListViewModel viewModel=new FlightPassengerListViewModel();
        Flight entity=toEntity(flightRepository.findAll()
                .stream()
                .filter(f->f.getFlightCode().equals(flightCode))
                .map(this::toViewModel)
                .collect(Collectors.toList()).get(0));
        BeanUtils.copyProperties(entity,viewModel);
        viewModel.setFlightId(entity.getFlightId());
        viewModel.setPassengers(passengers);
        return viewModel;

    }
    @Override
    public  List<FlightViewModel> getFlightByOrigin(String origin) {
        return flightRepository.findAll()
                .stream()
                .filter(f -> f.getOrigin().equals(origin))
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightViewModel> getFlightByDestination(String destination) {
        return flightRepository.findAll()
                .stream()
                .filter(f -> f.getDestination().equals(destination))
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightViewModel> getFlightByCapacity(int capacity) {
        return flightRepository.findAll()
                .stream()
                .filter(f->f.getCapacity()>=capacity)
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public FlightViewModel create(FlightCreateViewModel viewModel) {
        return toViewModel(flightRepository.saveAndFlush(toEntity(viewModel)));
    }

    @Override
    public FlightViewModel update(int flightId, FlightUpdateViewModel viewModel) {
        Flight entity = getEntityById(flightId);
        BeanUtils.copyProperties(viewModel,entity);
        return toViewModel(flightRepository.saveAndFlush(entity));
    }

    @Override
    public void deleteByFlightId(int flightId) {
        flightRepository.delete(getEntityById(flightId));
    }
    private FlightViewModel toViewModel(Flight entity){
        FlightViewModel viewModel=new FlightViewModel();
        BeanUtils.copyProperties(entity,viewModel);
        viewModel.setFlightId(entity.getFlightId());
        return viewModel;
    }
    private PassengerViewModel toViewModel(Passenger entity){
        PassengerViewModel viewModel=new PassengerViewModel();
        BeanUtils.copyProperties(entity,viewModel);
        return viewModel;
    }
    private Flight toEntity(FlightCreateViewModel viewModel){
        Flight entity=new Flight();
        BeanUtils.copyProperties(viewModel,entity);
        return entity;
    }
    private Flight toEntity(FlightViewModel viewModel){
        Flight entity=new Flight();
        BeanUtils.copyProperties(viewModel,entity);
        return entity;
    }
    private Flight getEntityById(int flightId){

        return flightRepository.findById(flightId)
                .orElseThrow(
                        ()->new RecordNotFoundException(String.format("Flight with id: %d is not found",flightId)
                ));
    }
    private List<PassengerViewModel> getChildEntityById(int flightId) {

        return passengerRepository.findAll()
                .stream()
                .filter(f -> f.getFlightId() == flightId)
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }
    private List<PassengerViewModel> getChildEntityByCode(String flightCode) {
        return passengerRepository.findAll()
                .stream()
                .filter(f -> f.getFlightCode().equals(flightCode))
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }
}


