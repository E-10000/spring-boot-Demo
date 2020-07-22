package com.qiang.springbootweb01.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    //loginuser == > 123
    //登陆之前要做的事，controller方法之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginuser = request.getSession().getAttribute("loginuser");
        if (loginuser == null) {
            //未登陆，返回登陆页面
            //map.put(下标,值)

            request.setAttribute("msg","没有登陆权限");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //登陆成功
            return true;
        }

    }

    //Controller方法处理完之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
