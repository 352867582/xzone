package com.xzone.admin.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzone.utils.StringUtil;
import com.xzone.xinterface.app.model.HotSearch;
import com.xzone.xinterface.app.service.HotSearchService;
import com.xzone.xinterface.common.vo.AjaxJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xzone.admin.base.BaseController;
import com.xzone.xinterface.app.model.UnionPayBlackList;

import javax.annotation.Resource;

/**
 * <p>
 * 银联黑名单 前端控制器
 * </p>
 *
 * @author kongkong
 * @since 2019-06-04
 */
@RestController
@RequestMapping("/unionPayBlackList")
@Slf4j
public class UnionPayBlackListController extends BaseController<UnionPayBlackList> {

    @Resource
    private HotSearchService hotSearchService;

    @PostMapping(value = "/unionPayBlackList")
    public AjaxJson selectUnionPayBlackList(UnionPayBlackList unionPayBlackList) {
        log.info("银联黑名单查询:{}",unionPayBlackList);
        String posBrandName = unionPayBlackList.getPosBrandName();
        if (StringUtil.isNotBlank(posBrandName)) {
            unionPayBlackList.setPosBrandName(null);
        }
        QueryWrapper<UnionPayBlackList> queryWrapper = new QueryWrapper<>(unionPayBlackList);
        if (StringUtil.isNotBlank(posBrandName)) {
            queryWrapper.like("POS_BRAND_NAME", posBrandName);
        }
        queryWrapper.orderByDesc("CREATE_DATE");
        Page<UnionPayBlackList> blackListIPage = (Page<UnionPayBlackList>) unionPayBlackList.selectPage(queryWrapper);
        if (blackListIPage.getRecords().size() > 0 && (unionPayBlackList.getCurrentPage() == null || unionPayBlackList.getCurrentPage() == 1)) {
            hotSearchService.addHotSearch(new HotSearch().setSearchType(4).setTag(posBrandName));
        }
        return new AjaxJson().setHasNext(blackListIPage.hasNext()).setData(blackListIPage);
    }
}
