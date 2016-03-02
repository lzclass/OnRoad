package com.liuzhao.onroad.entity;

/**
 * Created by liuzhao on 2016/3/1.
 */
public class JokeListResult extends BaseResult {
    private JokeListData result;

    public JokeListData getResult() {
        if (result == null) {
            result = new JokeListData();
        }
        return result;
    }

    public void setResult(JokeListData result) {
        this.result = result;
    }
}
