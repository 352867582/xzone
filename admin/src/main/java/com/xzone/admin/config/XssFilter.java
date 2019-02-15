package com.xzone.admin.config;


import javax.servlet.*;
import java.io.IOException;

/**
 * xss攻击过滤器
 */
public class XssFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
