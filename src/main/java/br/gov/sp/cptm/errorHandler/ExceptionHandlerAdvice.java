package br.gov.sp.cptm.errorHandler;

import br.gov.sp.cptm.dto.ErrorResponse;
import br.gov.sp.cptm.util.exception.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorResponse> handleGenericError(GenericException ex) {
        return ResponseEntity.status(ex.getMessage().contains("not found") ?
                        HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }
}
