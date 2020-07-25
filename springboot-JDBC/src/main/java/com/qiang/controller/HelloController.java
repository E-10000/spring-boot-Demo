package com.qiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//控制类就是进行业务操作的东西
@RestController
public class HelloController {

    //自动获得数据库的东西
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
    public Map<String, Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        System.out.println(list.get(0));
        return list.get(0);
    }
}