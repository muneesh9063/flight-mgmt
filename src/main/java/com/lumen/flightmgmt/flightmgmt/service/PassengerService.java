package com.lumen.flightmgmt.flightmgmt.service;

import com.lumen.flightmgmt.flightmgmt.viewModels.PassengerCreateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.PassengerUpdateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.PassengerViewModel;

import java.util.List;

public interface PassengerService {
    List<PassengerViewModel>getAll();
    PassengerViewModel getPassengerById(Integer passengerId);
    PassengerViewModel create(PassengerCreateViewModel viewModel);
    PassengerViewModel update(int passengerId, PassengerUpdateViewModel viewModel);
    void deleteByPassengerId(int passengerId);

    boolean validate(String email,long mobileNumber);
}
