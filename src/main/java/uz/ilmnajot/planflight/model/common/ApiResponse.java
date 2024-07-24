package uz.ilmnajot.planflight.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {

    private String message;
    private boolean success;
    private Object data;
    private HttpStatus status;


    public ApiResponse(String message, boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }
    public ApiResponse(String message, boolean success, Object data, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.data = data;
        this.status = status;
    }

    public ApiResponse() {
    }
}
