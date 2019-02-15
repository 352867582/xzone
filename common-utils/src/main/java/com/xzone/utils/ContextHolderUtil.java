package com.xzone.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class ContextHolderUtil {

    /**
     * SpringMvc下获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

    }
    /**
     * SpringMvc下获取response
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

    }

    /**
     * SpringMvc下获取session
     *
     * @return
     */
    public static HttpSession getSession() {
        HttpSession session = getRequest().getSession();
        return session;

    }

    /**
     *
     * 直接从容器中获取BEAN对象
     *
     * @param beanId BEAN的ID
     * @return
     */
    public static Object getBean(String beanId) {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(getSession().getServletContext())
                .getBean(beanId);
    }

    /**
     *
     * 直接从容器中获取BEAN对象
     *
     * @param name name
     *  @param type 类型
     * @return
     */
    public static <T> T getBean(String name,Class<T> type) {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(getSession().getServletContext())
                .getBean(name,type);
    }

    /**
     *
     * 直接从容器中获取BEAN对象
     *
     * @param <T>
     *
     * @return
     */
    public static <T> T getBean(Class<T> t) {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(getSession().getServletContext()).getBean(t);
    }
}
