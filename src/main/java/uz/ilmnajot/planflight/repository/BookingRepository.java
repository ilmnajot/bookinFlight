package uz.ilmnajot.planflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ilmnajot.planflight.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
