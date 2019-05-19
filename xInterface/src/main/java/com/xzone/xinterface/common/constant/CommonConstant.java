package com.xzone.xinterface.common.constant;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class CommonConstant {

    public static final String LOGIN_TOKEN = "LOGIN_TOKEN";

    public static final String SYS_REQUEST_USER_ID = "LOGIN_TOKEN";

    public static void main(String[] args) {
        String sign = JWT.create().withAudience("123456").withExpiresAt(DateUtils.addDays(new Date(),2)).sign(Algorithm.HMAC256("kongkong"));
        System.out.println(sign);

        JWT.require(Algorithm.HMAC256("kongkong")).build().verify(sign);
    }

}
