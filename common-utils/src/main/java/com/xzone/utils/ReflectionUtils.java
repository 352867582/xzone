package com.xzone.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;


public class ReflectionUtils {

    public static Method findMethod(Class classz, String methodName) throws Exception {
        Class<?> aClass = Class.forName(classz.getName());
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (StringUtils.isNotBlank(methodName) && StringUtils.equals(method.getName(), methodName)) {
                return method;
            }
        }
        return null;
    }

}
