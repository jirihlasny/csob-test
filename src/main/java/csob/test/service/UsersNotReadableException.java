package csob.test.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class UsersNotReadableException extends RuntimeException {
    public UsersNotReadableException(String message, Throwable cause) {
        super(message, cause);
    }
}
