package com.xzone.admin.config;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * xss攻击过滤器
 */
@Slf4j
public class XssFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("暂未设置xss过滤");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
