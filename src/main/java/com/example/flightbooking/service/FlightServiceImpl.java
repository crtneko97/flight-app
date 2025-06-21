package com.example.flightbooking.service;

import com.example.flightbooking.dto.FlightRequest;
import com.example.flightbooking.dto.FlightResponse;
import com.example.flightbooking.exception.NotFoundException;
import com.example.flightbooking.model.Flight;
import com.example.flightbooking.repository.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repo;

    public FlightServiceImpl(FlightRepository repo) {
        this.repo = repo;
    }

    @Override
    public FlightResponse createFlight(FlightRequest request) {
        Flight f = new Flight();
        f.setAirline(request.getAirline());
        f.setOrigin(request.getOrigin());
        f.setDestination(request.getDestination());
        f.setDepartureTime(request.getDepartureTime());
        Flight saved = repo.save(f);
        return new FlightResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FlightResponse> getAllFlights() {
        return repo.findAll().stream()
                .map(FlightResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FlightResponse getFlightById(Long id) {
        Flight f = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Flight not found: " + id));
        return new FlightResponse(f);
    }

    @Override
    public void deleteFlight(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Flight not found: " + id);
        }
        repo.deleteById(id);
    }
}
