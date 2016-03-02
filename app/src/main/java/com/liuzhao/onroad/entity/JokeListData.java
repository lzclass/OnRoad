package com.liuzhao.onroad.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuzhao on 2016/3/1.
 */
public class JokeListData implements Serializable {
    private List<JokeBean> data;

    public List<JokeBean> getData() {
        return data;
    }

    public void setData(List<JokeBean> data) {
        this.data = data;
    }
}
