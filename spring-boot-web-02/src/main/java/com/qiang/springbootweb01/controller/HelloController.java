package com.qiang.springbootweb01.controller;

import com.qiang.springbootweb01.Bean.Person;
import com.qiang.springbootweb01.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

//@RestController
@Controller
public class HelloController {

    @RequestMapping("/demo01")
    public String ok(Map<String,Object> map){
        map.put("hello","你好");
        Person person = new Person("小明",18);
        map.put("person",person);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("小明");
        arrayList.add("小兰");
        map.put("users",arrayList);
        //返回demo01.html,默认补上.html
        //规定放在templates下
        return "demo01";
    }

    @RequestMapping("/test")
    public String test(@RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        //返回templates/ok.html
        return "ok";
    }
//
//    @RequestMapping({"","/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
