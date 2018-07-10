package com.baizhi.cmfz.service.imple;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/7/8.
 */

@Service
public class ArticleServiceImple implements ArticleService{
    @Autowired
    private ArticleDao ad;

    /**
     * @Description 添加文章信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param       article文章信息
     * @Exception
     */
    @Override
    @Transactional
    public void addArticle(Article article) {
        ad.insertArticle(article);
    }
}
