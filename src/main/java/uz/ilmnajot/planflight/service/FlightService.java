package uz.ilmnajot.planflight.service;

import uz.ilmnajot.planflight.model.common.ApiResponse;

import java.time.LocalDateTime;

public interface FlightService {
    ApiResponse searchFlight(int page, int size, String departureAirport, String arrivalAirport, LocalDateTime departureDate, Double minPrice, Double maxPrice);
}
