package uz.ilmnajot.planflight.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.ilmnajot.planflight.model.common.ApiResponse;
import uz.ilmnajot.planflight.service.FlightService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/searchFlight")
    public HttpEntity<ApiResponse> searchFlight(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size,
            @RequestParam(name = "departureAirport", required = false) String departureAirport,
            @RequestParam(name = "arrivalAirport", required = false) String arrivalAirport,
            @RequestParam(name = "departureDateTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDateTime departureDate,
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice) {
        flightService.searchFlight(page, size, departureAirport, arrivalAirport, departureDate, minPrice, maxPrice);
    }
}
