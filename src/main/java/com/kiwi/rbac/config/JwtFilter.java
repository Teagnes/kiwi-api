package com.kiwi.rbac.config;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter  extends BasicHttpAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);


    private final static String  X_TOKEN = "xtoken";

    private boolean allowOrigin = true;

    public JwtFilter(){}
    public JwtFilter(boolean allowOrigin){
        this.allowOrigin = allowOrigin;
    }

    /**
     * 执行登录认证
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        executeLogin(request, response);
        return true;

    }

    /**
     *
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response){
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(X_TOKEN);
        JwtToken jwtToken = new JwtToken(token);
        if(StringUtils.isEmpty(token)){
            logger.error("token 为空");
            responseError(response,"/v1/filterError/emtpyToken");
            return true;
        }

        try {
            TokenUtil.verify(token);
            // 如果没有抛出异常则代表登入成功，返回true
            getSubject(request, response).login(jwtToken);
        }catch (Exception e){
            logger.error("token 校验未通过[{}] {}",token,e.getMessage(),e);
            responseError(response,"/v1/filterError/invalideToken");
        }
        return true;
    }


    //filter的异常重定向到controller，以便统一返回
    private void responseError(ServletResponse response, String errorUrl) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //设置编码，否则中文字符在重定向时会变为空字符串
            httpServletResponse.sendRedirect(errorUrl);
        } catch (IOException e1) {
            logger.error(e1.getMessage());
        }
    }



}
