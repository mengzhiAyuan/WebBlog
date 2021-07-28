package com.naruto.mengzhiayuan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/25 18:34
 */
//返回状态
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFountException extends RuntimeException{
    public NotFountException() {
    }

    public NotFountException(String message) {
        super(message);
    }

    public NotFountException(String message, Throwable cause) {
        super(message, cause);
    }

}
