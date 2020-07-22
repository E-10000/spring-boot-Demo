package com.qiang.springbootweb01.config;

import com.qiang.springbootweb01.filter.MyFilter;
import com.qiang.springbootweb01.listener.MyListener;
import com.qiang.springbootweb01.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration
public class MyServletConfig {

    //注册Servlet
    @Bean
    public ServletRegistrationBean myServlet(){
//        当访问/myServlet的时候
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return registrationBean;
    }

    //注册Filter
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
//        过滤这两个请求
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }
//
    //注册Linster
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }


//    @Bean
//    //和application.properties的配置操作一样
//    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
//        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
//            @Override
//            public void customize(ConfigurableWebServerFactory factory) {
//                factory.setPort(8083);
//            }
//        };
//    }
}
