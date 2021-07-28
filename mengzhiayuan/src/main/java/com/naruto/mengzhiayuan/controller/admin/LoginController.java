package com.naruto.mengzhiayuan.controller.admin;


import com.naruto.mengzhiayuan.pojo.User;
import com.naruto.mengzhiayuan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author ：mengzhiayuan
 * @description：TODO
 * @date ：2021/4/28 15:36
 */

//后台登录控制器
/*RedirectAttributes是Spring mvc 3.1版本之后出来的一个功能，专门用于重定向之后还能带参数跳转的

他有两种带参的方式：
第一种：
attr.addAttribute(“param”, value);
这种方式就相当于重定向之后，在url后面拼接参数，这样在重定向之后的页面或者控制器再去获取url后面的参数就可以了，但这个方式因为是在url后面添加参数的方式，所以暴露了参数，有风险
例：
attr.addAttribute(“name”, “123”);
attr.addAttribute(“success”, “success”);
return “redirect:/index”;
这样就相当于：return “redirect:/index?name=123&success=success”

第二种：
attr.addFlashAttribute(“param”, value);
这种方式也能达到重新向带参，而且能隐藏参数，其原理就是放到session中，session在跳到页面后马上移除对象。所以你刷新一下后这个值就会丢掉
例：
attr.addFlashAttribute(“status”,“999”);
attr.addFlashAttribute(“message”,“登录失败”);
return “redirect:/toLogin”;*/


@Controller
@RequestMapping("/admin")
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //springboot自动拼接到资源文件下的html页面
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    //@GetMapping用于将HTTP get请求映射到特定处理程序的方法注解
    //具体来说，@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
    //
    //@PostMapping用于将HTTP post请求映射到特定处理程序的方法注解
    //具体来说，@PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写

    @RequestMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            //不要把密码传到前端页面
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else {
            //因为这是redirect到index页面，如果用model会得不到这个数据
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }


//    @GetMapping("/logout")
//    public String logout() {
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
//        return "admin/login";
//    }

// 不用安全框架的话退出要把session里的内容清空
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "admin/login";
    }

}
