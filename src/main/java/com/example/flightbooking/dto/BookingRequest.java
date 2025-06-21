package com.example.flightbooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookingRequest {

    @NotBlank(message = "Passenger name is required")
    private String passengerName;

    @NotNull(message = "Flight ID is required")
    private Long flightId;


    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getFlightId() {
        return flightId;
    }
    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
