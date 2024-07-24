package uz.ilmnajot.planflight.model.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import uz.ilmnajot.planflight.enums.Role;

@Data
public class UserRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private String phoneNumber;

    private Role role;
}
