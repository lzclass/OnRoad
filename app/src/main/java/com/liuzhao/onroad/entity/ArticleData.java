package com.liuzhao.onroad.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by asus on 2016/1/24.
 */
public class ArticleData implements Serializable {
    private List<Article> dataList;

    public List<Article> getDataList() {
        return dataList;
    }

    public void setDataList(List<Article> dataList) {
        this.dataList = dataList;
    }
}
