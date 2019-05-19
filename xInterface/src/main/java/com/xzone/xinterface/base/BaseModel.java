package com.xzone.xinterface.base;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class BaseModel<T extends BaseModel> extends Model<T> {

    private static final long serialVersionUID = 1L;

    public BaseModel() {

    }

    /**
     * 分页查新当前页
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "分页当前页")
    private Integer currentPage;

    /**
     * 分页查询条数
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "分页条数")
    private Integer pageSize;

    /**
     * 需要查询的字段
     */

    @TableField(exist = false)
    @ApiModelProperty(value = "需要查询的字段")
    private String sqlSelect;

    /**
     * 需要过滤的字段
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "不需要查询的字段")
    private String sqlFilterSelect;

    /**
     * 排序
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "排序")
    private String orderBy;

    public IPage<T> selectPage(QueryWrapper<T> queryWrapper) {
        return super.selectPage(new Page<>(currentPage, pageSize), getRebuildWrapper(queryWrapper));
    }

    public List<T> selectList(QueryWrapper<T> queryWrapper) {
        return super.selectList(getRebuildWrapper(queryWrapper));
    }

    public T selectOne(QueryWrapper<T> queryWrapper) {
        return super.selectOne(getRebuildWrapper(queryWrapper));
    }

    private QueryWrapper<T> getRebuildWrapper(QueryWrapper<T> queryWrapper) {
        //sql 查询过滤(正向过滤)
        if (StringUtils.isNotBlank(sqlSelect)) {
            queryWrapper.select(sqlSelect.split(","));
        }
        //sql 查询过滤(反向过滤,即传入的参数不查询)
        if (StringUtils.isNotBlank(sqlFilterSelect)) {
            //获取实体类的注解参数
            List<String> filterColumn = Arrays.asList(sqlFilterSelect.split(","));
            if (filterColumn.size() > 0) {
                Field[] fields = getClass().getDeclaredFields();
                List<String> selectList = new ArrayList<>();
                for (Field field : fields) {
                    TableField tableField = field.getAnnotation(TableField.class);
                    TableId tableId = field.getAnnotation(TableId.class);
                    if (tableField == null && tableId == null) {
                        continue;
                    }
                    if (tableId != null) {
                        if (StringUtils.isNotBlank(tableId.value())) {
                            if (!filterColumn.contains(tableId.value())) {
                                selectList.add(tableId.value());
                            }
                        }
                        continue;
                    }
                    if (tableField.exist() && StringUtils.isNotBlank(tableField.value())) {
                        if (!filterColumn.contains(tableField.value())) {
                            selectList.add(tableField.value());
                        }
                    }
                }
                queryWrapper.select(selectList.toArray(new String[0]));
            }
        }
        if (StringUtils.isNotBlank(orderBy)) {
            queryWrapper.apply(" 1 = 1 ORDER BY {0}", orderBy);
        }
        return queryWrapper;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
