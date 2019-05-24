package com.xzone.utils;

import com.xzone.constant.CharsetConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Slf4j
public class ResponseUtil {

    public static void responseRet(String data) {
        HttpServletResponse response = ContextHolderUtil.getResponse();
        response.setCharacterEncoding(CharsetConstant.UTF_8);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            log.error("数据写出异常");
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    log.error("close io error:", e);
                }
            }
        }

    }
}
