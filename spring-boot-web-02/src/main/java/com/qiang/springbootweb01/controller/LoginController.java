package com.qiang.springbootweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //    下面是这个的简化版 @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        if (username!=null && "123456".equals(password)){
            //登陆成功
            session.setAttribute("loginuser",username);
            return "redirect:/dashboard.html";
            //require  include "xx.php"
//            return "dashboard";// dashboard.html
        }else{
            map.put("msg","账户或者密码错误");
            return "login";
        }
    }


}
