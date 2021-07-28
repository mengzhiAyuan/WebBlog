package com.naruto.mengzhiayuan.aspect;

import com.naruto.mengzhiayuan.pojo.RequestLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/26 17:30
 */

//日志处理

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //这个注解表示一个切面,execution()表示拦截哪些
    //拦截controller下所有类和所有方法
    @Pointcut("execution(* com.naruto.mengzhiayuan.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //这个attributes可以获得url和ip

//        JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象.
//
//        常用API
//
//        Signature getSignature();	获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
//        Object[] getArgs();	获取传入目标方法的参数对象
//        Object getTarget();	获取被代理的对象
//        Object getThis();	获取代理对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request: {}", requestLog);
    }

    @After("log()")
    public void doAfter(){
        logger.info("------doAfter-------");
    }

    //捕获返回的内容
    @AfterReturning(returning ="result",pointcut ="log()")
    public void doAfterReturern(Object result){
        logger.info("Result: {}"+result);
    }
}
