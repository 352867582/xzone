package com.xzone.admin.sys.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzone.utils.StringUtil;
import com.xzone.xinterface.common.constant.PropertyConstant;
import com.xzone.xinterface.common.vo.AjaxJson;
import com.xzone.xinterface.common.vo.validate.ValidateEnum;
import com.xzone.xinterface.common.vo.validate.ValidateUtil;
import com.xzone.xinterface.sys.model.SysProperty;
import com.xzone.xinterface.sys.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@RestController
@RequestMapping("/sysUser")
@Slf4j
public class SysUserController {

    @PostMapping(value = "/login")
    public AjaxJson login(SysUser sysUser) {
        log.info("用户登录:{}", sysUser);
        AjaxJson ajaxJson = ValidateUtil.validate(sysUser, ValidateEnum.LOGIN_GROUP);
        if (ajaxJson.getRet() == AjaxJson.RET_FAIL) {
            return ajaxJson;
        }
        //校验用户名密码
        SysUser selSysUser = sysUser.selectOne(new QueryWrapper<>(new SysUser().setUserName(sysUser.getUserName())));
        if (selSysUser == null) {
            log.info("该用户不存在");
            return ajaxJson.fail("用户名或密码错误");
        }
        String inputPassword = sysUser.getPassword();
        String selPassword = selSysUser.getPassword();
        if (!StringUtil.equals(DigestUtils.md5Hex(inputPassword), selPassword)) {
            log.info("密码错误");
            return ajaxJson.fail("用户名或密码错误");
        }
        //获取tokenSign
        SysProperty sysProperty = new SysProperty().setPropertyKey(PropertyConstant.TOKEN_SIGN);
        sysProperty = sysProperty.selectOne(new QueryWrapper<>(sysProperty));
        if (sysProperty == null) {
            return ajaxJson.fail("未设置"+PropertyConstant.TOKEN_SIGN+",请联系管理员设置");
        }
        String signKey = sysProperty.getPropertyValue();
        //校验通过.根据生产一个token返回,里面包含了userId
        String token = JWT.create().withAudience(selSysUser.getUserId()).sign(Algorithm.HMAC256(signKey));
        return ajaxJson.setData(token);
    }

}
