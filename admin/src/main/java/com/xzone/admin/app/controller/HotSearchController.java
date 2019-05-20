package com.xzone.admin.app.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xzone.admin.base.BaseController;
import com.xzone.xinterface.app.model.HotSearch;

/**
 * <p>
 * 热搜信息表 前端控制器
 * </p>
 *
 * @author kongkong
 * @since 2019-05-20
 */
@RestController
@RequestMapping("/hotSearch")
public class HotSearchController extends BaseController<HotSearch> {

}
