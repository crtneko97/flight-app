package com.example.flightbooking.service;

import com.example.flightbooking.dto.SeatRequest;
import com.example.flightbooking.dto.SeatResponse;

import java.util.List;

public interface SeatService {
    List<SeatResponse> createSeats(Long flightId, List<SeatRequest> requests);
    List<SeatResponse> getSeats(Long flightId);
}
