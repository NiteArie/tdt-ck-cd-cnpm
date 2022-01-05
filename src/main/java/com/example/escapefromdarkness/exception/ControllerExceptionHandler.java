package com.example.escapefromdarkness.exception;

import com.example.escapefromdarkness.models.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({
    InvalidRequestException.class
  })
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMessage badRequestException(Exception exception, WebRequest webRequest) {
    return new ErrorMessage(exception.getMessage());
  }
}
