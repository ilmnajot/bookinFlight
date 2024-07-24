package uz.ilmnajot.planflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ilmnajot.planflight.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
