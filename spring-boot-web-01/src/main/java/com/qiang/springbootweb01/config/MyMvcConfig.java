package com.qiang.springbootweb01.config;

import com.qiang.springbootweb01.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map;

//这是替代了控制器，配合thymeleaf使用的
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送  请求来到 success
        registry.addViewController("").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/dashboard.html").setViewName("dashboard");

    }

    //添加拦截器/注册拦截器
    //spring还要排除css，js等静态资源的，但是spring boot默认帮我们排除了
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/login.html","","/","/user/login");
    }
}
