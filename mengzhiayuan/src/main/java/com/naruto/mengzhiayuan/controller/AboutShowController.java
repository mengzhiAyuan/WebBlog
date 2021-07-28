package com.naruto.mengzhiayuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/29 20:17
 */

@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
