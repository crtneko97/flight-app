package com.example.flightbooking.service;

import com.example.flightbooking.dto.BookingRequest;
import com.example.flightbooking.dto.BookingResponse;
import com.example.flightbooking.exception.NotFoundException;
import com.example.flightbooking.model.Booking;
import com.example.flightbooking.model.Flight;
import com.example.flightbooking.repository.BookingRepository;
import com.example.flightbooking.repository.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FlightRepository flightRepo;

    public BookingServiceImpl(BookingRepository bookingRepo, FlightRepository flightRepo) {
        this.bookingRepo = bookingRepo;
        this.flightRepo = flightRepo;
    }

    @Override
    public BookingResponse createBooking(BookingRequest request) {
        Flight flight = flightRepo.findById(request.getFlightId())
                .orElseThrow(() -> new NotFoundException("Flight not found: " + request.getFlightId()));

        Booking b = new Booking();
        b.setPassengerName(request.getPassengerName());
        b.setFlight(flight);
        Booking saved = bookingRepo.save(b);
        return new BookingResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookingResponse> getAllBookings() {
        return bookingRepo.findAll().stream()
                .map(BookingResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BookingResponse getBookingById(Long id) {
        Booking b = bookingRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found: " + id));
        return new BookingResponse(b);
    }

    @Override
    public void deleteBooking(Long id) {
        if (!bookingRepo.existsById(id)) {
            throw new NotFoundException("Booking not found: " + id);
        }
        bookingRepo.deleteById(id);
    }
}
