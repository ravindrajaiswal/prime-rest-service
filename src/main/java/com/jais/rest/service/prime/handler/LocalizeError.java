package com.jais.rest.service.prime.handler;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class LocalizeError {
  private HttpStatus status;

  private LocalDateTime timestamp;

  private String message;
  private String debugMessage;

  private LocalizeError() {
    timestamp = LocalDateTime.now();
  }

  LocalizeError(HttpStatus status) {
    this();
    this.status = status;
  }

  LocalizeError(HttpStatus status, Throwable ex) {
    this();
    this.status = status;
    this.message = "Unexpected error happened";
    this.debugMessage = ex.getLocalizedMessage();
  }

  LocalizeError(HttpStatus status, String message, Throwable ex) {
    this();
    this.status = status;
    this.message = message;
    this.debugMessage = ex.getLocalizedMessage();
  }
}
