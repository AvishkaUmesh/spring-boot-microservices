package com.avishka.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DepartmentCodeAlreadyExist extends RuntimeException {

    private String message;

    public DepartmentCodeAlreadyExist(String message) {
        super(message);
    }
}
