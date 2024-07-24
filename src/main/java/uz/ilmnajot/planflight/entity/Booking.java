package uz.ilmnajot.planflight.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.ilmnajot.planflight.base.BaseEntity;
import uz.ilmnajot.planflight.enums.BookingStatus;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOKINGS")
@Builder
public class Booking extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    private LocalDateTime bookedDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
