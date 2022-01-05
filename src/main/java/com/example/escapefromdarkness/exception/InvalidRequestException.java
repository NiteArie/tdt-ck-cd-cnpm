package com.example.escapefromdarkness.exception;

public class InvalidRequestException extends Exception {
  public InvalidRequestException() {
  }

  public InvalidRequestException(String message) {
    super(message);
  }

  public InvalidRequestException(Throwable throwable) {
    super(throwable);
  }

  public InvalidRequestException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
