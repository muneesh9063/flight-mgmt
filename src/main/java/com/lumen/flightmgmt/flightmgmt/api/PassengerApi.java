package com.lumen.flightmgmt.flightmgmt.api;

//import io.swagger.annotations.Api;
import com.lumen.flightmgmt.flightmgmt.service.PassengerService;
import com.lumen.flightmgmt.flightmgmt.viewModels.PassengerCreateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.PassengerUpdateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.PassengerViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/passengers")
//@Api(value = "passengers",tags = {"Passenger API"})
public class PassengerApi {
    private final PassengerService passengerService;

    public PassengerApi(PassengerService passengerService) {
        this.passengerService = passengerService;
    }
    @GetMapping
    public ResponseEntity<List<PassengerViewModel>>getAll(){
        return ResponseEntity.ok(passengerService.getAll());
    }
    @GetMapping("{passengerId}")
    public ResponseEntity<PassengerViewModel>getPassengerById(@PathVariable int passengerId){
        return ResponseEntity.ok(passengerService.getPassengerById(passengerId));
    }
    @PostMapping
    public ResponseEntity<PassengerViewModel> create(@RequestBody PassengerCreateViewModel viewModel){
        return ResponseEntity.ok(passengerService.create(viewModel));
    }
    @PutMapping("{passengerId}")
    public ResponseEntity<PassengerViewModel>update(@PathVariable int passengerId, @RequestBody PassengerUpdateViewModel viewModel){
        return ResponseEntity.ok(passengerService.update(passengerId,viewModel));
    }
    @DeleteMapping("{passengerId}")
    public ResponseEntity<?>deleteById(@PathVariable int passengerId){
        passengerService.deleteByPassengerId(passengerId);
        return ResponseEntity.noContent().build();
    }
}
