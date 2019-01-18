package com.master.courseservice.sheard.response;

public enum ResponseStatus {
    OK(200, "OK", "success"),
    BAD_REQUEST(400, "Bad Request", "error"),
    NOT_FOUND(404, "Not Found", "error"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", "fail");

    private final int code;
    private final String reason;
    private final String type;

    ResponseStatus(int code, String reason, String type) {
        this.code = code;
        this.reason = reason;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    public String getType() {
        return type;
    }

}
