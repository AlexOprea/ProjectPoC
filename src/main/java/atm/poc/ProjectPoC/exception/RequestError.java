package atm.poc.ProjectPoC.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class RequestError {
    @JsonFormat
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    @JsonFormat
    private String errorMessage;

    public RequestError(@JsonProperty String errorMessage)
    {
        timestamp = LocalDateTime.now();
        this.errorMessage = errorMessage;
        status = HttpStatus.NOT_FOUND;
    }
}
