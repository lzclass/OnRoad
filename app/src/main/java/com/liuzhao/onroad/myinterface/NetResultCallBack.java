package com.liuzhao.onroad.myinterface;

import java.util.List;

/**
 * Created by liuzhao on 2016/11/18.
 * 网络请求回调接口
 */
public interface NetResultCallBack<T> {
    void onSuccess(T result);// 数据获取成功
    void onError(int code, String msg);// 出现意外问题
}
