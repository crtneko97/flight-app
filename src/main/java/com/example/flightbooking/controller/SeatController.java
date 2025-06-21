package com.example.flightbooking.controller;

import com.example.flightbooking.dto.SeatRequest;
import com.example.flightbooking.dto.SeatResponse;
import com.example.flightbooking.service.SeatService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights/{flightId}/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<SeatResponse> listSeats(@PathVariable Long flightId) {
        return seatService.getSeats(flightId);
    }

    @PostMapping
    public List<SeatResponse> addSeats(@PathVariable Long flightId,
                                       @Valid @RequestBody List<SeatRequest> requests) {
        return seatService.createSeats(flightId, requests);
    }
}
