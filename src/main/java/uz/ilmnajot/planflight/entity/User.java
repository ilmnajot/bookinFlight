package uz.ilmnajot.planflight.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.*;
import uz.ilmnajot.planflight.base.BaseEntity;
import uz.ilmnajot.planflight.enums.Role;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="USERS")
@Table(name = "USERS")
@Builder
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(Long userId) {

    }
}
