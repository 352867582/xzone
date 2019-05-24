package com.xzone.xinterface.app.service;

import com.xzone.xinterface.app.model.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
public interface ArticleService extends IService<Article> {

    public void testTask();
}
