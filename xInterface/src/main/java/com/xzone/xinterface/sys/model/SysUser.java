package com.xzone.xinterface.sys.model;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.xzone.xinterface.base.BaseModel;
import java.io.Serializable;

import com.xzone.xinterface.common.vo.validate.NotNull;
import com.xzone.xinterface.common.vo.validate.ValidateEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2019-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUser extends BaseModel<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 真实名称
     */
    private String realname;

    /**
     * 用户名
     */
    @NotNull(validateGroup = ValidateEnum.LOGIN_GROUP)
    private String username;

    /**
     * 头像
     */
    private String portrait;

    /**
     * 密码
     */
    @NotNull(validateGroup = ValidateEnum.LOGIN_GROUP)
    private String password;

    private String salt;

    /**
     * 邮件
     */
    private String email;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 系统用户的状态
     */
    private String status;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    /**
     * '代理商标示，0系统用户，1代理商'
     */
    private String agentFlag;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
