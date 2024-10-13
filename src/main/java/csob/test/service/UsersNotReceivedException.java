package csob.test.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class UsersNotReceivedException extends RuntimeException {
    public UsersNotReceivedException(String message) {
        super(message);
    }
}
