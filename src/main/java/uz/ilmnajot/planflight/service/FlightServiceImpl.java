package uz.ilmnajot.planflight.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.planflight.model.common.ApiResponse;
import uz.ilmnajot.planflight.repository.FlightRepository;

import java.time.LocalDateTime;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public ApiResponse searchFlight(int page, int size, String departureAirport, String arrivalAirport, LocalDateTime departureDate, Double minPrice, Double maxPrice) {
        return null;
    }
}
