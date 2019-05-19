package com.xzone.xinterface.app.model;

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
 * 文章表
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Article对象", description="文章表")
public class Article extends BaseModel<Article> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章ID")
    @TableId("ARTICLE_ID")
    private String articleId;

    @ApiModelProperty(value = "标题")
    @TableField("TITLE")
    private String title;

    @ApiModelProperty(value = "类型 1:新闻 2：使用帮助 3:广告")
    @TableField("TYPE")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    private Date createDate;

    @ApiModelProperty(value = "浏览次数")
    @TableField("VIEW_COUNT")
    private Integer viewCount;

    @ApiModelProperty(value = "点赞次数")
    @TableField("THUMBS_UP")
    private Integer thumbsUp;

    @ApiModelProperty(value = "评论次数")
    @TableField("COMMENT_COUNT")
    private Integer commentCount;

    @ApiModelProperty(value = "评论次数")
    @TableField("CONTENT")
    private String content;

    @Override
    protected Serializable pkVal() {
        return this.articleId;
    }

}
