package com.xzone.admin.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzone.utils.StringUtil;
import com.xzone.xinterface.common.vo.AjaxJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xzone.admin.base.BaseController;
import com.xzone.xinterface.app.model.BankCardBin;
import sun.rmi.runtime.Log;

/**
 * <p>
 * 银行卡BIN 前端控制器
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@RestController
@RequestMapping("/bankCardBin")
@Slf4j
public class BankCardBinController extends BaseController<BankCardBin> {

    @PostMapping(value = "/selectBankCardBin")
    public AjaxJson selectBankCardBin(BankCardBin bankCardBin) {
        log.info("银行卡bin查询:{}", bankCardBin);
        if (StringUtil.isBlank(bankCardBin.getCardBin())) {
            return new AjaxJson().fail("卡bin信息不能为空");
        }
        //小于等于6位的直接右like
        QueryWrapper<BankCardBin> wrapper = new QueryWrapper<>();
        if (bankCardBin.getCardBin().length() <= 6) {
            wrapper.likeRight("CARD_BIN", bankCardBin.getCardBin());
        } else {//大于6后根据卡bin长度截取
            wrapper.apply("1 = 1 AND CARD_BIN LIKE concat(left({0},CARD_BIN_LEN),'%')", bankCardBin.getCardBin());
        }
        wrapper.orderByDesc("CARD_BIN_ID");
        Page<BankCardBin> bankCardBinIPage = (Page<BankCardBin>) bankCardBin.selectPage(wrapper);
        return new AjaxJson().setHasNext(bankCardBinIPage.hasNext()).setData(bankCardBinIPage);
    }

}
