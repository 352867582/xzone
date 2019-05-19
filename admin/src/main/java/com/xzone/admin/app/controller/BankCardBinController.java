package com.xzone.admin.app.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xzone.admin.base.BaseController;
import com.xzone.xinterface.app.model.BankCardBin;

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
public class BankCardBinController extends BaseController<BankCardBin> {

}
