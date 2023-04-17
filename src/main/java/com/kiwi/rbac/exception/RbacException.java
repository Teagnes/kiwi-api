package com.kiwi.rbac.exception;

public class RbacException extends RuntimeException {

    private String code;

    public RbacException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
