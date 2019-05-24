package com.xzone.admin.app.controller;


import com.xzone.xinterface.app.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xzone.admin.base.BaseController;
import com.xzone.xinterface.app.model.Article;

import javax.annotation.Resource;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController<Article> {

}
