package com.xzone.admin.base;

import com.xzone.xinterface.common.vo.AjaxJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public AjaxJson handlerException(Exception e) {
        log.info("全局捕获到异常,请尽快处理:", e);
        return new AjaxJson().setRet(AjaxJson.RET_FAIL).setMsg(e.getMessage());
    }
}
