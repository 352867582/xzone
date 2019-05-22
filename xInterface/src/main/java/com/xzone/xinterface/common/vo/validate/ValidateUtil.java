package com.xzone.xinterface.common.vo.validate;

import com.xzone.utils.ReflectionUtils;
import com.xzone.utils.StringUtil;
import com.xzone.xinterface.common.vo.AjaxJson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
public class ValidateUtil {

    public static AjaxJson validate(Object obj, ValidateEnum validateEnum) {
        try {
            if (obj == null) {
                log.info("validate obj is null");
                return new AjaxJson();
            }
            if (validateEnum == null) {
                log.info("validateEnum is null");
                return new AjaxJson();
            }
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                NotNull notNull = field.getAnnotation(NotNull.class);
                if (notNull == null) {
                    continue;
                }
                ValidateEnum[] validateEnums = notNull.validateGroup();
                if (validateEnums == null || validateEnums.length == 0) {
                    continue;
                }
                boolean hasEnum = false;
                for (int i = 0; i < validateEnums.length; i++) {
                    if (validateEnums[i] == validateEnum) {
                        hasEnum = true;
                        break;
                    }
                }
                if (!hasEnum) {
                    continue;
                }
                String filedName = field.getName();
                filedName = filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
                String methodName = "get" + filedName;
                Method method = ReflectionUtils.findMethod(obj.getClass(), methodName);
                if (method == null) {
                    continue;
                }
                Object invoke = method.invoke(obj);
                if (invoke != null && StringUtils.isNotBlank(String.valueOf(invoke))) {
                    continue;
                }
                String desc = notNull.desc();
                if (StringUtil.isBlank(desc)) {
                    desc = filedName + "不能为空";
                }
                log.info("参数校验未通过:{}", desc);
                return new AjaxJson().setRet(AjaxJson.RET_FAIL).setMsg(desc);
            }
        } catch (Exception e) {
            log.error("参数校验异常,默认校验通过");
            return new AjaxJson();
        }
        return new AjaxJson();
    }
}
