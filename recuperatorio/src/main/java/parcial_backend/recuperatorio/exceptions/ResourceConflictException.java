package parcial_backend.recuperatorio.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
@Getter
@Setter
public class ResourceConflictException extends RuntimeException{
    private String message;

    public ResourceConflictException(String message) {
        super(message);
        this.message = message;
    }
}
