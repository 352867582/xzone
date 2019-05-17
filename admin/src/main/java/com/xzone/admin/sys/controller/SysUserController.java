package com.xzone.admin.sys.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.JWTParser;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xzone.xinterface.common.vo.AjaxJson;
import com.xzone.xinterface.common.vo.validate.ValidateEnum;
import com.xzone.xinterface.common.vo.validate.ValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xzone.admin.base.BaseController;
import com.xzone.xinterface.sys.model.SysUser;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2019-05-17
 */
@RestController
@RequestMapping("/sysUser")
@Slf4j(topic = "系统用户操作")
public class SysUserController extends BaseController<SysUser> {

    @PostMapping("/login")
    public AjaxJson login(SysUser sysUser) {
        log.info("用户登录:{}",sysUser);
        AjaxJson validate = ValidateUtil.validate(sysUser, ValidateEnum.LOGIN_GROUP);
        if (validate.getRet() == AjaxJson.RET_FAIL) {
            return validate;
        }

        sysUser.setId("9999999999");
        //校验用户名和密码 todo 真正的校验
        //校验通过后返回一个可以获取用户信息的token
        String token  = JWT.create().withAudience(sysUser.getId()).sign(Algorithm.HMAC256(sysUser.getPassword()));
        return new AjaxJson();
    }

    public static void main(String[] args) {
        String signKey = "abc";
        SysUser sysUser = new SysUser().setUsername("kongkong").setPassword("123456").setId("9999999999");
        Date date = DateUtils.addDays(new Date(), 2);
        String token = JWT.create().withExpiresAt(date).withAudience(sysUser.getId()).sign(Algorithm.HMAC256(signKey));
        System.out.println(token);
        DecodedJWT decodedJWT = JWT.decode(token);
        String userId = decodedJWT.getAudience().get(0);
        Date expiresAt = decodedJWT.getExpiresAt();
        System.out.println(userId);
        System.out.println(expiresAt);
    }
}
