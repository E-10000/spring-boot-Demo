package com.qiang.springbootweb01.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("当前WEB项目销毁");
    }
}

