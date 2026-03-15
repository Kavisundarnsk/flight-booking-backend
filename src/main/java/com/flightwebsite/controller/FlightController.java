package com.flightwebsite.controller;

import com.flightwebsite.entity.Flight;
import com.flightwebsite.repository.FlightRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightRepository repo;

    public FlightController(FlightRepository repo) {
        this.repo = repo;
    }

    // GET all flights
    @GetMapping
    public List<Flight> getFlights() {
        return repo.findAll();
    }

    // ADD flight
    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return repo.save(flight);
    }

    // GET flight by id
    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE flight
    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        flight.setId(id);
        return repo.save(flight);
    }

    // DELETE flight
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        repo.deleteById(id);
    }



    // SEARCH flights
    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam String source,
            @RequestParam String destination) {

        return repo.findBySourceIgnoreCaseAndDestinationIgnoreCase(source.trim(), destination.trim());
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlights(){
        return repo.findAll();
    }
    



}
