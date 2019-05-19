package com.xzone.xinterface.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xzone.xinterface.base.BaseModel;
import com.xzone.xinterface.common.vo.validate.NotNull;
import com.xzone.xinterface.common.vo.validate.ValidateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="系统用户表")
public class SysUser extends BaseModel<SysUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户主键")
    @TableId("USER_ID")
    private String userId;

    @ApiModelProperty(value = "用户名")
    @TableField("USER_NAME")
    @NotNull(validateGroup = ValidateEnum.LOGIN_GROUP)
    private String userName;

    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    @NotNull(validateGroup = ValidateEnum.LOGIN_GROUP)
    private String password;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    private Date createDate;

    @ApiModelProperty(value = "头像")
    @TableField("HEAR_IMG")
    private String hearImg;

    @ApiModelProperty(value = "可用状态 1：可用  2：不可用")
    @TableField("USED_STATUS")
    private Integer usedStatus;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
