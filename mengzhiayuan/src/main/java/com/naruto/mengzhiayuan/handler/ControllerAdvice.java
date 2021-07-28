package com.naruto.mengzhiayuan.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/25 18:08
 */
//@ControllerAdvice 和 @RestControllerAdvice都是对Controller进行增强的，可以全局捕获spring mvc抛的异常。
//RestControllerAdvice = ControllerAdvice + ResponseBody

//    拦截所有的exception异常
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    //日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*拦截所有exception异常*/
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        //日志记录错误信息
        logger.error("Request Url : {}, Exception : {}",request,e.getMessage());

        /*将找不到资源异常交给springboot来处理，ControllerAdvice不拦截*/
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!= null) {
            throw e;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url:", request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}
