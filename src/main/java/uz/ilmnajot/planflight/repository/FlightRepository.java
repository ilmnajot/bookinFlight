package uz.ilmnajot.planflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ilmnajot.planflight.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
