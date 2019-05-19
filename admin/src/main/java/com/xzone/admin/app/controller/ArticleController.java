package com.xzone.admin.app.controller;


import com.xzone.admin.base.BaseController;
import com.xzone.admin.interceptor.SysPermission;
import com.xzone.utils.SerialNo;
import com.xzone.xinterface.app.model.Article;
import com.xzone.xinterface.common.vo.AjaxJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @Override
    @SysPermission
    public AjaxJson selectList(Article article) {
        return super.selectList(article);
    }

    @Override
    public AjaxJson create(Article article) {
        article.setCreateDate(new Date()).setArticleId(SerialNo.getUnId());
        return super.create(article);
    }
    @PostMapping(value = "/test")
    public String test() {
        return "test";
    }
}
