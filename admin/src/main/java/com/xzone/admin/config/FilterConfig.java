package com.xzone.admin.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.Arrays;

@Configuration
public class FilterConfig {

    /**
     * 编码过滤器
     */
    @Bean
    public FilterRegistrationBean charsetFilterBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new CharsetFilter());
        registration.setUrlPatterns(Arrays.asList("/*"));
        registration.setName("charsetFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * xss过滤器
     */
    @Bean
    public FilterRegistrationBean xssFilterBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new XssFilter());
        registration.setUrlPatterns(Arrays.asList("/*"));
        registration.setName("xssFilter");
        registration.setOrder(2);
        return registration;
    }
}
