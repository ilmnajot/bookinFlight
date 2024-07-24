package uz.ilmnajot.planflight.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.planflight.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
}
