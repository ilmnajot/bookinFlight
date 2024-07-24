package uz.ilmnajot.planflight.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.ilmnajot.planflight.entity.User;
import uz.ilmnajot.planflight.enums.Role;
import uz.ilmnajot.planflight.exception.UserNotFoundException;
import uz.ilmnajot.planflight.model.common.ApiResponse;
import uz.ilmnajot.planflight.model.request.UserRequest;
import uz.ilmnajot.planflight.model.response.UserResponse;
import uz.ilmnajot.planflight.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ApiResponse addUser(UserRequest request) {
        Optional<User> byPhoneNumber = userRepository.findByPhoneNumber(request.getPhoneNumber());
        Optional<User> byEmail = userRepository.findByEmail(request.getEmail());
        if (byPhoneNumber.isPresent() && byEmail.isPresent()) {
            throw new UserNotFoundException("User with phone number " + request.getPhoneNumber() + " already exists");
        }
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRole(Role.USER);
        User savedUser = userRepository.save(user);
        UserResponse userResponse = new UserResponse().toUser(savedUser);
        return new ApiResponse("success", true, userResponse);
    }

    @Override
    public ApiResponse getUser(Long userId) {
        User user = getUserById(userId);
        if (userId!=null){
            return new ApiResponse("success", true, user);
        }
        throw new UserNotFoundException("user not found");
    }

    @Override
    public ApiResponse getAllUsers() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            throw new UserNotFoundException("Users not found");
        }
        List<UserResponse> responseList = userList
                .stream()
                .map(user -> new UserResponse().toUser(user))
                .toList();
        return new ApiResponse("success", true, responseList);
    }

    @Override
    public ApiResponse updateUser(UserRequest request, Long userId) {
        return null;
    }

    @Override
    public ApiResponse deleteUser(Long userId) {
        User user = getUserById(userId);
        if (user != null) {
            userRepository.deleteById(userId);
            return new ApiResponse("success", true, "User deleted successfully", HttpStatus.OK);
        }
        return new ApiResponse("failed", false, "User not deleted successfully", HttpStatus.BAD_REQUEST);
    }

    private User getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        return user;
    }
}
