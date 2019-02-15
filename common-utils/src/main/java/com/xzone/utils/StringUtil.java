package com.xzone.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StringUtil extends StringUtils {

    public static String smsCodeThree() {
        return String.valueOf((new Random().nextInt(899) + 100));
    }

    /**
     * 获取4位数随机验证码
     */
    public static String smsCodeFour() {
        return String.valueOf((new Random().nextInt(8999) + 1000));
    }

    /**
     * 获取6位数随机验证码
     */
    public static String smsCodeSix() {
        return String.valueOf((new Random().nextInt(899999) + 100000));
    }

    /**
     * 将url参数转换成map
     * @param param aa=11&bb=22&cc=33
     */
    public static Map<String, Object> getUrlParams(String param) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isBlank(param)) {
            return map;
        }
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }


}
