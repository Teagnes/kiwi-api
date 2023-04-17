package com.kiwi.controller;

import com.kiwi.common.ResultBean;
import com.kiwi.rbac.exception.RbacException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResultBean<String> exceptionHandler(HttpServletRequest request, Exception e) {
        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);
        return new ResultBean<>(e.getMessage());
    }


    @ExceptionHandler(value = RbacException.class)
    public ResponseEntity   rbacExceptionHandler(HttpServletRequest request, RbacException e) {
        switch (e.getCode()) {
            case "401":
                return new ResponseEntity<ResultBean<String>>(new ResultBean<>(e.getCode(), e.getMessage()), null, HttpStatus.UNAUTHORIZED);
//            case "404":
//                return new ResultBean<>(e.getCode(), e.getMessage());
//            case "500":
//                return new ResultBean<>(e.getCode(), e.getMessage());
            default:
                break;
        }
        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);
        return new ResponseEntity<ResultBean<String>>(new ResultBean<>(e.getCode(), e.getMessage()), null, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = RuntimeException.class)
    public ResultBean<String> runtimeExceptionHandler(HttpServletRequest request, RuntimeException e) {

        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);
        return new ResultBean<>(e.getMessage());
    }

}
