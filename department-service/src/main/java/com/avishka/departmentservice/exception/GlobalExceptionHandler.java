package com.avishka.departmentservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false), "DEPARTMENT_NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentCodeAlreadyExist.class)
    public ResponseEntity<ErrorDetails> handleDepartmentAlreadyExistException(DepartmentCodeAlreadyExist ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false), "DEPARTMENT_ALREADY_EXIST");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false), "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();

        List<ObjectError> erorrList = ex.getBindingResult().getAllErrors();

        for (ObjectError error : erorrList) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
