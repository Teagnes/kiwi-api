package com.kiwi.common;

import java.util.HashMap;
import java.util.Map;

public class ResultCode {

   private final static  Map<String,String> codeMsg = new HashMap<String,String>(){
       {
           put("0","success");
           put("100401","token为空");
           put("100402","token失效");
           put("100403","非法token");
           put("100405","当前角色无权限");
           put("100406","账号不存在");
           put("100407","密码错误");
           put("100408","账号密码登陆失败");
           put("101001","权限已存在");
           put("102001","用户已存在");
           put("103001","角色已存在");

       }
   };

   public static String getMsg(String code){
       if(codeMsg.containsKey(code)){
           return codeMsg.get(code);
       }else {
           return "";
       }

   }



}
