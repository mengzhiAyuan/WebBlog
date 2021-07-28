package com.naruto.mengzhiayuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/26 19:03
 */
//记录日志的内容，记录日志类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLog {
    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;
}