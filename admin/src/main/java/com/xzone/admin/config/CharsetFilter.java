package com.xzone.admin.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符过滤器
 */
@Slf4j
public class CharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.debug("暂未设置字符过滤");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
