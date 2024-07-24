package uz.ilmnajot.planflight.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.ilmnajot.planflight.entity.*;
import uz.ilmnajot.planflight.enums.BookingStatus;
import uz.ilmnajot.planflight.enums.NotificationStatus;
import uz.ilmnajot.planflight.enums.PaymentStatus;
import uz.ilmnajot.planflight.exception.UserNotFoundException;
import uz.ilmnajot.planflight.model.common.ApiResponse;
import uz.ilmnajot.planflight.repository.*;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final UserRepository userRepository;

    private final NotificationService notificationService;

    private final PaymentRepository paymentRepository;

    private final FlightRepository flightRepository;
    private final NotificationRepository notificationRepository;


    public BookingServiceImpl(BookingRepository bookingRepository,
                              UserRepository userRepository,
                              NotificationService notificationService,
                              PaymentRepository paymentRepository,
                              FlightRepository flightRepository, NotificationRepository notificationRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        this.paymentRepository = paymentRepository;
        this.flightRepository = flightRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public ApiResponse bookTicket(Long userId, Long flightId, Double amount) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(()
                -> new UsernameNotFoundException("flight not found with id: " + flightId));
        if (flight.getSeats() <= 0) {
            throw new UserNotFoundException("there is no available seats in flight with id: " + flightId);
        }

        Booking booking = new Booking();
        booking.setUser(new User(userId));
        booking.setFlight(flight);
        booking.setBookedDate(LocalDateTime.now());
        booking.setStatus(BookingStatus.BOOKED);
        Booking savedBooking = bookingRepository.save(booking);

        flight.setSeats(flight.getSeats() - 1);
        flightRepository.save(flight);

        Notification notification = new Notification();
        notification.setMessage("The ticker has been successfully booked!");
        notification.setDate(LocalDateTime.now());
        notification.setStatus(NotificationStatus.UNREAD);
        notification.setUser(new User(userId));
        notificationRepository.save(notification);
        return new ApiResponse("success", true, savedBooking);
    }

    @Override
    public ApiResponse cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(()
                -> new UserNotFoundException("booking not found with id: " + bookingId));
        if (booking.getStatus().equals(BookingStatus.CANCELLED)) {
            throw new UserNotFoundException("booking cancelled");
        }
        booking.setStatus(BookingStatus.CANCELLED);
        Booking updatedBooking = bookingRepository.save(booking);


        Flight flight = new Flight();
        flight.setSeats(flight.getSeats() + 1);
        flightRepository.save(flight);

        Payment payment = paymentRepository.findByBooking(booking).orElseThrow(() -> new UserNotFoundException("payment not found with id: " + bookingId));
        payment.setPaymentStatus(PaymentStatus.REFUNDED);
        paymentRepository.save(payment);

        Notification notification = new Notification();
        notification.setMessage("The ticket has been successfully cancelled and payment has been refunded!");
        notification.setDate(LocalDateTime.now());
        notification.setStatus(NotificationStatus.UNREAD);
        notification.setUser(booking.getUser());

        return new ApiResponse("success", true, updatedBooking);
    }
}
