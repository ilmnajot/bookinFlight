package uz.ilmnajot.planflight.model.response;

import lombok.Data;
import uz.ilmnajot.planflight.entity.User;
import uz.ilmnajot.planflight.enums.Role;
@Data
public class UserResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String phoneNumber;

    private Role role;

    public UserResponse toUser(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setRole(user.getRole());
        return response;
    }
}
