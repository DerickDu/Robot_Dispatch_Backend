package com.flag.robot_dispatch.controller;
import com.flag.robot_dispatch.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

   @ExceptionHandler(UserAlreadyExistException.class)
   public final ResponseEntity<String> handleUserAlreadyExistExceptions(Exception ex, WebRequest request) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
   }

   @ExceptionHandler(UserNotExistException.class)
   public final ResponseEntity<String> handleUserNotExistExceptions(Exception ex, WebRequest request) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
   }

   @ExceptionHandler(OrderNotExistException.class)
   public final ResponseEntity<String> handleOrderNotExistExceptions(Exception ex, WebRequest request) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(InvalidOrderDateException.class)
   public final ResponseEntity<String> handleOInvalidOrderDateExceptions(Exception ex, WebRequest request) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(InvalidInputException.class)
   public final ResponseEntity<String> handleOInvalidInputException(Exception ex, WebRequest request) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
   }
}

