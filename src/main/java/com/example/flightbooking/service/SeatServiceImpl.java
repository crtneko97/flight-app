package com.example.flightbooking.service;

import com.example.flightbooking.dto.SeatRequest;
import com.example.flightbooking.dto.SeatResponse;
import com.example.flightbooking.exception.NotFoundException;
import com.example.flightbooking.model.Flight;
import com.example.flightbooking.model.Seat;
import com.example.flightbooking.repository.FlightRepository;
import com.example.flightbooking.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepo;
    private final FlightRepository flightRepo;

    public SeatServiceImpl(SeatRepository seatRepo, FlightRepository flightRepo) {
        this.seatRepo = seatRepo;
        this.flightRepo = flightRepo;
    }

    @Override
    public List<SeatResponse> createSeats(Long flightId, List<SeatRequest> requests) {
        Flight flight = flightRepo.findById(flightId)
                .orElseThrow(() -> new NotFoundException("Flight not found: " + flightId));

        List<Seat> seats = requests.stream().map(req -> {
            Seat s = new Seat();
            s.setSeatNumber(req.getSeatNumber());
            s.setSeatClass(req.getSeatClass());
            s.setFlight(flight);
            return s;
        }).collect(Collectors.toList());

        List<Seat> saved = seatRepo.saveAll(seats);
        return saved.stream().map(SeatResponse::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SeatResponse> getSeats(Long flightId) {
        if (!flightRepo.existsById(flightId)) {
            throw new NotFoundException("Flight not found: " + flightId);
        }
        return seatRepo.findByFlightId(flightId)
                .stream()
                .map(SeatResponse::new)
                .collect(Collectors.toList());
    }
}
