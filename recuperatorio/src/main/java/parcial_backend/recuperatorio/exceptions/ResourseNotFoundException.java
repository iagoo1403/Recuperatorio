package parcial_backend.recuperatorio.exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourseNotFoundException extends RuntimeException {
    public String message;

    public ResourseNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
