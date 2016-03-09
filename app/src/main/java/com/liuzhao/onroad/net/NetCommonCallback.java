package com.liuzhao.onroad.net;

import com.liuzhao.onroad.activity.BaseActivity;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;

/**
 * Created by liuzhao on 2016/3/2.
 */
public class NetCommonCallback<T> implements Callback.CommonCallback<String> {
    private Class<T> clazz;
    private BaseActivity context;
    private boolean isShow;// 是否显示dialog
    private boolean isShowToast = true;

    public NetCommonCallback(Class<T> clazz, BaseActivity context) {
        this.clazz = clazz;
        this.context = context;
    }

    public NetCommonCallback(Class<T> clazz, BaseActivity context,
                             boolean isShowDialog, boolean isShowToast) {
        this.clazz = clazz;
        this.context = context;
        this.isShow = isShowDialog;
        this.isShowToast = isShowToast;
    }

    @Override
    public void onSuccess(String result) {
        LogUtil.d("接口返回数据：" + result);
//        T t = JsonUtils.parseJson(result, clazz);
//        BaseResult data = (BaseResult) t;
    }

    @Override
    public void onError(Throwable throwable, boolean isOnCallback) {
        LogUtil.d("接口返回"+throwable.getMessage());
    }

    @Override
    public void onCancelled(CancelledException e) {
        LogUtil.e("接口返回onCancelled" + e.getMessage());
    }

    @Override
    public void onFinished() {
        LogUtil.d("接口返回onFinished");
    }

}
