package dysio9.openfeign.intro.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import feign.RetryableException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(RetryableException.class)
  protected ResponseEntity<String> handleRetryableException(RetryableException e) {
    return new ResponseEntity<>("Error: " + e.getMessage(),
        INTERNAL_SERVER_ERROR);
  }
}
