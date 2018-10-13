package com.master.departmentservice.sheard.errors;

public class Error {

    private final String message;

    public Error(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Error{" + "message='" + message + '\'' + '}';
    }
}
