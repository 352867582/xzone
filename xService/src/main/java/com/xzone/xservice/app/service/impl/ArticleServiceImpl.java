package com.xzone.xservice.app.service.impl;

import com.xzone.xinterface.app.model.Article;
import com.xzone.xservice.app.dao.ArticleMapper;
import com.xzone.xinterface.app.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public void testTask() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("task end");
    }
}
