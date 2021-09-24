package com.schizhande.usermanagerservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ApiErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RecordNotFoundException.class})
    public ResponseEntity<ApiResponse> handleNotFound(RecordNotFoundException ex) {
        log.error("### An error occurred: {}", ex.getLocalizedMessage());
        ApiResponse apiResponse =
                ApiResponse.with(HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage(),
                        new RecordNotFoundException(ex.getMessage()).toString());
        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        log.error("### An error occurred: {}", ex.getLocalizedMessage());
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage());
        }
        ApiResponse apiResponse =
                ApiResponse.with(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage(), errors.toString());
        return new ResponseEntity<>(
                apiResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
