package com.xzone.xinterface.app.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xzone.xinterface.base.BaseModel;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="MccCode对象", description="")
public class MccCode extends BaseModel<MccCode> {

    private static final long serialVersionUID = 1L;

    @TableId("CODE")
    private String code;

    @TableField("MERCHANT_NAME")
    private String merchantName;

    @TableField("MERCHANT_RATE_NEW")
    private String merchantRateNew;

    @TableField("MERCHANT_RATE_OLD")
    private String merchantRateOld;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
