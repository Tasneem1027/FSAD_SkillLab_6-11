package com.klu.skill_9.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 🔴 Handle Student Not Found
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseBody
    public ErrorResponse handleStudentNotFound(StudentNotFoundException ex) {

        return new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()   // 404
        );
    }

    // 🔴 Handle Invalid Input
    @ExceptionHandler(InvalidInputException.class)
    @ResponseBody
    public ErrorResponse handleInvalidInput(InvalidInputException ex) {

        return new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()   // 400
        );
    }

    // 🔴 Optional: Handle all other exceptions
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse handleGeneralException(Exception ex) {

        return new ErrorResponse(
                LocalDateTime.now(),
                "Something went wrong!",
                HttpStatus.INTERNAL_SERVER_ERROR.value()   // 500
        );
    }
}