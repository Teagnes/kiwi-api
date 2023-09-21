package com.kiwi.controller;

import com.kiwi.common.ResultBean;
import com.kiwi.common.ResultEnum;
import com.kiwi.common.ResultUtil;
import com.kiwi.rbac.exception.RbacException;
import org.apache.shiro.authz.UnauthorizedException;
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
//        return new ResultBean<>(e.getMessage());
        return ResultUtil.failDefault(e.getMessage());
    }


    @ExceptionHandler(value = RbacException.class)
    public ResponseEntity   rbacExceptionHandler(HttpServletRequest request, RbacException e) {
        switch (e.getCode()) {
            case "401":
                return new ResponseEntity<ResultBean<String>>(ResultUtil.fail(ResultEnum.USER_NOT_UNAUTHORIZED), null, HttpStatus.UNAUTHORIZED);
            case "403":
                return new ResponseEntity<ResultBean<String>>(ResultUtil.fail(ResultEnum.USE_NOT_FOBIDDEN), null, HttpStatus.FORBIDDEN);
//            case "500":
//                return new ResultBean<>(e.getCode(), e.getMessage());
            default:
                break;
        }
        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);
        return new ResponseEntity<ResultBean<String>>(new ResultBean<>(e.getCode(), e.getMessage()), null, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseEntity unauthorizedExceptionHandler(HttpServletRequest request, UnauthorizedException e) {
        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e.getMessage());
        return  new ResponseEntity<ResultBean<String>>(ResultUtil.fail(ResultEnum.USE_NOT_FOBIDDEN ,e.getMessage() ),null, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(value = RuntimeException.class)
    public ResultBean<String> runtimeExceptionHandler(HttpServletRequest request, RuntimeException e) {

        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);
        return ResultUtil.failDefault(e.getMessage());
    }




}
