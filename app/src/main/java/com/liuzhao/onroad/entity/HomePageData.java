package com.liuzhao.onroad.entity;

import java.io.Serializable;

/**
 * Created by liuzhao on 2016/3/14.
 * 首页
 */
public class HomePageData implements Serializable {
    private String imgUrl;
    private String imgAuthor;
    private String imgNo;
    private String content;
    private String txtAuthor;
    private String date;

    public String getImgNo() {
        return imgNo;
    }

    public void setImgNo(String imgNo) {
        this.imgNo = imgNo;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTxtAuthor() {
        return txtAuthor;
    }

    public void setTxtAuthor(String txtAuthor) {
        this.txtAuthor = txtAuthor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgAuthor() {
        return imgAuthor;
    }

    public void setImgAuthor(String imgAuthor) {
        this.imgAuthor = imgAuthor;
    }
}
