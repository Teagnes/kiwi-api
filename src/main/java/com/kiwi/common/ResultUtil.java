package com.kiwi.common;

public class ResultUtil {


    public static ResultBean success(Object data) {
        return new ResultBean(ResultEnum.SUCCESS.getCode(),data);
    }


    public static ResultBean fail(ResultEnum resultEnum) {
        return new ResultBean(resultEnum.getCode(), resultEnum.getMessage());
    }


    public static ResultBean failDefault(String msg){
        return new ResultBean(ResultEnum.UNKNOWN_ERROR.getCode(),msg);
    }



}
