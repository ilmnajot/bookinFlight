package uz.ilmnajot.planflight.service;

import uz.ilmnajot.planflight.model.common.ApiResponse;

public interface BookingService {
    ApiResponse bookTicket(Long userId, Long flightId, Double amount);

    ApiResponse cancelBooking(Long bookingId);
}
