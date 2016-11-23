package com.liuzhao.onroad.entity;

import java.io.Serializable;

/**
 * Created by liuzhao on 2016/3/14.
 * 首页
 */
public class DayWordData implements Serializable {
    private String id;
    private String dateTime;
    private String content;
    private String textAuthor;
    private String ImageAuthor;
    private String imageUrl;

    public String getImageAuthor() {
        return ImageAuthor;
    }

    public void setImageAuthor(String imageAuthor) {
        ImageAuthor = imageAuthor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTextAuthor() {
        return textAuthor;
    }

    public void setTextAuthor(String textAuthor) {
        this.textAuthor = textAuthor;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
