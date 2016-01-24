package com.liuzhao.onroad.entity;

import java.io.Serializable;

/**
 * Created by asus on 2016/1/24.
 */
public class Article implements Serializable {
    /*标题*/
    private String title;
    /*创建时间*/
    private String createDateTime;
    /*内容*/
    private String content;
    /*作者*/
    private String author;
    /*头像*/
    private String headPic;
    /*阅读数*/
    private String readCount;
    /*收藏数*/
    private String collectCount;
    /*评论数*/
    private String commentCount;
    /*分享数*/
    private String shareCount;
    /*文字类型*/
    private String ArticleTypes;

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(String collectCount) {
        this.collectCount = collectCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getShareCount() {
        return shareCount;
    }

    public void setShareCount(String shareCount) {
        this.shareCount = shareCount;
    }

    public String getArticleTypes() {
        return ArticleTypes;
    }

    public void setArticleTypes(String articleTypes) {
        ArticleTypes = articleTypes;
    }

    /*文章封面*/
    private String coverPic;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
