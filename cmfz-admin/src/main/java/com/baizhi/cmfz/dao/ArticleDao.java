package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/7/8.
 */
public interface ArticleDao {
    /**
     * @Description 添加文章信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param       传获得的文章信息
     * @Exception
     */
    public Integer insertArticle(@Param("article") Article article);
}
