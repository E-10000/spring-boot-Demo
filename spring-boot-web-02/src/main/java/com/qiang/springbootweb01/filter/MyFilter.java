package com.qiang.springbootweb01.filter;


import javax.servlet.*;
import java.io.IOException;

//注意是javax.servlet.*;
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter启动中");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
