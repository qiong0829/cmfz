package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/8.
 */
public class Article {
    private String articleId;
    private String articleName;
    private String guruId;
    private String articleBlurb;
    @JSONField(format = "yyyy-MM-dd")
    private Date articlePushtime;
    private String articleStatus;

    public Article() {
    }

    public Article(String articleId, String articleName, String guruId, String articleBlurb, Date articlePushtime, String articleStatus) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.guruId = guruId;
        this.articleBlurb = articleBlurb;
        this.articlePushtime = articlePushtime;
        this.articleStatus = articleStatus;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getArticleBlurb() {
        return articleBlurb;
    }

    public void setArticleBlurb(String articleBlurb) {
        this.articleBlurb = articleBlurb;
    }

    public Date getArticlePushtime() {
        return articlePushtime;
    }

    public void setArticlePushtime(Date articlePushtime) {
        this.articlePushtime = articlePushtime;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", guruId='" + guruId + '\'' +
                ", articleBlurb='" + articleBlurb + '\'' +
                ", articlePushtime='" + articlePushtime + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                '}';
    }
}
