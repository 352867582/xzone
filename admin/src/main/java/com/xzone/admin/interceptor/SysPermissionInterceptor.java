package com.xzone.admin.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzone.utils.ResponseUtil;
import com.xzone.utils.StringUtil;
import com.xzone.xinterface.common.constant.CommonConstant;
import com.xzone.xinterface.common.constant.PropertyConstant;
import com.xzone.xinterface.common.vo.AjaxJson;
import com.xzone.xinterface.sys.model.SysProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

@Slf4j
public class SysPermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        SysPermission sysPermission = method.getAnnotation(SysPermission.class);
        if (Objects.isNull(sysPermission)) {
            return true;
        }
        //获取request中的token
        String token = request.getHeader(CommonConstant.LOGIN_TOKEN);
        //权限不够
        if (StringUtil.isBlank(token)) {
            ResponseUtil.responseRet(JSON.toJSONString(new AjaxJson().fail("权限不足").setRet(AjaxJson.UNAUTHORIZED)));
            return false;
        }
        SysProperty sysProperty = new SysProperty().setPropertyKey(PropertyConstant.TOKEN_SIGN);
        sysProperty = sysProperty.selectOne(new QueryWrapper<>(sysProperty));
        if (sysProperty == null) {
            ResponseUtil.responseRet(JSON.toJSONString(new AjaxJson().fail("未配置:" + PropertyConstant.TOKEN_SIGN)));
            return false;
        }
        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = JWT.require(Algorithm.HMAC256(sysProperty.getPropertyValue())).build().verify(token);
        } catch (Exception e) {
            ResponseUtil.responseRet(JSON.toJSONString(new AjaxJson().fail(e.getMessage()).setRet(AjaxJson.UNAUTHORIZED)));
            return false;
        }
        String userId = decodedJWT.getAudience().get(0);
        request.setAttribute(CommonConstant.SYS_REQUEST_USER_ID, userId);
        return true;
    }
}
