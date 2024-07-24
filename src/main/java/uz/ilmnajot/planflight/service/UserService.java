package uz.ilmnajot.planflight.service;

import uz.ilmnajot.planflight.model.common.ApiResponse;
import uz.ilmnajot.planflight.model.request.UserRequest;

public interface UserService {
    ApiResponse addUser(UserRequest request);

    ApiResponse getUser(Long userId);

    ApiResponse getAllUsers();

    ApiResponse updateUser(UserRequest request, Long userId);

    ApiResponse deleteUser(Long userId);
}
