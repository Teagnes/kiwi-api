package com.kiwi.controller;

import com.kiwi.common.ResultEnum;
import com.kiwi.common.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class FilterErrorController {

    private static final Logger logger = LoggerFactory.getLogger(FilterErrorController.class);

    @ResponseBody
    @GetMapping ("/filterError/emtpyToken")
    public ResponseEntity filterEmptyError(){
        return new ResponseEntity(ResultUtil.fail(ResultEnum.USER_TOKEN_EMPTY), HttpStatus.UNAUTHORIZED);
    }

    @ResponseBody
    @GetMapping ("/filterError/invalideToken")
    public ResponseEntity filterTokenError(){
        return new ResponseEntity(ResultUtil.fail(ResultEnum.USER_TOKEN_INVALID), HttpStatus.UNAUTHORIZED);
    }

}
