package com.xzone.xinterface.sys.model;

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
 * 系统属性表
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysProperty对象", description="系统属性表")
public class SysProperty extends BaseModel<SysProperty> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "属性表主键")
    @TableId("PROPERTY_ID")
    private String propertyId;

    @ApiModelProperty(value = "属性键")
    @TableField("PROPERTY_KEY")
    private String propertyKey;

    @ApiModelProperty(value = "属性值")
    @TableField("PROPERTY_VALUE")
    private String propertyValue;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    private Date createDate;

    @ApiModelProperty(value = "属性名")
    @TableField("PROPERTY_NAME")
    private String propertyName;


    @Override
    protected Serializable pkVal() {
        return this.propertyId;
    }

}
