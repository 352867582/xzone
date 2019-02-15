package com.xzone.xinterface.shopUsers.model;

import java.util.Date;
import com.xzone.xinterface.base.BaseModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 网站用户
 * </p>
 *
 * @author author
 * @since 2019-02-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ShopUsers extends BaseModel<ShopUsers> {

    private static final long serialVersionUID = 1L;

    @TableId("USER_ID")
    private String userId;

    /**
     * 我的邀请人ID，可为空
     */
    @TableField("MY_LEADER_ID")
    private String myLeaderId;

    /**
     * 手机号
     */
    @TableField("USER_PHONE")
    private String userPhone;

    /**
     * 密码，在app登录用到
     */
    @TableField("USER_PWD")
    private String userPwd;

    /**
     * 用户昵称
     */
    @TableField("USER_NICK")
    private String userNick;

    /**
     * 性别，0女，1男
     */
    @TableField("USER_SEX")
    private Integer userSex;

    /**
     * 用户公众号ID
     */
    @TableField("OPEN_ID")
    private String openId;

    /**
     * 用户微信头像URL
     */
    @TableField("USER_PHOTO")
    private String userPhoto;

    /**
     * 用户姓名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 注册时间
     */
    @TableField("REGI_DATE")
    private Date regiDate;

    /**
     * 用户状态，0无效，1有效
     */
    @TableField("USER_STATUS")
    private Integer userStatus;

    /**
     * 是否会员，0否，1是
     */
    @TableField("MEMBER_FLAG")
    private Integer memberFlag;

    /**
     * 会员有效期截至日期
     */
    @TableField("MEMBER_EXPIRED_DATE")
    private Date memberExpiredDate;

    /**
     * 会员类型，0月会员，1半年会员，2年度会员
     */
    @TableField("MEMBER_TYPE")
    private Integer memberType;

    /**
     * 出生年月
     */
    private String dateOfBirth;

    /**
     * 所在地区
     */
    @TableField("USER_AREA")
    private String userArea;

    /**
     * 详细地址
     */
    @TableField("AREA_DETAIL")
    private String areaDetail;

    /**
     * 用户代码，格式yyyyMMddXXXX，X为增长数字，以0补齐
     */
    @TableField("USER_CODE")
    private String userCode;

    /**
     * 推荐人的邀请码
     */
    @TableField("MY_LEADER_CODE")
    private String myLeaderCode;

    /**
     * 系统运营账号，0否，1是
     */
    @TableField("ADMIN")
    private Integer admin;

    /**
     * 用户积分
     */
    @TableField("USER_SCORE")
    private Integer userScore;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
