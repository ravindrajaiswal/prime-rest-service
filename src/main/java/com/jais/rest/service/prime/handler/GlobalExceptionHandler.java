package com.jais.rest.service.prime.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    String error = "Malformed JSON request";
    return buildResponseEntity(new LocalizeError(HttpStatus.BAD_REQUEST, error, ex));
  }

  private ResponseEntity<Object> buildResponseEntity(LocalizeError localizeError) {
    return new ResponseEntity<>(localizeError, localizeError.getStatus());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<Object> handleEntityConstraintViolationException(
      ConstraintViolationException ex) {
    LocalizeError localizeError = new LocalizeError(HttpStatus.BAD_REQUEST);
    localizeError.setMessage(ex.getMessage());
    return buildResponseEntity(localizeError);
  }
}
