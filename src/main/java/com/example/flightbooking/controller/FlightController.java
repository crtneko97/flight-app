package com.example.flightbooking.controller;

import com.example.flightbooking.dto.FlightRequest;
import com.example.flightbooking.dto.FlightResponse;
import com.example.flightbooking.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<FlightResponse> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public FlightResponse getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @PostMapping
    public FlightResponse createFlight(@Valid @RequestBody FlightRequest request) {
        return flightService.createFlight(request);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }
}
