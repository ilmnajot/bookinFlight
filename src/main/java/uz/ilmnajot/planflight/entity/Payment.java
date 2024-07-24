package uz.ilmnajot.planflight.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.ilmnajot.planflight.base.BaseEntity;
import uz.ilmnajot.planflight.enums.PaymentStatus;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PAYMENTS")
public class Payment extends BaseEntity {


    private LocalDateTime paymentDate;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;
}
