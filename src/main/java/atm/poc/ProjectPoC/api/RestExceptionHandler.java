package atm.poc.ProjectPoC.api;

import atm.poc.ProjectPoC.exception.AccountNotFound;
import atm.poc.ProjectPoC.exception.InvalidAccountName;
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
    protected ResponseEntity<Object> handleAccountNotFound(AccountNotFound anf)
    {
        RequestError requestError = new RequestError(anf.getMessage());
        return ResponseEntity.of(Optional.of(requestError));
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleInvalidAccountName(InvalidAccountName ian)
    {
        RequestError requestError = new RequestError(ian.getMessage());
        return ResponseEntity.of(Optional.of(requestError));
    }
}
