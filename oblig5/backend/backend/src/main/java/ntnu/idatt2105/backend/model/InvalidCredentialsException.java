package ntnu.idatt2105.backend.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class used when invalid credentials are received.
 * Resolves to a 401 UNAUTHORIZED response.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid credentials")
public class InvalidCredentialsException extends RuntimeException {

}
