package com.xzone.xinterface.app.model;

import java.util.Date;
import com.alibaba.fastjson.JSON;
import com.xzone.xinterface.base.BaseModel;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableId;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 收单机构信息表
 * </p>
 *
 * @author kongkong
 * @since 2019-05-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Institution对象", description="收单机构信息表")
public class Institution extends BaseModel<Institution> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收单机构信息表主键")
    @TableId("INSTITUTION_ID")
    private String institutionId;

    @ApiModelProperty(value = "机构名称")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "机构编号")
    @TableField("CODE")
    private String code;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    private Date createDate;


    @Override
    protected Serializable pkVal() {
        return this.institutionId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
