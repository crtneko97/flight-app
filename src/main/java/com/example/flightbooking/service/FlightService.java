package com.example.flightbooking.service;

import com.example.flightbooking.dto.FlightRequest;
import com.example.flightbooking.dto.FlightResponse;

import java.util.List;

public interface FlightService {
    FlightResponse createFlight(FlightRequest request);
    List<FlightResponse> getAllFlights();
    FlightResponse getFlightById(Long id);
    void deleteFlight(Long id);
}
