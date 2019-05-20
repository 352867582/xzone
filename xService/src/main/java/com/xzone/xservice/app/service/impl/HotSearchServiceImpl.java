package com.xzone.xservice.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzone.utils.SerialNo;
import com.xzone.utils.StringUtil;
import com.xzone.xinterface.app.model.HotSearch;
import com.xzone.xinterface.common.vo.AjaxJson;
import com.xzone.xinterface.common.vo.validate.ValidateEnum;
import com.xzone.xinterface.common.vo.validate.ValidateUtil;
import com.xzone.xservice.app.dao.HotSearchMapper;
import com.xzone.xinterface.app.service.HotSearchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 热搜信息表 服务实现类
 * </p>
 *
 * @author kongkong
 * @since 2019-05-20
 */
@Service
@Slf4j(topic = "热搜标签操作")
public class HotSearchServiceImpl extends ServiceImpl<HotSearchMapper, HotSearch> implements HotSearchService {

    @Override
    public void addHotSearch(HotSearch hotSearch) {
        AjaxJson ajaxJson = ValidateUtil.validate(hotSearch, ValidateEnum.HOT_SEARCH_GROUP);
        if (ajaxJson.getRet() != AjaxJson.RET_SUCCESS) {
            return;
        }
        //查询该类型的hot标签是否已存在
        HotSearch selHotSearch = hotSearch.selectOne(new QueryWrapper<>(new HotSearch().setTag(hotSearch.getTag()).setSearchType(hotSearch.getSearchType())));
        if (selHotSearch == null) {
            hotSearch.setHotId(SerialNo.getUnId()).setCreateDate(new Date()).setSearchNum(1).insert();
        } else {
            //存在了,该类型的标签搜索次数直接加1
            selHotSearch.setSearchNum(selHotSearch.getSearchNum() + 1).updateById();
        }
    }
}
