package com.xzone.xinterface.app.model;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xzone.xinterface.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@ApiModel(value="PayBankInfo对象", description="")
public class PayBankInfo extends BaseModel<PayBankInfo> {

    private static final long serialVersionUID = 1L;

    @TableId("BANK_ID")
    private String bankId;

    @ApiModelProperty(value = "联行号")
    @TableField("LINE_NUMBER")
    private String lineNumber;

    @ApiModelProperty(value = "银行代码")
    @TableField("BANK_CODE")
    private String bankCode;

    @ApiModelProperty(value = "城市代码")
    @TableField("CITY_CODE")
    private String cityCode;

    @ApiModelProperty(value = "银行名称")
    @TableField("BANK_NAME")
    private String bankName;


    @Override
    protected Serializable pkVal() {
        return this.bankId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
