package atm.poc.ProjectPoC.api;

import atm.poc.ProjectPoC.exception.AccountNotFound;
import atm.poc.ProjectPoC.exception.InvalidAccountName;
import atm.poc.ProjectPoC.exception.InvalidAmount;
import atm.poc.ProjectPoC.exception.RequestError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> handleErrors(Exception ex)
    {
        if (ex instanceof AccountNotFound || ex instanceof InvalidAccountName || ex instanceof InvalidAmount) {
            RequestError requestError = new RequestError(ex.getMessage());
            return ResponseEntity.of(Optional.of(requestError));
        }
        return null;
    }

}
