package com.xzone.xinterface.app.model;

import com.xzone.xinterface.base.BaseModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="PayMccInfo对象", description="")
public class PayMccInfo extends BaseModel<PayMccInfo> {

    private static final long serialVersionUID = 1L;

    @TableId("MCC_INFO_ID")
    private String mccInfoId;

    @ApiModelProperty(value = "mcc编码")
    @TableField("MCC_CODE")
    private String mccCode;

    @ApiModelProperty(value = "微信经营编码")
    @TableField("WECHAT_CODE")
    private String wechatCode;

    @ApiModelProperty(value = "支付宝经验代码")
    @TableField("ALIPAY_CODE")
    private String alipayCode;

    @ApiModelProperty(value = "MCC一级分类")
    @TableField("LEVEL_TYPE")
    private String levelType;

    @ApiModelProperty(value = "MCC二级分类")
    @TableField("LEVEL_SECOND_TYPE")
    private String levelSecondType;

    @ApiModelProperty(value = "MCC三级分类")
    @TableField("LEVEL_THIRD_TYPE")
    private String levelThirdType;

    @ApiModelProperty(value = "MCC说明")
    @TableField("MCC_DESC")
    private String mccDesc;


    @Override
    protected Serializable pkVal() {
        return this.mccInfoId;
    }

}
