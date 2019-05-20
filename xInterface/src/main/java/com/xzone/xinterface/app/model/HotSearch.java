package com.xzone.xinterface.app.model;

import java.util.Date;
import com.alibaba.fastjson.JSON;
import com.xzone.xinterface.base.BaseModel;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableId;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.alibaba.fastjson.JSON;
import com.xzone.xinterface.common.vo.validate.NotNull;
import com.xzone.xinterface.common.vo.validate.ValidateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 热搜信息表
 * </p>
 *
 * @author kongkong
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="HotSearch对象", description="热搜信息表")
public class HotSearch extends BaseModel<HotSearch> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "热搜表主键")
    @TableId("HOT_ID")
    private String hotId;

    @ApiModelProperty(value = "热搜标签")
    @TableField("TAG")
    @NotNull(validateGroup = ValidateEnum.HOT_SEARCH_GROUP)
    private String tag;

    @ApiModelProperty(value = "热搜次数")
    @TableField("SEARCH_NUM")
    private Integer searchNum;

    @TableField("CREATE_DATE")
    private Date createDate;

    @ApiModelProperty(value = "热搜状态 1:有效 2：无效")
    @TableField("TAG_STATUS")
    private Integer tagStatus;

    @NotNull(validateGroup = ValidateEnum.HOT_SEARCH_GROUP)
    @ApiModelProperty(value = "热搜类型 1：联行号查询")
    @TableField("SEARCH_TYPE")
    private Integer searchType;


    @Override
    protected Serializable pkVal() {
        return this.hotId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
