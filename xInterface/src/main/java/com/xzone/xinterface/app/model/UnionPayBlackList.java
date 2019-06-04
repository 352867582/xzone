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
 * 银联黑名单
 * </p>
 *
 * @author kongkong
 * @since 2019-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UnionPayBlackList对象", description="银联黑名单")
public class UnionPayBlackList extends BaseModel<UnionPayBlackList> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "银联黑名单主键")
    @TableId("BLACK_LIST_ID")
    private String blackListId;

    @ApiModelProperty(value = "POS级品牌名")
    @TableField("POS_BRAND_NAME")
    private String posBrandName;

    @ApiModelProperty(value = "是否在黑名单中 0：否 1：是")
    @TableField("BLACK_FLAG")
    private Integer blackFlag;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    private Date createDate;


    @ApiModelProperty(value = "机构描述")
    @TableField("BRAND_DESC")
    private String brandDesc;


    @Override
    protected Serializable pkVal() {
        return this.blackListId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
