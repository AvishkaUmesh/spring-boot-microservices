package com.avishka.organizationservice.exception;

public class OrganizationAlreadyExistException extends RuntimeException {

    public OrganizationAlreadyExistException(String message) {
        super(message);
    }
}
