package com.xzone.admin.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzone.admin.base.BaseController;
import com.xzone.utils.StringUtil;
import com.xzone.xinterface.app.model.HotSearch;
import com.xzone.xinterface.app.model.PosRetCode;
import com.xzone.xinterface.app.service.HotSearchService;
import com.xzone.xinterface.common.vo.AjaxJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * pos应答码 前端控制器
 * </p>
 *
 * @author kongkong
 * @since 2019-05-21
 */
@RestController
@RequestMapping("/posRetCode")
@Slf4j(topic = "POS应答码")
public class PosRetCodeController extends BaseController<PosRetCode> {

    @Autowired
    private HotSearchService hotSearchService;

    @PostMapping(value = "/selectPosRetCodeByCodeOrTipMsg")
    public AjaxJson selectPosRetCodeByCodeOrTipMsg(PosRetCode posRetCode) {
        log.info("pos应答码查询:{}", posRetCode);
        QueryWrapper<PosRetCode> wrapper = new QueryWrapper<>();
        if (StringUtil.isNotBlank(posRetCode.getRetCode())) {
            wrapper.and(i -> i.like("TIP_MSG", posRetCode.getRetCode()).or().eq("RET_CODE", posRetCode.getRetCode()));
        }
        wrapper.orderByAsc("RET_CODE");
        Page<PosRetCode> selectPage = (Page<PosRetCode>) posRetCode.selectPage(wrapper);
        if (selectPage.getRecords().size() > 0 && (posRetCode.getCurrentPage() == null || posRetCode.getCurrentPage() == 1)) {
            hotSearchService.addHotSearch(new HotSearch().setSearchType(2).setTag(posRetCode.getRetCode()));
        }
        return new AjaxJson().setData(selectPage).setHasNext(selectPage.hasNext());
    }

}
