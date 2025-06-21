package com.example.flightbooking.dto;

import com.example.flightbooking.model.Flight;

public class FlightResponse {

    private Long id;
    private String airline;
    private String origin;
    private String destination;
    private String departureTime;

    public FlightResponse(Flight flight) {
        this.id = flight.getId();
        this.airline = flight.getAirline();
        this.origin = flight.getOrigin();
        this.destination = flight.getDestination();
        this.departureTime = flight.getDepartureTime();
    }


    public Long getId() {
        return id;
    }

    public String getAirline() {
        return airline;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }
}
