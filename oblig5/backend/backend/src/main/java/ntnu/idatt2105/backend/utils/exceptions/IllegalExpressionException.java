package ntnu.idatt2105.backend.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IllegalExpressionException extends ResponseStatusException {

    public IllegalExpressionException(String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }
}
