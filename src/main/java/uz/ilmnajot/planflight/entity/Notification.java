package uz.ilmnajot.planflight.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.ilmnajot.planflight.base.BaseEntity;
import uz.ilmnajot.planflight.enums.NotificationStatus;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "NOTIFICATIONS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notification extends BaseEntity {

    private String message;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
