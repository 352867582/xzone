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
@ApiModel(value="AreaOrgCode对象", description="")
public class AreaOrgCode extends BaseModel<AreaOrgCode> {

    private static final long serialVersionUID = 1L;

    @TableId("AREA_ORG_CODE")
    private String areaOrgCode;

    @TableField("NEW_MEANING")
    private String newMeaning;

    @TableField("OLD_MEANING")
    private String oldMeaning;

    @TableField("CODE_TYPE")
    private String codeType;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
