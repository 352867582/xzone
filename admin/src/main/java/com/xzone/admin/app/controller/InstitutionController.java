package com.xzone.admin.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzone.utils.StringUtil;
import com.xzone.xinterface.app.model.HotSearch;
import com.xzone.xinterface.app.model.PayBankInfo;
import com.xzone.xinterface.app.service.HotSearchService;
import com.xzone.xinterface.common.vo.AjaxJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xzone.admin.base.BaseController;
import com.xzone.xinterface.app.model.Institution;

/**
 * <p>
 * 收单机构信息表 前端控制器
 * </p>
 *
 * @author kongkong
 * @since 2019-05-21
 */
@RestController
@RequestMapping("/institution")
@Slf4j(topic = "收单机构")
public class InstitutionController extends BaseController<Institution> {

    @Autowired
    private HotSearchService hotSearchService;

    @PostMapping(value = "/selectInstitutionByNameOrCode")
    public AjaxJson selectInstitutionByNameOrCode(Institution institution) {
        log.info("收单机构号或名称查询:{}", institution);
        QueryWrapper<Institution> wrapper = new QueryWrapper<>();
        if (StringUtil.isNotBlank(institution.getName())) {
            wrapper.and(i -> i.like("NAME", institution.getName()).or().eq("CODE", institution.getName()));
        }
        wrapper.orderByAsc("CODE");
        Page<Institution> selectPage = (Page<Institution>) institution.selectPage(wrapper);
        if (selectPage.getRecords().size() > 0 && (institution.getCurrentPage() == null || institution.getCurrentPage() == 1)) {
            hotSearchService.addHotSearch(new HotSearch().setSearchType(3).setTag(institution.getName()));
        }
        return new AjaxJson().setData(selectPage).setHasNext(selectPage.hasNext());
    }


}
