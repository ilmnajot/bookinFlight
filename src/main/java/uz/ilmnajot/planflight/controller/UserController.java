package uz.ilmnajot.planflight.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ilmnajot.planflight.model.common.ApiResponse;
import uz.ilmnajot.planflight.model.request.UserRequest;
import uz.ilmnajot.planflight.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public HttpEntity<ApiResponse> saveUser(@RequestBody UserRequest request) {
        ApiResponse apiResponse = userService.addUser(request);
        return apiResponse !=null
                ? ResponseEntity.status(HttpStatus.CREATED).body(apiResponse)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @GetMapping("/getUser/{userId}")
    public HttpEntity<ApiResponse> getUser(@PathVariable(name = "userId") Long userId) {
        ApiResponse apiResponse = userService.getUser(userId);
        return apiResponse !=null
                ? ResponseEntity.status(HttpStatus.OK).body(apiResponse)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @GetMapping("/getUsers")
    public HttpEntity<ApiResponse> getAllUsers() {
        ApiResponse apiResponse = userService.getAllUsers();
        return apiResponse !=null
                ? ResponseEntity.status(HttpStatus.OK).body(apiResponse)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @PutMapping("/updateUser/{userId}")
    public HttpEntity<ApiResponse> updateUser(@RequestBody UserRequest request,
                                              @PathVariable Long userId) {
        ApiResponse apiResponse = userService.updateUser(request, userId);
        return apiResponse !=null
                ? ResponseEntity.status(HttpStatus.OK).body(apiResponse)
                : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/deleteUser/{userId}")
    public HttpEntity<ApiResponse> removeUser(@PathVariable Long userId) {
        ApiResponse apiResponse = userService.deleteUser(userId);
        return apiResponse !=null
                ? ResponseEntity.status(HttpStatus.OK).body(apiResponse)
                : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
