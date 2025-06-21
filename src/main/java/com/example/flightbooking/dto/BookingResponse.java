package com.example.flightbooking.dto;

import com.example.flightbooking.model.Booking;

public class BookingResponse {

    private Long id;
    private String passengerName;
    private Long flightId;

    public BookingResponse(Booking booking) {
        this.id = booking.getId();
        this.passengerName = booking.getPassengerName();
        this.flightId = booking.getFlight().getId();
    }


    public Long getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Long getFlightId() {
        return flightId;
    }
}
