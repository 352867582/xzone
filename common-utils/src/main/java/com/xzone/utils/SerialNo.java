package com.xzone.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class SerialNo {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmssSSS");


    /**
     * unId组成规则 ip后2位加上 yyMMddHHmmssSSS共 15位 再加上 3位随机数
     */
    public static synchronized String getUnId() {
        try {
            String ip = IpUtil.getIp();
            String lastPoint = ip.substring(ip.lastIndexOf(".")+1);
            if (lastPoint.length() < 2) {
                lastPoint = StringUtil.leftPad(lastPoint, 2, "0");
            }

            if (lastPoint.length() > 2) {
                lastPoint = lastPoint.substring(lastPoint.length() - 2);
            }
            String dateFormat = simpleDateFormat.format(new Date());
            String codeThree = StringUtil.smsCodeThree();
            return lastPoint + dateFormat + codeThree;
        } catch (Exception e) {
            log.error("主键生产异常", e);
            return null;
        }
    }

}
