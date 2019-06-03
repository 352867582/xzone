package com.xzone.admin.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzone.utils.StringUtil;
import com.xzone.xinterface.app.service.ArticleService;
import com.xzone.xinterface.common.vo.AjaxJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xzone.admin.base.BaseController;
import com.xzone.xinterface.app.model.Article;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
@Slf4j
public class ArticleController extends BaseController<Article> {

    @PostMapping(value = "/selectArticlePageList")
    public AjaxJson selectArticlePageList(Article article) {
        log.info("文章信息查询:{}", article);
        List<String> articleTypeList = new ArrayList<>();
        if (StringUtil.isNotBlank(article.getArticleType())) {
            articleTypeList = Arrays.asList(article.getArticleType().split(","));
            article.setArticleType(null);

        }
        QueryWrapper<Article> wrapper = new QueryWrapper<>(article).orderByAsc("TOP_INDEX");
        if (articleTypeList.size() > 0) {
            wrapper.in("ARTICLE_TYPE", articleTypeList);
        }
        Page<Article> page = (Page<Article>) article.selectPage(wrapper);
        return new AjaxJson().setData(page).setHasNext(page.hasNext());
    }
}
