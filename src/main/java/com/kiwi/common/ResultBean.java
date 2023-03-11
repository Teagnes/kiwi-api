package com.kiwi.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SUCESS = "0";

    private static final String FAIL_DEFAUKT="1";

    private String msg = "SUCESS";

    @ApiModelProperty(name = "code码", value = "0为成功", dataType = "String")
    private String code = SUCESS;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
        this.code = SUCESS;
    }

    public ResultBean(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public static ResultBean success(Object data) {
        return new ResultBean(data);
    }

    public static ResultBean fail(String code, String msg) {
        return new ResultBean(code, msg);
    }

    public static ResultBean failDefault(String msg){
        return new ResultBean(FAIL_DEFAUKT,msg);
    }

}
