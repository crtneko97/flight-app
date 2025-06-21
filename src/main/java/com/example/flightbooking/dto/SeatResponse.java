package com.example.flightbooking.dto;

import com.example.flightbooking.model.Seat;
import com.example.flightbooking.model.SeatClass;

public class SeatResponse {
    private Long id;
    private String seatNumber;
    private SeatClass seatClass;

    public SeatResponse(Seat seat) {
        this.id = seat.getId();
        this.seatNumber = seat.getSeatNumber();
        this.seatClass = seat.getSeatClass();
    }

    // getters only
    public Long getId() { return id; }
    public String getSeatNumber() { return seatNumber; }
    public SeatClass getSeatClass() { return seatClass; }
}
