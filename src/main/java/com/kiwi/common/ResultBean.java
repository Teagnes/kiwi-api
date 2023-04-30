package com.kiwi.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String msg = "SUCESS";

    private T data;

    public ResultBean() {
        super();
    }

    public static final String SUCESS = "0";

    private static final String FAIL_DEFAUKT="1";

    public ResultBean(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }
}
