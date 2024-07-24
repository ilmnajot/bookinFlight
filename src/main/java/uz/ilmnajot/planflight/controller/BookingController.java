package uz.ilmnajot.planflight.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ilmnajot.planflight.model.common.ApiResponse;
import uz.ilmnajot.planflight.service.BookingService;
import uz.ilmnajot.planflight.service.UserServiceImpl;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final UserServiceImpl userServiceImpl;

    public BookingController(BookingService bookingService, UserServiceImpl userServiceImpl) {
        this.bookingService = bookingService;
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/book")
    public HttpEntity<ApiResponse> bookTicket(@RequestParam(name = "userId") Long userId,
                                              @RequestParam(name = "flightId") Long flightId,
                                              @RequestParam(name = "amount") Double amount){
        ApiResponse apiResponse = bookingService.bookTicket(userId, flightId, amount);
    return apiResponse != null
            ? ResponseEntity.status(HttpStatus.CREATED).body(apiResponse)
            : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @PostMapping("/cancel/{bookingId}")
    public HttpEntity<ApiResponse> cancelBooking(@PathVariable(name = "bookingId") Long bookingId){
        bookingService.cancelBooking(bookingId);
    }
}
