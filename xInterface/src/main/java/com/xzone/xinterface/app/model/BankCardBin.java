package com.xzone.xinterface.app.model;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 银行卡BIN
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BankCardBin对象", description="银行卡BIN")
public class BankCardBin extends BaseModel<BankCardBin> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卡BIN校验长度")
    @TableId(value = "CARD_BIN_ID", type = IdType.AUTO)
    private Integer cardBinId;

    @ApiModelProperty(value = "发卡行名称")
    @TableField("BANK_NAME")
    private String bankName;

    @ApiModelProperty(value = "发卡行行号")
    @TableField("BANK_INS_CODE")
    private String bankInsCode;

    @ApiModelProperty(value = "银行卡名称")
    @TableField("CARD_NAME")
    private String cardName;

    @ApiModelProperty(value = "卡号长度")
    @TableField("CARD_NO_LEN")
    private Integer cardNoLen;

    @ApiModelProperty(value = "卡BIN")
    @TableField("CARD_BIN")
    private String cardBin;

    @ApiModelProperty(value = "卡类型 -1不限，0借记卡，1贷记卡，2符合卡，3其他卡")
    @TableField("CARD_TYPE")
    private Integer cardType;

    @TableField("CARD_BIN_LEN")
    private Integer cardBinLen;

    @TableField("SHORT_BANK_NAME")
    private String shortBankName;

    @TableField("CARD_BANK_NAME")
    private String cardBankName;

    @ApiModelProperty(value = "银行简称")
    @TableField("BANK_SHORT_CODE")
    private String bankShortCode;


    @Override
    protected Serializable pkVal() {
        return this.cardBinId;
    }

}
