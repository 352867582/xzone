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
import java.util.Date;

/**
 * <p>
 * pos应答码
 * </p>
 *
 * @author kongkong
 * @since 2019-05-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="PosRetCode对象", description="pos应答码")
public class PosRetCode extends BaseModel<PosRetCode> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "应答码主键")
    @TableId("RET_CODE_ID")
    private String retCodeId;

    @ApiModelProperty(value = "应答码")
    @TableField("RET_CODE")
    private String retCode;

    @ApiModelProperty(value = "应答码含义")
    @TableField("CODE_MEAN")
    private String codeMean;

    @ApiModelProperty(value = "A:校验成功 B：校验失败,可重试 c:交易失败,不需要重试 D：交易失败，终端操作员处理 E：交易失败,系统故障，不需要重试")
    @TableField("CODE_TYPE")
    private String codeType;

    @ApiModelProperty(value = "原因/采取的措施")
    @TableField("REASON")
    private String reason;

    @ApiModelProperty(value = "提示语")
    @TableField("TIP_MSG")
    private String tipMsg;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    private Date createDate;


    @Override
    protected Serializable pkVal() {
        return this.retCodeId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
