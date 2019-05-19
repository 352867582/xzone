package com.xzone.xservice.app.service.impl;

import com.xzone.xinterface.app.model.Article;
import com.xzone.xservice.app.dao.ArticleMapper;
import com.xzone.xinterface.app.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author kongkong
 * @since 2019-05-19
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
