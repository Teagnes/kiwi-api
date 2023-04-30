package com.kiwi.common;

public enum  ResultEnum {




    SUCCESS("000000", "success"),

    UNKNOWN_ERROR("-1", "未知错误"),
    USER_NOT_EXIST("100001", "用户不存在"),
    PASSWORD_ERROR("100002", "密码错误"),

    USER_TOKEN_EMPTY("100201", "token为空"),
    USER_TOKEN_INVALID("100202", "token失效"),
    USER_TOKEN_ILLEGAL("100203", "非法token"),

    USER_NOT_UNAUTHORIZED("100401", "用户未登录"),

    USE_NOT_FOBIDDEN("100403", "用户无权限"),

    PERMISSION_EXIST("101001", "权限已存在"),
    PERMISSION_NOT_EXIST("101002", "权限不存在"),
    PERMISSION_USED("101003", "权限已被使用"),
    PERMISSION_NOT_USED("101004", "权限未被使用"),
    PERMISSION_NOT_EMPTY("101005", "权限不能为空"),

    USER_EXIST("102001", "用户已存在"),
    ROLE_EXIST("103001", "角色已存在"),


    PARAM_ERROR("200001", "参数不合法"),
    DATABASE_ERROR("200002", "数据库异常");

    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
