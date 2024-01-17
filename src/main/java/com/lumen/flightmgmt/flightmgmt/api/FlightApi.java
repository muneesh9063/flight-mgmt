package com.lumen.flightmgmt.flightmgmt.api;

import com.lumen.flightmgmt.flightmgmt.service.FlightService;
import com.lumen.flightmgmt.flightmgmt.viewModels.FlightCreateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.FlightPassengerListViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.FlightUpdateViewModel;
import com.lumen.flightmgmt.flightmgmt.viewModels.FlightViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flights")
//@Api(value = "flights",tags = {"Flight API"})
public class FlightApi {
    private final FlightService flightService;

    public FlightApi(FlightService flightService) {
        this.flightService = flightService;
    }
    @GetMapping
    public ResponseEntity<List<FlightViewModel>>getAll(){
        return ResponseEntity.ok(flightService.getAll());
    }
    @GetMapping("{flightId}")
    public ResponseEntity<FlightPassengerListViewModel>getFlightById(@PathVariable int flightId){
        return ResponseEntity.ok(flightService.getFlightById(flightId));
    }
    @GetMapping("/code/{flightCode}")
    public ResponseEntity<FlightPassengerListViewModel>getFlightByCode(@PathVariable String flightCode){
        return ResponseEntity.ok(flightService.getFlightByFlightCode(flightCode));
    }
    @GetMapping("/origin/{origin}")
    public ResponseEntity<List<FlightViewModel>> getFlightByOrigin(@PathVariable String origin){
        return ResponseEntity.ok(flightService.getFlightByOrigin(origin));
    }
    @GetMapping("/destination/{destination}")
    public ResponseEntity<List<FlightViewModel>>getFlightByDestination(@PathVariable String destination){
        return ResponseEntity.ok(flightService.getFlightByDestination(destination));
    }
    @GetMapping("/capacity/{capacity}")
    public ResponseEntity<List<FlightViewModel>>getFlightByCapacity(@PathVariable int capacity){
        return ResponseEntity.ok(flightService.getFlightByCapacity(capacity));
    }
    @PostMapping
    public ResponseEntity<FlightViewModel>create(@RequestBody FlightCreateViewModel viewModel){
        return ResponseEntity.ok(flightService.create(viewModel));
    }
    @PutMapping("{flightId}")
    public ResponseEntity<FlightViewModel>update(@PathVariable int flightId, @RequestBody FlightUpdateViewModel viewModel){
        return ResponseEntity.ok(flightService.update(flightId,viewModel));
    }
    @DeleteMapping("{flightId}")
    public ResponseEntity<?>deleteById(@PathVariable int flightId){
        flightService.deleteByFlightId(flightId);
        return ResponseEntity.noContent().build();
    }

}
