package com.master.courseservice.sheard.exception;

import java.util.Collections;
import java.util.List;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }

    private List<Error> errors;

    public ValidationException(String message, List<Error> errors) {
        super(message);
        this.errors = errors;
    }

    public ValidationException() {
    }

    public ValidationException(List<Error> errors) {
        this(null, errors);
    }

    public ValidationException(Error error) {
        this(null, Collections.singletonList(error));
    }

    public List<Error> getErrors() {
        return errors;
    }

}
