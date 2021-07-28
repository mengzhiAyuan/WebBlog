package com.naruto.mengzhiayuan.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/28 19:09
 * InterceptorRegistry
 * springBoot 拦截器
 * 添加xxx 拦截器
 * addPathPatterns
 * (eg：.addPathPatterns("/im/api/**").addPathPatterns("/sys/api/**") 过滤im/api、sys/api)
 * 排除
 * excludePathPatterns
 * (eg: excludePathPatterns("/upload") 排除 /upload)
 */

@Controller
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
        //除了这两个路径其他路径全部要通过拦截器
    }
}
