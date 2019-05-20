package com.xzone.admin.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzone.admin.base.BaseController;
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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@RestController
@RequestMapping("/payBankInfo")
@Slf4j(topic = "联行号查询")
public class PayBankInfoController extends BaseController<PayBankInfo> {

    @Autowired
    private HotSearchService hotSearchService;

    @PostMapping(value = "/selectPayBankInfoByNameOrNumber")
    public AjaxJson selectPayBankInfoByNameOrNumber(PayBankInfo payBankInfo) {
        log.info("联行号或名称查询:{}", payBankInfo);
        QueryWrapper<PayBankInfo> wrapper = new QueryWrapper<>();
        if (StringUtil.isNotBlank(payBankInfo.getBankName())) {
            wrapper.and(i -> i.like("BANK_NAME", payBankInfo.getBankName()).or().eq("LINE_NUMBER", payBankInfo.getBankName()));
        }
        wrapper.orderByAsc("LINE_NUMBER");
        Page<PayBankInfo> selectPage = (Page<PayBankInfo>) payBankInfo.selectPage(wrapper);
        if (selectPage.getRecords().size() > 0 && (payBankInfo.getCurrentPage() == null || payBankInfo.getCurrentPage() == 1)) {
            hotSearchService.addHotSearch(new HotSearch().setSearchType(1).setTag(payBankInfo.getBankName()));
        }
        return new AjaxJson().setData(selectPage).setHasNext(selectPage.hasNext());
    }
}
