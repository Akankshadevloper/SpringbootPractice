package com.akankshaproject.demoRestController.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handling code
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        //create a studentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();


        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());


        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {


        StudentErrorResponse error = new StudentErrorResponse();


        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());


        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
