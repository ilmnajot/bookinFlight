package uz.ilmnajot.planflight.entity;

import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;
import lombok.*;
import uz.ilmnajot.planflight.base.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "FLIGHTS")
public class Flight extends BaseEntity {

    private String flightNumber;
    private String airline;
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private Double price;

    private int seats;
}
