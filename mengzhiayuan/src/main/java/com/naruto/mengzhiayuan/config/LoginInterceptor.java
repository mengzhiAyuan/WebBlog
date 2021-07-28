package com.naruto.mengzhiayuan.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/28 19:38
 */
public class LoginInterceptor extends HandlerInterceptorAdapter implements WebMvcConfigurer {
    //preHandle预处理
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/admin");
            return false;//拦截
        }
        return true;
    }
}
