package com.xzone.admin.config;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符过滤器
 */
public class CharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
